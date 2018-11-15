package com.sahurjt.objectcsv;

import java.util.List;

public class ObjectCsv {

	private static ObjectCsv thisInstance;
	private CsvDelimiter delimiterType = CsvDelimiter.COMMA;
	private List<String> lines;

	private ObjectCsv() {
	}

	public static <T> ObjectCsv getInstance() {
		if (thisInstance == null)
			thisInstance = new ObjectCsv();
		return thisInstance;
	}

	public ObjectCsv from(List<String> lines) {
		this.lines = lines;
		return thisInstance;
	}

	public <T> CsvHolder<T> getCsvHolderforClass(Class<T> classInstance) throws GenericModelMappingException {
		// TODO : set lines validation
		CsvHolder<T> csvHolder = new CsvHolder<T>(lines, classInstance, delimiterType);
		csvHolder.populateContent();
		return csvHolder;
	}
}
