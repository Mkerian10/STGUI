package com.stdev.stgui.examples.injection;

import com.stdev.stgui.injection.SInject;

public class TargetClass{
	
	@SInject(Boolean.class)
	boolean checkbox;
	
	@SInject
	String sTextField;
	
	@SInject(Integer.class)
	int spinner;
	
	@Override
	public String toString(){
		return String.format("%s\n%s\n%s", checkbox, sTextField, spinner);
	}
}
