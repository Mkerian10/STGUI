package com.stdev.stgui.elements;

import com.stdev.stgui.injection.Buildable;
import com.stdev.stgui.injection.Tearable;

import javax.swing.*;
import java.util.Objects;

public class SCheckbox extends JCheckBox implements Tearable, Buildable{
	
	@Override
	public String teardown(){
		return Boolean.toString(isSelected());
	}
	
	@Override
	public void build(String injectionStr){
		if(!Objects.requireNonNull(injectionStr).equalsIgnoreCase("true")
				&& !injectionStr.equalsIgnoreCase("false")){
			throw new RuntimeException("Misformatted injection string: " + injectionStr);
		}
		
		boolean val = Boolean.parseBoolean(injectionStr);
		setSelected(val);
	}
}
