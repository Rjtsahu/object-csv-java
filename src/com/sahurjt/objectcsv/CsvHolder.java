package com.sahurjt.objectcsv;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import com.sahurjt.objectcsv.annotations.CsvModel;

public final class CsvHolder<T> extends BasicCsvHolder {

	private Class<T> genericClass;
	private List<T> content;

	CsvHolder(List<String> lines, Class<T> genericClass) {
		super(lines, isHeaderPresent(genericClass));
		this.genericClass = genericClass;
		content = new ArrayList<T>();
	}

	CsvHolder(List<String> lines, Class<T> genericClass, CsvDelimiter delimiterType) throws ObjectCsvException {
		super(lines, isHeaderPresent(genericClass),delimiterType);
		this.genericClass = genericClass;
		content = new ArrayList<T>();
	}

	public List<T> getCsvRecords() throws ObjectCsvException {
		if (content == null)
			populateContent();

		return this.content;
	}

	private static boolean isHeaderPresent(Class<?> genericClass) {
		try {
			CsvModel csvAnnotation = genericClass.newInstance().getClass().getAnnotation(CsvModel.class);
			if (csvAnnotation == null)
				return false;
			return csvAnnotation.headerPresent();
		} catch (Exception e) {
			return false;
		}
	}

	void populateContent() throws ObjectCsvException {
		for (int rowIndex = 0; rowIndex < this.getRowCount(); rowIndex++) {

			Dictionary<String, String> rowValue = getContent().get(rowIndex);
			GenericModelAdapter<T> genericModelAdapter = new GenericModelAdapter<T>(genericClass);
			Dictionary<String, String> rowContent = new Hashtable<String, String>();

			int coloumnCount;
			if (containsHeaderRow) {
				coloumnCount = this.getColoumnCount();
			} else {
				coloumnCount = rowValue == null ? 0 : rowValue.size();
			}

			for (int colIndex = 0; colIndex < coloumnCount; colIndex++) {

				String headerName;
				if (containsHeaderRow) {
					headerName = getHeaders().get(colIndex);
				} else {
					headerName = String.valueOf(colIndex);
				}

				if (headerName == null)
					continue;

				if (rowValue == null)
					continue;

				String value = rowValue.get(headerName);
				rowContent.put(headerName, value == null ? "" : value);
			}
			content.add(genericModelAdapter.MapDictionaryToObject(rowContent));
		}
	}

}
