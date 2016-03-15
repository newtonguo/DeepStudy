package com.zhiyin.event.engine.body;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zhiyin.event.engine.event.EventProducerType;
import com.zhiyin.event.engine.event.EventType;


public class EventEntity implements ISerializable {

	private String id;//事件id
	private String dttm;//时间戳
	
	private BasicEventBody body;
//	private EventType eventDetail = EventType.Undefine;
//	private EventProducerType producerType;//事件生产者 
	private String type = EventType.Undefine.getCode();
	
	private String producer ;
	private String extra;//附加信息

	private static Gson gson = 	new GsonBuilder().registerTypeAdapter(BasicEventBody.class, new EventBodyAdapter()).create();
	// setPrettyPrinting().create();

	public EventEntity() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		this.dttm = sdf.format(new Date());
		String s = UUID.randomUUID().toString();
		this.id =(new StringBuilder()).append(s.substring(0, 8)).append(s.substring(9, 13)).append(s.substring(14, 18)).append(s.substring(19, 23)).append(s.substring(24)).toString();
	
	}
	
	@Override
	public String serialize() {
		return JSON.toJSONString(this);
	}


	public EventEntity deserialize(String str) {
		if (StringUtils.isEmpty(str)) {
			return null;
		}		
		return JSON.parseObject(str, EventEntity.class);
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}


	public String getProducer() {
		return producer;
	}


	public void setProducer(String producer) {
		this.producer = producer;
	}


	

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getDttm() {
		return dttm;
	}


	public void setDttm(String dttm) {
		this.dttm = dttm;
	}


	public BasicEventBody getBody() {
		return body;
	}


	public void setBody(BasicEventBody body) {
		this.body = body;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}



	public String getExtra() {
		return extra;
	}


	public void setExtra(String extra) {
		this.extra = extra;
	}


	public static Gson getGson() {
		return gson;
	}


	public static void setGson(Gson gson) {
		EventEntity.gson = gson;
	}
	
	
	
}
