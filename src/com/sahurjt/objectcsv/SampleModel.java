package com.sahurjt.objectcsv;

import javax.annotation.Generated;

import com.sahurjt.objectcsv.annotations.CsvModel;
import com.sahurjt.objectcsv.annotations.CsvParameter;

@CsvModel(headerPresent = true)
public class SampleModel {

	@CsvParameter(value = "Txn Date")
	public String txnDate;

	@CsvParameter(value = "Value Date")
	public String valueDate;

	@CsvParameter(value = "Reference No")
	public int refNo;

	@CsvParameter(value = "Description")
	public String description;

	@CsvParameter(value = "Debit Amount")
	public String debitAmount;

	@CsvParameter(value = "Credit Amount")
	public int creditAmount;

	@CsvParameter(value = "Running Balance")
	public double runningBalance;

	@Override
	public String toString() {
		return "txnDate:" + txnDate + " | valueDate:" + valueDate + " |refNo:" + refNo + " |description:" + description
				+ " | debitAmount:" + debitAmount + " | creditAmount:" + creditAmount + " | runningBalance:"
				+ runningBalance;
	}
}
