package com.zhiyin.event.core.factory;


import com.zhiyin.event.core.EventProducerType;
import com.zhiyin.event.core.EventType;
import com.zhiyin.event.core.EventEntity;
import com.zhiyin.event.core.body.content.ContentAddBody;

/**
 * mysql binlog event
 */
public class BinlogEventFactory {

	public static EventEntity contentAdd(Long id) {
		ContentAddBody tmp = new ContentAddBody();
		tmp.setId( id );
		tmp.setTitle("Hello");
		EventEntity event = EventBuilderFactory.build(
				EventProducerType.MysqlBinlog, EventType.ContentAdd, tmp);

		return event;
	}

}
