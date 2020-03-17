package com.stdev.stgui.injection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class SInjector{
	
	public static void inject(Object guiObject, Object injectionObject){
		Map<String, Field> donorFieldNames = getValidDonorFields(guiObject);
		Map<String, Field> injFieldNames = getValidInjectionFields(injectionObject);
		
		Map<Field, Field> fieldMatches = getFieldMatches(donorFieldNames, injFieldNames);
		fieldMatches.forEach((field, field2) -> inject(guiObject, field, injectionObject, field2));
	}
	
	private static void inject(Object guiObj, Field donor, Object injObject, Field injection){
		donor.setAccessible(true);
		injection.setAccessible(true);
		
		String teardown = getTeardown(guiObj, donor);
		if(teardown == null){
			System.err.println("Unexpected null teardown: " + donor.getName() + " from type " + donor.getType().getSimpleName());
			return;
		}
		
		inject(teardown, injObject, injection);
	}
	
	private static void inject(Object teardown, Object injObject, Field injection){
		SInject sInject = injection.getAnnotation(SInject.class);
		
		teardown = transformTeardown(sInject, teardown, injection);
		
		if(teardown == null){
			return;
		}
		
		injection.setAccessible(true);
		
		try{
			injection.set(injObject, teardown);
		}catch(IllegalAccessException e){
			throw new RuntimeException("Should be impossible. If this  code is reached give stacktrace to project owner.");
		}
	}
	
	private static Object transformTeardown(SInject sInject, Object teardown, Field injection){
		Objects.requireNonNull(teardown);
		if(!sInject.value().equals(String.class)){
			Class<?> cls = sInject.value();
			try{
				Method valueOfMethod = cls.getDeclaredMethod("valueOf", String.class);
				valueOfMethod.setAccessible(true);
				teardown = valueOfMethod.invoke(null, (String) teardown);
			}catch(NoSuchMethodException | NullPointerException e){
				System.err.println("No valueOf method found for class: " + cls.getSimpleName() + " expected for field: " + injection.getName());
				return null;
			}catch(IllegalAccessException ignored){
				throw new RuntimeException("Should be impossible. If this  code is reached give stacktrace to project owner.");
			}catch(InvocationTargetException e){
				System.err.println("No valueOf method found for class: " + cls.getSimpleName() + " expected for field: " + injection.getName());
				System.err.println("Method potentially not static?");
				return null;
			}
		}
		return teardown;
	}
	
	private static String getTeardown(Object guiObj, Field donor){
		try{
			Object d = donor.get(guiObj);
			Tearable t = (Tearable) d;
			return t.teardown();
			
		}catch(IllegalAccessException | ClassCastException e){
			throw new RuntimeException(e + "\nThis should never happen? Report stacktrace to project owner please.");
		}
	}
	
	private static Map<Field, Field> getFieldMatches(Map<String, Field> donor, Map<String, Field> injections){
		Map<Field, Field> matches = new HashMap<>();
		
		donor.forEach((s, field) -> {
			if(injections.containsKey(s)){
				matches.put(field, injections.get(s));
			}
		});
		
		return matches;
	}
	
	private static Map<String, Field> getValidDonorFields(Object guiObject){
		Class<?> donorClass = guiObject.getClass();
		Field[] donorFields = donorClass.getDeclaredFields();
		
		List<Field> validFields = Arrays.stream(donorFields).filter(
				field -> Tearable.class.isAssignableFrom(field.getType()))
				.collect(Collectors.toList());
		
		Map<String, Field> fieldNames = new HashMap<>();
		validFields.forEach(field -> fieldNames.put(getFieldName(field), field));
		return fieldNames;
	}
	
	private static Map<String, Field> getValidInjectionFields(Object injectionObject){
		Class<?> injectionClass = injectionObject.getClass();
		Field[] injFields = injectionClass.getDeclaredFields();
		
		List<Field> validFields = Arrays.stream(injFields)
				.filter(field -> field.isAnnotationPresent(SInject.class))
				.collect(Collectors.toList());
		
		Map<String, Field> namesToField = new HashMap<>();
		validFields.forEach(field -> namesToField.put(getInjectFieldName(field), field));
		
		return namesToField;
	}
	
	private static String getInjectFieldName(Field f){
		f.setAccessible(true);
		SInject sInject = f.getAnnotation(SInject.class);
		String injName = sInject.name();
		return injName.equals("") ? f.getName(): injName;
	}
	
	private static String getFieldName(Field f){
		f.setAccessible(true);
		if(!f.isAnnotationPresent(SElement.class)){
			return f.getName();
		}
		
		SElement sElement = f.getAnnotation(SElement.class);
		String eleName = sElement.value();
		return eleName.equalsIgnoreCase("") ? f.getName(): eleName;
	}
	
}
