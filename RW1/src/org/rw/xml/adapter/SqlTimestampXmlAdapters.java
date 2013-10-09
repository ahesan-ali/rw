package org.rw.xml.adapter;

import java.sql.Timestamp;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class SqlTimestampXmlAdapters extends XmlAdapter<Date, Timestamp> {

	@Override
	public Timestamp unmarshal(Date date) throws Exception {
		return new Timestamp(date.getTime());
	}

	@Override
	public Date marshal(Timestamp timestamp) throws Exception {
		return new Date(timestamp.getTime());
	}

}
