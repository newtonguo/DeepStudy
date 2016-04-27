package com.xiyuan.demo.dispatchcenter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.xiyuan.demo.model.TestModel.Request;

public abstract class BaseController {

	protected DispatchCenter dispatchCenter;
	
	public BaseController() {
	}
	
	public final void setDispatchCenter(DispatchCenter dc) {
		this.dispatchCenter = dc;
	}
	
	public final void dispatchAction(Method method, Request request)
	{
		if(method != null)
		{
			try {
				method.invoke(this, request);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}
	
}
