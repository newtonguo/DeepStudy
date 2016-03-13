package com.zhiyin.event.engine.body;

import com.zhiyin.event.engine.body.content.ContentAddBody;
import com.zhiyin.event.engine.event.EventProducerType;
import com.zhiyin.event.engine.event.EventType;

public class EventBuilderFactory {
	public static EventEntity build(EventProducerType producer, EventType type,
			BasicEventBody body) {
		EventEntity e = new EventEntity();

		e.setType(type.getEventCode());
		e.setBody(body);
		e.setProducer(producer.getCode());

		return e;

	}

	public static EventEntity buildContentAddEvent() {
		ContentAddBody tmp = new ContentAddBody();
		tmp.setId(100L);
		tmp.setTitle("Hello");
		EventEntity event = EventBuilderFactory.build(
				EventProducerType.AppManager, EventType.ContentAdd, tmp);

//		System.out.println(event);
		return event;
	}

	public static void main(String[] args) {

		ContentAddBody tmp = new ContentAddBody();
		tmp.setId(100L);
		tmp.setTitle("Hello");
		EventEntity event = EventBuilderFactory.build(
				EventProducerType.AppManager, EventType.ContentAdd, tmp);

		System.out.println(event);
	}

}
