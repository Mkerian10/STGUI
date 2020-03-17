package com.stdev.stgui.injection;

public interface Tearable{
	
	/**
	 * Decomposes the element into a string that can be used to extract the used data from it,
	 * or to rebuild the element with its current state. For example a text field would decompose
	 * into the text within the field
	 *
	 * @return The information encased in the element
	 */
	String teardown();
	
}
