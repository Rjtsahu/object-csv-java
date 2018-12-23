/**
 *  @author Rajat Sahu 
 *  https://github.com/Rjtsahu/object-csv-java
 *  ObjectCsv Java Library : Handy library to map CSV document to java model. 
 * */
package com.sahurjt.objectcsv.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation interface for a class to define that the class belongs to
 * ObjectCsv parse able model.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CsvModel {

	/**
	 * Indicates weather the CSV has a header row, if not the column will be mapped
	 * based on {@link CsvParameter.columnIndex} and position of CSV row. Default
	 * value is true.
	 */
	boolean headerPresent() default true;
}
