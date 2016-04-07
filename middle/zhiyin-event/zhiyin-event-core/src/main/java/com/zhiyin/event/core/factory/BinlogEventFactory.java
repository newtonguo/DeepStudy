package com.zhiyin.event.core.factory;


import com.zhiyin.event.core.EventProducerType;
import com.zhiyin.event.core.EventType;
import com.zhiyin.event.core.EventEntity;
import com.zhiyin.event.core.body.binlog.BinlogEventBody;
import com.zhiyin.event.core.body.content.ContentAddBody;

/**
 * mysql binlog event
 */
public class BinlogEventFactory {

	/**
	 * 创建mysql binlog事件
	 * @param body
	 * @return
     */
	public static EventEntity binglog(BinlogEventBody body) {

		EventEntity event = EventBuilderFactory.build(
				EventProducerType.MysqlBinlog, EventType.MysqlBinlog, body);

		return event;
	}

}
