package com.stdev.stgui.injection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class InjectionSampleClassFactory{
	
	public static Collection<?> valueOf(String s){
		switch(s){
			case "list":
				return new ArrayList<>();
			case "set":
				return new HashSet<>();
		}
		return null;
	}
}
