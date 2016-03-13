package com.zhiyin.event.engine.route;

import org.apache.camel.Body;

import com.alibaba.fastjson.JSON;
import com.zhiyin.event.engine.body.EventBuilderFactory;
import com.zhiyin.event.engine.body.EventEntity;
import com.zhiyin.event.engine.body.content.ContentAddBody;
import com.zhiyin.event.engine.event.EventProducerType;
import com.zhiyin.event.engine.event.EventType;

public class CamelRouteRule {
	/**
	 * elasticSearch 处理队列
	 * @param body
	 * @return
	 */
	public boolean ElasticSearchIndexUpdate(@Body String body){		
		String typeCode = getTypeCode(body);
		return EventRouteConfigUtil.contain("ElasticSearchIndexUpdate", typeCode);
	}

	public static  boolean ElasticSearchIndexUpdateTest(String body){		
		String typeCode = getTypeCode(body);
		return EventRouteConfigUtil.contain("ElasticSearchIndexUpdate", typeCode);	
	}

	private static String getTypeCode(String body) {		
	    EventEntity tmp = JSON.parseObject(body, EventEntity.class);
	    return tmp.getType();
	}

	public static void main(String[] args) {
		ContentAddBody tmp = new ContentAddBody();
		tmp.setId(100L);
		tmp.setTitle("Hello");
		EventEntity event = EventBuilderFactory.build(EventProducerType.AppManager,EventType.ContentAdd,tmp);
		String str = event.toString();
		System.out.println(str);
		System.out.println(CamelRouteRule.ElasticSearchIndexUpdateTest(str));
	}
}
