/**
 *  @author Rajat Sahu 
 *  https://github.com/Rjtsahu/object-csv-java
 *  ObjectCsv Java Library : Handy library to map CSV document to java model. 
 * */
package com.sahurjt.objectcsv;

import java.util.List;

/**
 * <b>This is main class to use this library,it should be used as singleton
 * helper class.</b> </br> Example : </br>
 * <code> 
 * 		CsvHolder<SampleModel> holder = ObjectCsv.getInstance().from(FILE_PATH).with(CsvDelimiter.TAB).getCsvHolderforClass(SampleModel.class);
 * 		
 * 		List<SampleModel> models = holder.getCsvRecords();
 * </code>
 */

public class ObjectCsv {

	/**
	 * static instance of ObjectCsv class.
	 */
	private static ObjectCsv thisInstance;

	
	/**
	 * Type of delimiter contains in CSV file 
	 * @see CsvDelimiter 
	 * */
	private CsvDelimiter delimiterType = CsvDelimiter.COMMA;
	
	/**
	 * Lines in CSV files
	 * */
	private List<String> lines;

	/**
	 * Private constructor to avoid instance creation for ObjectCsv class.
	 * */
	private ObjectCsv() {
	}

	
	/**
	 * Create new instance  of ObjectCsv if not created.
	 * @param <T> Class which has be casted.
	 * @return {@link ObjectCsv} 
	 * */
	public static <T> ObjectCsv getInstance() {
		if (thisInstance == null)
			thisInstance = new ObjectCsv();
		return thisInstance;
	}

	public ObjectCsv from(List<String> lines) {
		this.lines = lines;
		return thisInstance;
	}

	public ObjectCsv from(String filePath) throws ObjectCsvException {
		try {
			this.lines = FileHelper.readFileByLine(filePath);
		} catch (Exception e) {
			throw new ObjectCsvException(
					"Error in reading from file path:" + filePath + " | Error reason: " + e.getMessage());
		}
		return thisInstance;
	}

	public ObjectCsv with(CsvDelimiter delimiterType) {
		this.delimiterType = delimiterType;
		return thisInstance;
	}

	public <T> CsvHolder<T> getCsvHolderforClass(Class<T> classInstance) throws ObjectCsvException {
		if (lines == null)
			throw new ObjectCsvException(
					"Input csv data cannot be null,assign input using from() method before calling this method.");

		CsvHolder<T> csvHolder = new CsvHolder<T>(lines, classInstance, delimiterType);
		csvHolder.populateContent();
		return csvHolder;
	}
}
