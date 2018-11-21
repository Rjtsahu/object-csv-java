/**
 *  @author Rajat Sahu 
 *  https://github.com/Rjtsahu/object-csv-java
 *  ObjectCsv Java Library : Handy library to map CSV document to java model. 
 * */

package com.sahurjt.objectcsv;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

/**
 * This class represent a simple datastructure to store CSV data and its
 * associated details. It can be used as base class for other derived class such
 * as {@link CsvHolder}
 */

class BasicCsvHolder {

	/**
	 * List of string representing header values, will be null when CSV has no
	 * header row.
	 **/
	private List<String> headers;

	/**
	 * Number of records excluding header row.
	 */
	private int rowCount;

	/**
	 * No of columns
	 */
	private int coloumnCount;

	/**
	 * Type of delimiter to parse CSV. {@link CsvDelimiter}
	 */
	private CsvDelimiter delimiterType;

	/**
	 * Boolean indicating weather header row contains in this CSV document, this
	 * should be provided as user input.
	 */
	protected boolean containsHeaderRow;

	/**
	 * List of row (dictionary) represnting all contents of CSV.
	 */
	private List<Dictionary<String, String>> content;

	protected BasicCsvHolder(List<String> lines, boolean containsHeader) {
		this(lines, containsHeader, CsvDelimiter.COMMA);
	}

	protected BasicCsvHolder(List<String> lines, boolean containsHeader, CsvDelimiter delimiterType) {
		this.delimiterType = delimiterType;
		this.content = new ArrayList<Dictionary<String, String>>();
		this.rowCount = lines.size();
		this.containsHeaderRow = containsHeader;

		/** populate model from given lines. **/
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

	/**
	 * Populates {@link #content} from lines by parsing using {@link #delimiterType}
	 * Also sets coloumnCount,rowCount and headers fields.
	 * 
	 * @param lines Csv data.
	 **/
	private void populateContent(List<String> lines) {

		if (containsHeaderRow) {
			prepareHeader(getRowFields(lines.get(0), delimiterType));
			// remove header from lines
			lines.remove(0);
			this.rowCount = this.rowCount - 1;
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

	/**
	 * Sets header and column count
	 * 
	 * @param fields header row.
	 */
	private void prepareHeader(List<String> fields) {
		this.headers = fields;
		this.coloumnCount = fields.size();
	}

	/**
	 * Convert a given row into list of token by spliting it using some delimiter.
	 * 
	 *  @param row  A row in CSV.
	 *  @param seperator delimiter {@link CsvDelimiter}
	 *  */
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
