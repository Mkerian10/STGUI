package com.stdev.stgui.injection;

public interface Buildable{
	
	/**
	 * Builds the element from the given string. Typically this string should be the exact result
	 * of teardown().
	 *
	 * @param injectionStr String to build object from
	 */
	void build(String injectionStr);
}
