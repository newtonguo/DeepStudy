package com.zhiyin.event.core.body.binlog;


/**
 * 表数据的操作事件
 * @author hg
 * 应该与类com.alibaba.otter.canal.protocol.CanalEntry.EventType一致
 */
public enum BinlogOpType {
    INSERT(1, "insert"),
    UPDATE(2, "update"),
    DELETE(3, "delete");
    
    
    private final int index;
    private final String value;
    
    private BinlogOpType(int index, String value) {
        this.index = index;
        this.value = value;
    }

	public int getIndex() {
		return index;
	}

	public String getValue() {
		return value;
	}


    
}
