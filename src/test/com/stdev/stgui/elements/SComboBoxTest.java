package com.stdev.stgui.elements;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SComboBoxTest{
	
	SComboBox<String> stringSComboBox;
	
	@BeforeEach
	void setUp(){
		stringSComboBox = new SComboBox<>();
		stringSComboBox.addItem("hi");
		stringSComboBox.addItem("hello");
		stringSComboBox.addItem("how are you");
	}
	
	@Test
	void teardown(){
		stringSComboBox.setSelectedIndex(2);
		assertEquals("how are you", stringSComboBox.getSelectedItem());
		assertEquals("how are you", stringSComboBox.teardown());
	}
	
	@Test
	void build(){
		stringSComboBox.build("hello");
		assertEquals(1, stringSComboBox.getSelectedIndex());
	}
}