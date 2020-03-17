package com.stdev.stgui.injection;

import com.stdev.stgui.elements.SCheckbox;
import com.stdev.stgui.elements.SComboBox;
import com.stdev.stgui.elements.SSpinner;
import com.stdev.stgui.elements.STextField;

public class GUITestClass{
	
	public GUITestClass(){
		for(TestEnum te: TestEnum.values()){
			enums.addItem(te);
		}
		sTextField.setText("set");
		enums.setSelectedItem(TestEnum.BAR);
		spinner.setValue(69);
		checkbox.setSelected(true);
	}
	
	SComboBox<TestEnum> enums = new SComboBox<>();
	
	STextField sTextField = new STextField();
	
	SSpinner spinner = new SSpinner();
	
	SCheckbox checkbox = new SCheckbox();
	
}
