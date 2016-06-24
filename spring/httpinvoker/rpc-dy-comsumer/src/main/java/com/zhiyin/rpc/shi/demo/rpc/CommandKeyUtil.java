package com.zhiyin.rpc.shi.demo.rpc;

import com.google.common.collect.Maps;
import com.google.common.net.InetAddresses;

import java.util.Map;

/**
 * Created by wangqinghui on 2016/6/24.
 */
public class CommandKeyUtil {

  public static   Map<String,Integer> keyIndexMap = Maps.newConcurrentMap();


    public static String getCk(String command){

        return command + getIndex(command);

    }

    public static Integer getIndex(String command){

        if(keyIndexMap.containsKey(command)){
            return keyIndexMap.get(command);
        }
        return 0;
    }

    public static void setIndex(String command){
        Integer in = getIndex(command);
        in = in+1;
        keyIndexMap.put(command,in);

    }
}
