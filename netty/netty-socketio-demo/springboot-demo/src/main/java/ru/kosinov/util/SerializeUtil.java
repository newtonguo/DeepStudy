package ru.kosinov.util;

import com.alibaba.fastjson.JSON;

/**
 * Created by wangqinghui on 2016/5/16.
 */
public class SerializeUtil {


    public static String get(Object obj){

        return JSON.toJSONString(obj) ;

    }

}
