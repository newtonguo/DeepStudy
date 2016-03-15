package com.zhiyin.event.engine.producer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.jms.DeliveryMode;
import javax.jms.JMSException;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhiyin.event.engine.body.EventEntity;
import com.zhiyin.event.engine.util.AmqProducerTool;
import com.zhiyin.event.engine.util.ConfigUtil;

public class EventProducer {
	
	private static Logger logger = LoggerFactory.getLogger(EventProducer.class);

	// 同一个应用下面多个EventProducer实例时，控制每个实例是否打印日志
	// 如果想关闭需要显示的 setIsLoggerEnabled(false)
	private boolean isLoggerEnabled = true;

	private final int BLOKING_SIZE = 10000;
	private String brokerUrl;
	private String queueName;
	private AmqProducerTool producer;
	private static EventProducer defaultEngine;
	private static ConcurrentHashMap<String, EventProducer> enginePool = new ConcurrentHashMap<String, EventProducer>();

	private final AtomicBoolean senderStarted = new AtomicBoolean(false);
	private final ExecutorService exec = Executors.newFixedThreadPool(1, new ThreadFactory() {
		public Thread newThread(Runnable r) {
			return new Thread(r, "EventEngine Publish Task");
		}
	});
	private final BlockingQueue<String> eventList = new LinkedBlockingQueue<String>(BLOKING_SIZE);

	private EventProducer() {}
	private EventProducer(String brokerURL) {
		this.brokerUrl = brokerURL;
	}

	@Deprecated
	public static synchronized EventProducer newInstance() {
		if (defaultEngine == null) {
			defaultEngine = new EventProducer();
		}
		return defaultEngine;
	}

	public static synchronized EventProducer getInstance() {
		if (defaultEngine == null) {
			defaultEngine = new EventProducer();
		}
		return defaultEngine;
	}

	public static EventProducer getInstance(String brokerURL) {
		return getInstance(brokerURL, null);
	}

	// 同一进程下，多个服务希望连接到同一个url，但是需要不同的engine配置（比如支持不同队列）
	public static EventProducer getInstance(String brokerURL, String systemID) {
		if (brokerURL == null) {
			return getInstance(); // return default
		}

		String key = brokerURL + StringUtils.trimToEmpty(systemID);
		EventProducer engine = enginePool.get(key);
		if (engine == null) {
			engine = new EventProducer(brokerURL);
			EventProducer ret = enginePool.putIfAbsent(key, engine);
			// ref: http://wxl24life.iteye.com/admin/blogs/1746794
			if (ret != null) {
				engine = ret;
			}
		}
		return engine;
	}

	// 用于发送普通消息（String报文，而不局限于UmetripEvent）
	// 如果只用于发送普通消息，需要使用setQueueName另外指定queue的名字
	public void publish(String msg) {
		if (senderStarted.compareAndSet(false, true)) {
			sendToAmq();
		}
		boolean isSuccess = eventList.offer(msg);
		if (!isSuccess) {
			logger.info(queueName + ", blocking list is full!! MSG: " + msg);
		} else if (logger.isDebugEnabled()) {
			logger.debug("MSG for " + queueName + ", isSuccess=true");
		}
	}

	public void publish(EventEntity event) {
		publish(event.serialize());
	}

	private void sendToAmq() {
		if (logger.isDebugEnabled()) {
			logger.debug(queueName + ", call sendToAmq()");
		}
		exec.execute(new Runnable() {
			public void run() {
				while (!exec.isTerminated()) {
					try {
						if (getProducer() != null) {
							String msg = eventList.take();
							if (isLoggerEnabled()) {
								logger.info("sending to queue:" + queueName + ", content:" + msg);
							}
							getProducer().sendMessage(msg);
						}
					} catch (InterruptedException e) {
						// ignore
					} catch (JMSException e) {
						eraseProducer();
						logger.error(queueName + ", sendtoamq:send message error:" + e, e);
					}
				}
			}
		});
	}

	private synchronized AmqProducerTool getProducer() {
		if (producer == null) {
			try {
				brokerUrl = getBrokerUrl();
				queueName = getQueueName();
				if (brokerUrl == null || queueName == null) {
					throw new IllegalStateException(
							"指定的brokerUrl或queueName不存在:brokerUrl=" + brokerUrl + ",queueName=" + queueName);
				}
				producer = new AmqProducerTool(brokerUrl, queueName, DeliveryMode.PERSISTENT);
			} catch (JMSException e) {
				logger.error("ActiveMQ producer creating failed. Reason: " + e, e);
			}
		}
		return producer;
	}

	private synchronized void eraseProducer() {
		producer = null;
	}

	public synchronized String getBrokerUrl() {
		if (StringUtils.isBlank(this.brokerUrl)) {
			return ConfigUtil.getConfig("broker_url");
		}
		return brokerUrl;
	}

	public void setBrokerUrl(String brokerUrl) {
		this.brokerUrl = brokerUrl;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public String getQueueName() {
		if (StringUtils.isBlank(this.queueName)) {
			return ConfigUtil.getConfig("queue_name");
		}
		return this.queueName;
	}

	public void setLoggerEnabled(boolean isLoggerEnabled) {
		this.isLoggerEnabled = isLoggerEnabled;
	}
	public boolean isLoggerEnabled() {
		return isLoggerEnabled;
	}

}
