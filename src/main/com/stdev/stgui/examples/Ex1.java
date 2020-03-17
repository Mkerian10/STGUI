package com.stdev.stgui.examples;

import com.stdev.stgui.elements.STextField;
import com.stdev.stgui.filters.NumberFilter;

import javax.swing.*;
import javax.swing.text.AbstractDocument;

public class Ex1{
	
	public static void main(String[] args){
		makeGui();
	}
	
	private static void makeGui(){
		JFrame frame = new JFrame();
		STextField stf = new STextField();
		((AbstractDocument)stf.getDocument()).setDocumentFilter(new NumberFilter());
		frame.add(stf);
		frame.pack();
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
}
