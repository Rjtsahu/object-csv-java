package com.sahurjt.objectcsv;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public final class CsvHolder<T> extends BasicCsvHolder {

	private Class<T> genericClass;
	private List<T> content;

	protected CsvHolder(List<String> lines, Class<T> genericClass) {
		super(lines);
		this.genericClass = genericClass;
		content = new ArrayList<T>();
	}

	protected CsvHolder(List<String> lines, Class<T> genericClass, CsvDelimiter delimiterType)
			throws ObjectCsvException {
		super(lines, delimiterType);
		this.genericClass = genericClass;
		content = new ArrayList<T>();
	}

	public List<T> getCsvRecords() throws ObjectCsvException {
		if (content == null)
			populateContent();

		return this.content;
	}

	public void populateContent() throws ObjectCsvException {
		for (int rowIndex = 0; rowIndex < this.getRowCount(); rowIndex++) {
			int coloumnCount;
			if (containsHeaderRow) {
				// Make this workable for !containsHeaderRow
				coloumnCount = this.getColoumnCount();
				GenericModelAdapter<T> genericModelAdapter = new GenericModelAdapter<T>(genericClass);
				Dictionary<String, String> rowContent = new Hashtable<String, String>();
				/// lets consider simple case where header exist
				for (int colIndex = 0; colIndex < coloumnCount; colIndex++) {

					String headerName = getHeaders().get(colIndex);
					if (headerName == null)
						continue;
					Dictionary<String, String> rowValue = getContent().get(rowIndex);

					if (rowValue == null)
						continue;
					String value = rowValue.get(headerName);
					rowContent.put(headerName, value == null ? "" : value);
				}
				content.add(genericModelAdapter.MapDictionaryToObject(rowContent));
			}
		}
	}

}
