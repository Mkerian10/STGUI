package com.stdev.stgui.elements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SCheckboxTest{
	
	@Test
	void teardown(){
		SCheckbox s1 = new SCheckbox();
		s1.setSelected(true);
		Assertions.assertEquals("true", s1.teardown());
		s1.setSelected(false);
		Assertions.assertEquals("false", s1.teardown());
	}
	
	@Test
	void build(){
		String s = "true";
		String s2 = "false";
		SCheckbox s1 = new SCheckbox();
		s1.build(s);
		Assertions.assertTrue(s1.isSelected());
		s1.build(s2);
		Assertions.assertFalse(s1.isSelected());
	}
}