package com.zhiyin.event.engine.body;

public interface ISerializable {
	String serialize();
	Object deserialize(String str);
}
