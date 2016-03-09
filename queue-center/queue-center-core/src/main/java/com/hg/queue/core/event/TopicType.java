package com.hg.queue.core.event;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by wangqinghui on 2016/3/9.
 */
@Getter
//@Setter
public enum TopicType {

    HGTEST(1,"HG_TEST");

    // 定义私有变量
    private int id ;
    private String name;

    // 构造函数，枚举类型只能为私有
    private TopicType( int id,String name) {
        this.id = id;
        this.name = name;
    }

}
