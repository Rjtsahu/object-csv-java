package com.sahurjt.objectcsv;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

/*
 * This is model which will hold CSV file in table format, with having
 * some of common CSV properties.
 * here the DataType will be string for every field
 * */
public class BasicCsvHolder {

	private List<String> headers;

	private int rowCount;

	private int coloumnCount;

	private CsvDelimiter delimiterType;

	// TODO
	/// private char stringDelimiter = '"';

	protected boolean containsHeaderRow = true;

	private List<Dictionary<String, String>> content;

	protected BasicCsvHolder(List<String> lines) {
		this(lines, CsvDelimiter.COMMA);
	}

	protected BasicCsvHolder(List<String> lines, CsvDelimiter delimiterType) {
		this.delimiterType = delimiterType;
		this.content = new ArrayList<Dictionary<String, String>>();
		this.populateContent(lines);
		this.rowCount = lines.size();
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

	public List<Dictionary<String, String>> getContent() {
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
				d.put(headers.get(i), fields.get(i)); /// fix for !containsHeaderRow
			}
			content.add(d);
		}
	}

	private void prepareHeader(List<String> fields) {
		headers = fields;
		coloumnCount = fields.size();
	}

	private List<String> getRowFields(String row, CsvDelimiter seperator) {
		String[] cols = row.split(String.valueOf(CsvDelimiter.getDelimiterChar(seperator)));
		
		List<String> tokens = new ArrayList<String>();
		
		for (String token : cols) {
			tokens.add(token.trim());
		}
		
		return tokens;
	}
}
