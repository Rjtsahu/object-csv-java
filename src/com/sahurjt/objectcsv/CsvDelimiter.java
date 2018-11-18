package com.sahurjt.objectcsv;

public enum CsvDelimiter {
	COMMA, PIPE, COLON,SPACE,TAB;

	public static char getDelimiterChar(CsvDelimiter delimiterType) {
		switch (delimiterType) {
		case COMMA:
			return ',';
		case PIPE:
			return '|';
		case COLON:
			return ':';
		case SPACE:
			return ' ';
		case TAB:
			return '	';
		default:
			return ',';
		}
	}
}
