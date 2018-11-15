package com.sahurjt.objectcsv;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

/*
 * This is model which will hold csv file in table format, with having
 * some of common csv properties.
 * here the datatype will be string for every field
 * */
public class BasicCsvHolder {

	private List<String> headers;

	private int rowCount;

	private int coloumnCount;

	private CsvDelimiter delimiterType;

	// TODO
	private char stringDelimiter = '"';

	protected boolean containsHeaderRow = true;

	private List<Dictionary<String, String>> content;

	public BasicCsvHolder(List<String> lines) {
		this(lines, CsvDelimiter.COMMA);
	}

	public BasicCsvHolder(List<String> lines, CsvDelimiter delimiterType) {
		this.delimiterType = delimiterType;
		this.content = new ArrayList<Dictionary<String, String>>();
		this.populateContent(lines);
	}

	public List<String> getHeaders() {
		return headers;
	}

	public int getRowCount() {
		return rowCount;
	}

	public int getColoumnCount() {
		return coloumnCount;
	}

	public CsvDelimiter getDelimiterType() {
		return delimiterType;
	}

	public List<?> getContent() {
		return content;
	}

	private void populateContent(List<String> lines) {
		
		if (containsHeaderRow) {
			prepareHeader(getRowFields(lines.get(0), delimiterType));
			// remove header from lines
			lines.remove(0);
		}
		
		for (String line : lines) {
			Dictionary<String, String> d = new Hashtable<String, String>();
			List<String> fields = getRowFields(line, delimiterType);

			for (int i = 0; i < headers.size(); i++) {
				if (i >= fields.size())
					break;
				d.put(headers.get(i), fields.get(i));
			}
			content.add(d);
		}
	}

	private void prepareHeader(List<String> fields) {
		headers = fields;
		coloumnCount = fields.size();
	}

	private List<String> getRowFields(String row, CsvDelimiter seperator) {
		return Arrays.asList(row.split(String.valueOf(CsvDelimiter.getDelimiterChar(seperator))));
	}
}
