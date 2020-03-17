package com.stdev.stgui.injection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SInject{
	
	/**
	 * This annotation is NOT the type of the field it's annotating. It's the type of the function
	 * which it should map to. For example if your teardown() results in a number "32" and you want
	 * to map it to an int. You'd insert Integer.class because it'll call Integer.valueOf().
	 *
	 * You can set custom classes or enums as this value as long as they implement
	 * 		<TYPE> valueOf(String s); returning the type of the FIELD THIS IS ANNOTATING.
	 * 	For any primitive simply take its class (e.g. byte -> Byte). If you want a string then leave
	 * 	this as default or explicitly specify String.class
	 *
	 * Enums have valueOf() built in so if you want it to map to an enum simply ensure that the string
	 * returned by teardown will map to something in valueOf().
	 *
	 * valueOf() must be static.
	 */
	Class<?> value() default String.class;
	
	/**
	 * Specifies an alternate name to map to the donor field. This can either be the name of the field
	 * in your GUI object, or the name specified by an SElement annotation. Blank ("") names will use
	 * the field name by default
	 */
	String name() default "";
}
