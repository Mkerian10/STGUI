package com.stdev.stgui.elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class STextFieldTest{
	
	STextField sTextField;
	
	@BeforeEach
	void setUp(){
		sTextField = new STextField();
		sTextField.setText("Hello World");
	}
	
	@Test
	void build(){
		sTextField.build("Hi World");
		assertEquals("Hi World", sTextField.getText());
	}
	
	@Test
	void teardown(){
		assertEquals("Hello World", sTextField.teardown());
	}
}