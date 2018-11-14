package com.sahurjt.objectcsv;

public enum CsvDelimiter {
	COMMA, PIPE, DOLAR;

	public static char getDelimiterChar(CsvDelimiter delimiterType) {
		switch (delimiterType) {
		case COMMA:
			return ',';
		case PIPE:
			return '|';
		case DOLAR:
			return '$';
		default:
			return ',';
		}
	}
}
