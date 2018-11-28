/**
 *  @author Rajat Sahu 
 *  https://github.com/Rjtsahu/object-csv-java
 *  ObjectCsv Java Library : Handy library to map CSV document to java model. 
 * */
package com.sahurjt.objectcsv;

/**
 * Base Exception class for this library,it will handle all type all type of
 * expection being raised.
 */
@SuppressWarnings("serial")
public class ObjectCsvException extends Exception {

	public ObjectCsvException(String message) {
		super(message);
	}
}
