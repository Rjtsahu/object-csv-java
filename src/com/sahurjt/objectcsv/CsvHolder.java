package com.sahurjt.objectcsv;

import java.util.List;

public final class CsvHolder<T> extends BasicCsvHolder {

	private T modelInstance;
	private List<T> content;
	
	protected CsvHolder(List<String> lines) {
		super(lines);
	}

	protected CsvHolder(List<String> lines, CsvDelimiter delimiterType) {
		super(lines,delimiterType);
	}
	
	
}
