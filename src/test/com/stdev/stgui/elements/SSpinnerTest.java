package com.stdev.stgui.elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SSpinnerTest{
	
	SSpinner spinner;
	
	@BeforeEach
	void setUp(){
		spinner = new SSpinner();
	}
	
	@Test
	void build(){
		spinner.build("23");
		assertEquals(23, (int)spinner.getValue());
	}
	
	@Test
	void teardown(){
		spinner.setValue(43);
		assertEquals("43", spinner.teardown());
	}
}