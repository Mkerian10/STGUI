package com.stdev.stgui.examples.injection;

import com.stdev.stgui.elements.SCheckbox;
import com.stdev.stgui.elements.SSpinner;
import com.stdev.stgui.elements.STextField;
import com.stdev.stgui.filters.NumberFilter;
import com.stdev.stgui.injection.SInjector;

import javax.swing.*;
import javax.swing.text.AbstractDocument;

public class GUIClass{
	
	JFrame frame;
	
	private SCheckbox checkbox;
	
	private STextField sTextField;
	
	private SSpinner spinner;
	
	public static void main(String[] args) throws InterruptedException{
		GUIClass cls = new GUIClass();
		cls.makeGui();
		while(cls.frame.isVisible()){
			Thread.sleep(200);
		}
		
		TargetClass targetClass = new TargetClass();
		SInjector.inject(cls, targetClass);
		System.out.println(targetClass.toString());
	}
	
	private void makeGui(){
		frame = new JFrame();
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
		checkbox = new SCheckbox();
		sTextField = new STextField();
		spinner = new SSpinner();
		jPanel.add(checkbox);
		jPanel.add(sTextField);
		jPanel.add(spinner);
		frame.add(jPanel);
		frame.pack();
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
