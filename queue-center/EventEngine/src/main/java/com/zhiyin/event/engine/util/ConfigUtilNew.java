package com.zhiyin.event.engine.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ConfigUtilNew {
	public static Properties prop = new Properties();
	private static Map<String, HashSet<String>> setMap = new HashMap<String, HashSet<String>>();

	static {
		try {
			InputStream input = ConfigUtil.class
					.getResourceAsStream("/event_engine_config.properties");
			prop.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static String getConfig(String key) {
		return prop.getProperty(key);
	}

	public static HashSet<String> getConfigSet(String key) {
		String setName = key + "_set";
		HashSet<String> set = setMap.get(setName);
		if (set == null) {
			String config = getConfig(key);
			String[] arr = config.split(",");
			set = new HashSet<String>();
			set.addAll(Arrays.asList(arr));
			setMap.put(setName, set);
		}

		return set;
	}

	public static void main(String[] args) {
		Set url = getConfigSet("MSG_CENTER_QUEUE");
		url = getConfigSet("MSG_CENTER_QUEUE");
		System.out.println(url);
	}
}
