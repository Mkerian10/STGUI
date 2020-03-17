package com.stdev.stgui.elements;

import com.stdev.stgui.injection.Buildable;
import com.stdev.stgui.injection.Tearable;

import javax.swing.*;
import java.util.Objects;

public class SSpinner extends JSpinner implements Buildable, Tearable{
	
	@Override
	public void build(String injectionStr){
		setValue(Integer.parseInt(Objects.requireNonNull(injectionStr)));
	}
	
	@Override
	public String teardown(){
		return getValue().toString();
	}
}
