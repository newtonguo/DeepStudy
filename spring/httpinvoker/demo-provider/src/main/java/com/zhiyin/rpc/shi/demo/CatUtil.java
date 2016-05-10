package com.zhiyin.rpc.shi.demo;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Transaction;
import com.dianping.cat.message.internal.DefaultEvent;
import com.taobao.diamond.manager.impl.WholeDiamondManager;

public class CatUtil {
	public  static Transaction startCat(String groupName, String dataName){
		WholeDiamondManager diamondManager = WholeDiamondManager.getInstance();
		String conumserCat = diamondManager.getConfigureInfomation("CatSwitch", "UmeServiceRegister", 50000);
		if ("1".equals(conumserCat)) {
			return Cat.getProducer().newTransaction(groupName + "_Call", dataName);
		}else {
			return null;
		}
	}
	
	
	public  static void setSuccessStatus(Transaction cat, String Status){
		if (cat != null) {
			WholeDiamondManager diamondManager = WholeDiamondManager.getInstance();
			String conumserCat = diamondManager.getConfigureInfomation("CatSwitch", "UmeServiceRegister", 50000);
			if ("1".equals(conumserCat)) {
				cat.setStatus(Transaction.SUCCESS);
			}
		}
	}
	
	
	public  static void setEventStatus(DefaultEvent event, String status){
		if (event != null) {
			WholeDiamondManager diamondManager = WholeDiamondManager.getInstance();
			String conumserCat = diamondManager.getConfigureInfomation("CatSwitch", "UmeServiceRegister", 50000);
			if ("1".equals(conumserCat)) {
				event.setStatus(status);
			}
		}
	}
	
	public  static void setExceptionStatus(Transaction cat, Exception e){
		if (cat != null) {
			WholeDiamondManager diamondManager = WholeDiamondManager.getInstance();
			String conumserCat = diamondManager.getConfigureInfomation("CatSwitch", "UmeServiceRegister", 50000);
			if ("1".equals(conumserCat)) {
				Cat.getProducer().logError(e);//用log4j记录系统异常，以便在Logview中看到此信息
				cat.setStatus(e);
			}
		}
	}
	
	public  static void setEventStatus(DefaultEvent event, Exception e){
		if (event != null) {
			WholeDiamondManager diamondManager = WholeDiamondManager.getInstance();
			String conumserCat = diamondManager.getConfigureInfomation("CatSwitch", "UmeServiceRegister", 50000);
			if ("1".equals(conumserCat)) {
				event.setStatus(e);
			}
		}
	}
	
	public  static DefaultEvent startEvent(String groupName){
		WholeDiamondManager diamondManager = WholeDiamondManager.getInstance();
		String conumserCat = diamondManager.getConfigureInfomation("CatSwitch", "UmeServiceRegister", 50000);
		if ("1".equals(conumserCat)) {
			return new DefaultEvent("PigeonCall.app", groupName, null);
			
		}else {
			return null;
		}
	}
	
	
	
	public  static void closeCat(Transaction cat, DefaultEvent event,DefaultEvent event2){
		if (cat != null) {
			cat.addChild(event);
			cat.addChild(event2);
			cat.complete();
		}
	}
	
	public  static void closeCat(Transaction cat, DefaultEvent event){
		if (cat != null) {
			cat.addChild(event);
			cat.complete();
		}
	}
	
	public  static DefaultEvent startEvent(String type ,String groupName){
		WholeDiamondManager diamondManager = WholeDiamondManager.getInstance();
		String conumserCat = diamondManager.getConfigureInfomation("CatSwitch", "UmeServiceRegister", 50000);
		if ("1".equals(conumserCat)) {
			return new DefaultEvent(type, groupName, null);

		}else {
			return null;
		}
	}
}
