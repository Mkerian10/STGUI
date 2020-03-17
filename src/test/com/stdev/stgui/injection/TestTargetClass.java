package com.stdev.stgui.injection;

import java.util.Collection;

public class TestTargetClass{
	
	@SInject(value = TestEnum.class, name = "enums")
	TestEnum cbEnums;
	
	@SInject(InjectionSampleClassFactory.class)
	Collection sTextField;
	
	@SInject(Integer.class)
	int spinner;
	
	@SInject
	String checkbox;
	
}
