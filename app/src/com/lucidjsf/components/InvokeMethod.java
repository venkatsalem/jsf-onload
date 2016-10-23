package com.lucidjsf.components;

import java.io.IOException;

import javax.el.MethodExpression;
import javax.el.ValueExpression;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.el.MethodBinding;

/**
 * A custom component to invoked method during different phases like decode,
 * encode begin and encode end.
 * <p>
 * onDecode - method will be invoked during the restore phase<br>
 * onEncodeBegin - method will be invoked during the render response phase on
 * the start tag of this component<br>
 * onEncodeEnd - method will be invoked during render response phase on the end
 * of this tag
 * 
 * @author venkat.sadasivam
 */
public class InvokeMethod extends UIComponentBase {

	public static final String COMPONENT_TYPE = "com.lucidjsf.InvokeMethod";

	private MethodExpression onDecode;

	private MethodExpression onEncodeBegin;

	private MethodExpression onEncodeEnd;

	private MethodBinding init;

	public InvokeMethod() {
		super();
		// setRendererType("javax.faces.Text");
	}

	@Override
	public String getFamily() {
		return COMPONENT_TYPE;
	}

	@Override
	public void decode(FacesContext context) {
		super.decode(context);
		if (isRendered()) {
			if (onDecode != null) {
				onDecode.invoke(context.getELContext(), new Object[] {});
			}
		}
	}

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		super.encodeBegin(context);
		if (isRendered()) {
			if (onEncodeBegin == null) {
				ValueExpression expression = getValueExpression("onEncodeBegin");
				expression.getValue(context.getELContext());
				onEncodeBegin = (MethodExpression) expression.getValue(context
						.getELContext());
			}
			if (onEncodeBegin != null) {
				onEncodeBegin.invoke(context.getELContext(), new Object[] {});
			}
		}
	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		super.encodeEnd(context);
		if (isRendered()) {
			if (onEncodeEnd != null) {
				onEncodeEnd.invoke(context.getELContext(), new Object[] {});
			}
		}
	}

	/**
	 * Reference to the method
	 * 
	 * @JSFProperty inheritedTag = "true"
	 * @return
	 */
	public MethodExpression getOnDecode() {
		return onDecode;
	}

	public void setOnDecode(MethodExpression onDecode) {
		this.onDecode = onDecode;
	}

	/**
	 * Reference to the method
	 * 
	 * @JSFProperty inheritedTag = "true"
	 * @return
	 */
	public MethodExpression getOnEncodeBegin() {
		return onEncodeBegin;
	}

	public void setOnEncodeBegin(MethodExpression onEncodeBegin) {
		this.onEncodeBegin = onEncodeBegin;
	}

	/**
	 * Reference to the method
	 * 
	 * @JSFProperty inheritedTag = "true"
	 * @return
	 */
	public MethodExpression getOnEncodeEnd() {
		return onEncodeEnd;
	}

	public void setOnEncodeEnd(MethodExpression onEncodeEnd) {
		this.onEncodeEnd = onEncodeEnd;
	}

	public MethodBinding getInit() {
		return init;
	}

	public void setInit(MethodBinding init) {
		this.init = init;
	}
}
