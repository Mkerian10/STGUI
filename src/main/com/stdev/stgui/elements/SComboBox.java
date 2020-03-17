package com.stdev.stgui.elements;

import com.stdev.stgui.injection.Buildable;
import com.stdev.stgui.injection.Tearable;

import javax.swing.*;
import java.util.Vector;

public class SComboBox<K> extends JComboBox<K> implements Tearable, Buildable{
	
	public SComboBox(ComboBoxModel<K> aModel){
		super(aModel);
		setEditable(false);
	}
	
	public SComboBox(K[] items){
		super(items);
		setEditable(false);
	}
	
	public SComboBox(Vector<K> items){
		super(items);
		setEditable(false);
	}
	
	public SComboBox(){
		setEditable(false);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public K getSelectedItem(){
		return (K) super.getSelectedItem();
	}
	
	@Override
	public String teardown(){
		return getSelectedItem() == null ? "": getSelectedItem().toString();
	}
	
	@Override
	public void build(String injectionStr){
		for(int i = 0; i < getModel().getSize(); i++){
			if(getItemAt(i).toString().equals(injectionStr)){
				setSelectedIndex(i);
				return;
			}
		}
	}
}
