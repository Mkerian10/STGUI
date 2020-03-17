package com.stdev.stgui.injection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SInjectorTest{
	
	GUITestClass testClass;
	
	TestTargetClass testTargetClass;
	
	@BeforeEach
	void setUp(){
		testClass = new GUITestClass();
		testTargetClass = new TestTargetClass();
	}
	
	@Test
	void inject(){
		SInjector.inject(testClass, testTargetClass);
		assertEquals(69, testTargetClass.spinner);
		assertTrue(testTargetClass.sTextField instanceof Set);
		assertEquals("true", testTargetClass.checkbox);
		assertEquals(TestEnum.BAR, testTargetClass.cbEnums);
	}
}