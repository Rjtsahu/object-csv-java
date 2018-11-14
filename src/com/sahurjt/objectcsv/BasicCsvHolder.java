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
public class BasicCsvHolder<T> {

	private T objectType;

	private List<String> headers;
	private int rowCount;
	private int coloumnCount;
	private CsvDelimiter delimiterType;
	private List<Dictionary<String, String>> content;

	private List<T> modelContent;

	public BasicCsvHolder(T objectType) {
		this.objectType = objectType;
		delimiterType = CsvDelimiter.COMMA;
		content = new ArrayList<Dictionary<String, String>>();
		System.out.println(objectType.getClass());
	}

	public T TestGeneric(Class<T> cls) {
		try {

			T t = cls.newInstance();
			Field prop1 = t.getClass().getField("PropertyName");
			System.out.println("type : " + prop1.getType());
			System.out.println("prop value: " + prop1.get(t));
			prop1.set(t, "New Value");
			System.out.println("prop with new set value: " + prop1.get(t));
			return t;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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

	public T getGenericType() {
		return objectType;
	}

	public List<Dictionary<String, String>> getContent() {
		return content;
	}

	public void Test(List<String> lines) {

		prepareHeader(getRowFields(lines.get(0), delimiterType));
		// remove header from lines
		lines.remove(0);

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
