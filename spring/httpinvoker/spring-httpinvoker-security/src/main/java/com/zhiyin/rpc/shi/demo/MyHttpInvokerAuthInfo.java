package com.zhiyin.rpc.shi.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * HttpInvoker调用验证信息类
 */
public class MyHttpInvokerAuthInfo {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyHttpInvokerAuthInfo.class);
    //用户名KEY
    public static final String USERNAME_KEY = "USERNAME_KEY";
    //密码KEY
    public static final String PASSWORD_KEY = "PASSWORD_KEY";
    //随机生成的KEY1
    public static final String FIRST_KEY = "FIRST_KEY";
    //随机生成的KEY2
    public static final String SECOND_KEY = "SECOND_KEY";
 
    private String username;
    private String password;
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    /**
     * 获取加密信息MAP
     */
    public Map<String, Serializable> getSecurityMap(){
//        if(StringUtils.isBlank(password)){
//            return null;
//        }
        Map<String, Serializable> securityMap = new HashMap<String, Serializable>();
        //TODO 添加自己的安全加密逻辑，并把需要认证的数据放入securityMap中
        return securityMap;
    }
 
    /**
     * 生成密钥
     */
    public static String getSecurityKey(String firstKey, String secondKey, String thirdKey) {
        String security = null;
        //TODO 生成自己的密钥
        return security;
    }
 
    /**
     * 对认证信息进行校验
     */
    public static boolean validatePassword(String key, Map<String, Serializable> keyMap) {
        boolean result = false;
        try {
            //TODO 校验逻辑
        } catch (Exception e) {
            LOGGER.error("密钥校验失败", e);
        }
        return result;
    }
}