package com.travelsky.umetrip.event.util.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

//activemq.queue=MSG_CENTER_QUEUE
//activemq.receiveTimeout=6000
//activemq.concurrentConsumers=1
//activemq.maxConcurrentConsumers=2
//activemq.autoStartup=true
public class PropertiesLoadTes {
	@Test
	public void testAppend() {
		Properties prop = new Properties();

		try {
			FileInputStream in = new FileInputStream("activemq.properties");
			prop.load(in);
			
			prop.setProperty("activemq.queue", "test0");
			
			//save properties to project root folder
			FileOutputStream out = new FileOutputStream("activemq.properties");
    		prop.store(out, null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Test
	public void testReplace() {
		Properties prop = new Properties();
    	try {
    		//set the properties value
    		prop.setProperty("activemq.queue", "localhost");
    		prop.setProperty("dbuser", "mkyong");
    		prop.setProperty("dbpassword", "password");
    		
    		prop.setProperty("MSG_CENTER_QUEUE", "1001,1002,1003,1004");
 
    		//save properties to project root folder
    		prop.store(new FileOutputStream("activemq.properties"), null);
 
    	} catch (IOException ex) {
    		ex.printStackTrace();
        }
	}
}
