package com.lucidjsf.components;

import javax.faces.webapp.UIComponentELTag;

/**
 * @author venkat.sadasivam
 */
public class InvokeMethodTag extends UIComponentELTag {

	@Override
	public String getComponentType() {
		return InvokeMethod.COMPONENT_TYPE;
	}

	@Override
	public String getRendererType() {
		return null;
	}

}
