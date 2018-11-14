package com.sahurjt.objectcsv.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CsvParameter {

	/// Name of header in CSV from this field has to map.
	public String value() default "";
}
