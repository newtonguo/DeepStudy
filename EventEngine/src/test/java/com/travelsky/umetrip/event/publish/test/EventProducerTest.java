package com.travelsky.umetrip.event.publish.test;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

import com.travelsky.umetrip.test.base.BaseTest;
import com.zhiyin.event.engine.body.EventEntity;
import com.zhiyin.event.engine.body.module.test.DemoAddEventBody;
import com.zhiyin.event.engine.event.DetailEventType;
import com.zhiyin.event.engine.producer.EventProducer;

public class EventProducerTest extends BaseTest {

	class Bean {
		private String p1;
		public void setP1(String p1) {
			this.p1 = p1;
		}
		@Override
		public String toString() {
			return p1;
		}
	}

	
	@Before
	public void setUp() {

	}
//	@Test
//	public void testPublishAutoPA() throws InterruptedException {
//		UmetripEventEngine instance = EventProducer.getInstance("failover:(tcp://10.6.50.36:61617)?jms.prefetchPolicy.queuePrefetch=1");
//
//		ActivityInfoBean bean = new ActivityInfoBean();
//		bean.setFlightno("CA1001");
//		bean.setTktnum("999002313432");
//		bean.setCoupon("1");
//
//		AutoPAEventBody autoPAEventBody = new AutoPAEventBody(bean, "1232323", "CA", 1);
//		UmetripEvent event = new UmetripEvent();
//		event.setEventType(UmetripEventType.AUTO_PA_SUCCEED);
//		event.setBody(autoPAEventBody);
//
//		instance.publish(event);
//		TimeUnit.SECONDS.sleep(10);
//	}

