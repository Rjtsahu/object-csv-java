package com.sahurjt.objectcsv.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CsvModel {

	/// Indicates weather the CSV has a header row, if not the column will be mapped based on 
	/// #CsvParameter.coloumnIndex and position of CSV row.
	public boolean headerPresent() default false;
}
