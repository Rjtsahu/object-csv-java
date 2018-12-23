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

import com.sahurjt.objectcsv.annotations.CsvModel;

/**
 * Class to hold CSV data in generic object T.
 * 
 * @param T Model containg CsvModel annotation.
 * @see {CsvModel}
 */
public final class CsvHolder<T> extends BasicCsvHolder {

	/**
	 * Generic class holder.
	 */
	private Class<T> genericClass;

	/**
	 * Rows in CSV file casted to type T
	 */
	private List<T> content;

	CsvHolder(List<String> lines, Class<T> genericClass) {
		super(lines, isHeaderPresent(genericClass));
		this.genericClass = genericClass;
		content = new ArrayList<T>();
	}

	CsvHolder(List<String> lines, Class<T> genericClass, CsvDelimiter delimiterType) throws ObjectCsvException {
		super(lines, isHeaderPresent(genericClass), delimiterType);
		this.genericClass = genericClass;
		content = new ArrayList<T>();
	}

	/**
	 * Populated content with CSV by parsing it to T.
	 * 
	 * @return Rows of CSV content casted to type T.
	 * @throws ObjectCsvException in case of IllegalAccessException or
	 *                            InstantiationException
	 */
	public List<T> getCsvRecords() throws ObjectCsvException {
		if (content == null)
			populateContent();

		return this.content;
	}

	/**
	 * Static helper method to check weather the generic model has headerPresent
	 * true or false.
	 * 
	 * @return true when given model has {@link CsvModel#headerPresent()} is
	 *         true. Method will return false when given class doesn't have CsvModel
	 *         attribute.
	 */
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

	/**
	 * This funtion will iterate through all rows/columns and map class properties
	 * with {@link BasicCsvHolder#getContent()} values.
	 * 
	 * @throws ObjectCsvException In case of any generic exception.
	 */
	void populateContent() throws ObjectCsvException {
		for (int rowIndex = 0; rowIndex < this.getRowCount(); rowIndex++) {

			Dictionary<String, String> rowValue = getContent().get(rowIndex);
			GenericModelAdapter<T> genericModelAdapter = new GenericModelAdapter<T>(genericClass);
			Dictionary<String, String> rowContent = new Hashtable<String, String>();

			int coloumnCount;
			if (containsHeaderRow) {
				coloumnCount = this.getColumnCount();
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
