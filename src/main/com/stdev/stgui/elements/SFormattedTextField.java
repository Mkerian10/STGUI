package com.stdev.stgui.elements;

import com.stdev.stgui.injection.Buildable;
import com.stdev.stgui.injection.Tearable;

import javax.swing.*;
import java.util.Objects;

public class SFormattedTextField extends JFormattedTextField implements Tearable, Buildable{
	
	@Override
	public void build(String injectionStr){
		setText(Objects.requireNonNull(injectionStr));
	}
	
	@Override
	public String teardown(){
		return getText();
	}
}
