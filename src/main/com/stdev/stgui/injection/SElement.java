package com.stdev.stgui.injection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SElement{
	
	/**
	 * Value of the name of the variable to inject. This can generally be left blank if you set the
	 * variable names the same, however in the event you'd prefer to have different names you can
	 * annotate the Tearable variable with the name of the field you're injecting
	 *
	 * @return Name of the field to be injected, "" if the same as the name in the GUI class
	 */
	String value() default "";
}
