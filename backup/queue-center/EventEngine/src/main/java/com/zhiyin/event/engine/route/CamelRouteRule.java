package com.zhiyin.event.engine.route;

import java.util.HashSet;

import org.apache.camel.Body;

import com.zhiyin.event.engine.util.ConfigUtilNew;

public class CamelRouteRule {
	/**
	 * elasticSearch 处理队列
	 * @param body
	 * @return
	 */
	public boolean ElasticSearchIndexUpdate(@Body String body){
		
		String typeCode = getTypeCode(body);

		HashSet<String> queueList = ConfigUtilNew.getConfigSet("ElasticSearchIndexUpdate");
		return queueList.contains(typeCode);
	}


	private String getTypeCode(String body) {
		if (body.length() >= 6) {
			return body.substring(2, 6);
		}
		return "0000";
	}

	public static void main(String[] args) {
		String body = "0x1234567";
		String typeCode = "0000";
		if (body.length() >= 6) {
			String head = body.substring(0,6);
			typeCode = head.substring(2);
		}

		System.out.println(typeCode);

		typeCode = body.substring(2, 6);
		System.out.println(typeCode);
	}
}
