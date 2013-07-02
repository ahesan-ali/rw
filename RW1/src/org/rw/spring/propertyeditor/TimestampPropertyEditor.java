package org.rw.spring.propertyeditor;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.rw.util.TimestampUtils;
import org.springframework.stereotype.Component;

@Component
public class TimestampPropertyEditor extends PropertyEditorSupport {

	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(TimestampUtils.parse(text));
	}
	
	
}
