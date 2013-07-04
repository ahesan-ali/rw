package org.rw.spring.propertyeditor;

import java.beans.PropertyEditorSupport;

import org.rw.util.TimestampUtils;
import org.springframework.stereotype.Component;

@Component
public class TimestampPropertyEditor extends PropertyEditorSupport {

	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(TimestampUtils.parse(text));
	}
	
	
}
