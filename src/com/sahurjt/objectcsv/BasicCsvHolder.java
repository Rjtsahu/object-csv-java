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
class BasicCsvHolder {

	private List<String> headers;

	private int rowCount;

	private int coloumnCount;

	private CsvDelimiter delimiterType;

	// TODO
	/// private char stringDelimiter = '"';

	protected boolean containsHeaderRow;

	private List<Dictionary<String, String>> content;

	protected BasicCsvHolder(List<String> lines, boolean containsHeader) {
		this(lines, containsHeader, CsvDelimiter.COMMA);
	}

	protected BasicCsvHolder(List<String> lines, boolean containsHeader, CsvDelimiter delimiterType) {
		this.delimiterType = delimiterType;
		this.content = new ArrayList<Dictionary<String, String>>();
		this.rowCount = lines.size();
		this.containsHeaderRow = containsHeader;
		/// populate model from given lines.
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

	public List<Dictionary<String, String>> getContent() {
		return content;
	}

	private void populateContent(List<String> lines) {

		if (containsHeaderRow) {
			prepareHeader(getRowFields(lines.get(0), delimiterType));
			// remove header from lines
			lines.remove(0);
		} else {
			this.coloumnCount = getRowFields(lines.get(0), delimiterType).size();
		}

		for (String line : lines) {
			Dictionary<String, String> rowDictionary = new Hashtable<String, String>();
			List<String> fields = getRowFields(line, delimiterType);

			for (int i = 0; i < this.coloumnCount; i++) {
				if (i >= fields.size())
					break;

				if (containsHeaderRow) {
					rowDictionary.put(headers.get(i), fields.get(i));
				} else {
					rowDictionary.put(String.valueOf(i), fields.get(i));
				}
			}
			this.content.add(rowDictionary);
		}
	}

	private void prepareHeader(List<String> fields) {
		this.headers = fields;
		this.coloumnCount = fields.size();
	}

	private List<String> getRowFields(String row, CsvDelimiter seperator) {
		if (row == null)
			return new ArrayList<String>();

		String[] cols = row.split(String.valueOf(CsvDelimiter.getDelimiterChar(seperator)));

		List<String> tokens = new ArrayList<String>();

		for (String token : cols) {
			tokens.add(token.trim());
		}

		return tokens;
	}
}
