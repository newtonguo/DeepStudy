package com.zhiyin.event.core;

import com.zhiyin.event.core.body.BasicEventBody;
import com.zhiyin.event.core.body.ISerializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;


@Getter
@Setter
public class EventEntity implements ISerializable {

	private String id;//事件id
	private String crateTime;//时间戳
	
	private BasicEventBody body;
//	private EventType eventDetail = EventType.Undefine;
//	private EventProducerType producerType;//事件生产者 
	private String type = EventType.Undefine.getCode();
	
	private String producer ;
	private String extra;//附加信息

	public EventEntity() {

//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//		this.dttm = sdf.format(new Date());
//		String s = UUID.randomUUID().toString();
//		this.id =(new StringBuilder()).append(s.substring(0, 8)).append(s.substring(9, 13)).append(s.substring(14, 18)).append(s.substring(19, 23)).append(s.substring(24)).toString();
	
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

}