	@Test
	public void testPublish() throws InterruptedException {
		EventProducer instance = EventProducer.getInstance("failover:(tcp://localhost:61616)?jms.prefetchPolicy.queuePrefetch=1");

		DemoAddEventBody tmp = new DemoAddEventBody();
		tmp.setGender("男");
		tmp.setId(1L);
		tmp.setName("John");
		EventEntity event = new EventEntity();
		event.setBody(tmp);
		event.setExtra("测试用户事件体");
		
		event.setEventDetail(DetailEventType.DemoAdd);
		System.out.println(event);
		instance.publish(event);
		TimeUnit.SECONDS.sleep(10);
	}
//
//	@Test
//	public void testPublic1() throws InterruptedException {
//		String msg = "##2001##出票##20130731135059##4f22ea55e4e74832863de2922e68873e##PSRTRIP##null##{ 'className': 'com.travelsky.umetrip.event.domain.PsrTripEventBody', 'instance': { 'activity': { 'coupon': '1', 'tktnum': '9992106971024', 'tktstatus': 'OPEN FOR USE', 'pnr_b': 'MVN8CL', 'certtype': 'NI', 'certid': '610324198706121531', 'aircode': 'CA', 'flightno': 'CA1272', 'aircode_op': 'CA', 'flightno_op': 'CA1272', 'deptcity': '兰州', 'deptcode': 'LHW', 'destcity': '北京首都', 'destcode': 'PEK', 'flighttime': 'Aug 1, 2013 4:00:00 PM', 'deptdate': '2013-08-01', 'depttime': '16:00', 'desttime': '18:20', 'deptdate_local': '2013-08-01', 'depttime_local': '16:00', 'destdate_local': '2013-08-01', 'desttime_local': '18:20', 'flytime': '140', 'flykilo': '1356公里', 'tktfare': '1300.00', 'fueltax': '110.00', 'acfee': '50.00', 'bagweightallow': '20K', 'issuetime': '2013-07-31 00:00:00', 'issueoffice': 'PEK184', 'datasource': 'LK', 'cnname': '孙善彬', 'lastname': '', 'firstname': '', " +
//				"'seqid':'1866417' } } }";
//
//		UmetripEvent eve = new UmetripEvent();
//		eve.deserialize(msg);
//
//		String url = "failover:(tcp://10.6.50.36:61618)?jms.prefetchPolicy.queuePrefetch=1";
//		UmetripEventEngine instance = UmetripEventEngine.getInstance(url);
//		for (int i = 0; i < 10; i++) {
//			try {
//				instance.publish(eve);
//			} catch (Throwable e) {
//				e.printStackTrace();
//			}
//
//			TimeUnit.MILLISECONDS.sleep(100);
//		}
//	}
//
//	@Test
//	public void testGetInstanceWithoutURL() {
//		UmetripEventEngine instance = UmetripEventEngine.getInstance();
//		Assert.assertEquals("failover:(tcp://10.6.50.36:61618)?jms.prefetchPolicy.queuePrefetch=1",
//				instance.getBrokerUrl());
//	}
//
//	@Test
//	public void testGetInstanceWithURL() {
//		String url = "failover:(tcp://10.6.155.205:61617)?jms.prefetchPolicy.queuePrefetch=1";
//		UmetripEventEngine instance = UmetripEventEngine.getInstance(url);
//		Assert.assertEquals(url, instance.getBrokerUrl());
//	}
//
//	@Test
//	public void testGetMultipleInstance() {
//		String url1 = "failover:(tcp://10.6.155.205:61617)?jms.prefetchPolicy.queuePrefetch=1";
//		UmetripEventEngine instance1 = UmetripEventEngine.getInstance(url1);
//
//		String url2 = "failover:(tcp://10.6.50.36:61617)?jms.prefetchPolicy.queuePrefetch=1";
//		UmetripEventEngine instance2 = UmetripEventEngine.getInstance(url2);
//
//		Assert.assertEquals(url1, instance1.getBrokerUrl());
//		Assert.assertEquals(url2, instance2.getBrokerUrl());
//		Assert.assertNotSame(instance1, instance2);
//	}
//
//	@Test
//	public void testGetMultipleInstanceReturnedMutlipleInstance() {
//		String url1 = "failover:(tcp://10.6.155.205:61617)?jms.prefetchPolicy.queuePrefetch=1";
//		UmetripEventEngine instance1 = UmetripEventEngine.getInstance(url1);
//
//		String url2 = "failover:(tcp://10.6.155.205:61617)?jms.prefetchPolicy.queuePrefetch=1";
//		UmetripEventEngine instance2 = UmetripEventEngine.getInstance(url2);
//
//		Assert.assertEquals(instance1, instance2);
//	}
//
//	@Test
//	public void testPublicMsg() throws InterruptedException {
//		String url = "failover:(tcp://10.6.144.119:61616)?jms.prefetchPolicy.queuePrefetch=1";
//		UmetripEventEngine instance = UmetripEventEngine.getInstance(url);
//		Assert.assertEquals(url, instance.getBrokerUrl());
//
//		instance.setQueueName("UMETRIP_QUEUE_DEFAULT");
//		Assert.assertEquals("UMETRIP_QUEUE_DEFAULT", instance.getQueueName());
//
//		String msg = "hello world";
//		for (int i = 0; i < 5100; i++) {
//			instance.publish(msg);
//			TimeUnit.SECONDS.sleep(1);
//		}
//		TimeUnit.SECONDS.sleep(1000);
//	}
//
//	@Test
//	public void testPublicFFP() throws InterruptedException {
//		String url2 = "failover:(tcp://10.6.50.36:61617)?jms.prefetchPolicy.queuePrefetch=1";
//		UmetripEventEngine instance2 = UmetripEventEngine.getInstance(url2);
//		FfpResponseEventBody body = new FfpResponseEventBody();
//		UmetripEvent event2 = new UmetripEvent();
//		event2.setEventType(UmetripEventType.RESPONSE_FFP_INFO);
//		event2.setBody(body);
//		for (int i = 0; i < 100; i++) {
//			instance2.publish(event2);
//			TimeUnit.SECONDS.sleep(1);
//		}
//		TimeUnit.SECONDS.sleep(1000);
//	}
//
//	@Test
//	public void testPublishUserAuthEvent() throws InterruptedException {
//		UmetripEvent umetripEvent = new UmetripEvent() ;
//		umetripEvent.setEventType(UmetripEventType.USER_AUTH_SUCC) ;
//		//用户id
//		//		        佟工 3069556
//		//		        庆辉 3722844
//		umetripEvent.setBody(new UserAuthEventBody(3722844)) ;
//		String url1 = "failover:(tcp://10.6.155.205:61617)?jms.prefetchPolicy.queuePrefetch=1";
//		UmetripEventEngine instance1 = UmetripEventEngine.getInstance(url1);
//		instance1.publish(umetripEvent);
//		TimeUnit.SECONDS.sleep(1000);
//	}

}
