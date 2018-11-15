package com.sahurjt.objectcsv;

import com.sahurjt.objectcsv.annotations.CsvModel;
import com.sahurjt.objectcsv.annotations.CsvParameter;

@CsvModel(headerPresent = true)
public class SampleModel {

	@CsvParameter(value = "Txn Date")
	public String txnDate;

	@CsvParameter(value = "Value Date")
	public String valueDate;

	@CsvParameter(value = "Reference No")
	public String refNo;

	@CsvParameter(value = "Description")
	public String description;

	@CsvParameter(value = "Debit Amount")
	public String debitAmount;

	@CsvParameter(value = "Credit Amount")
	public String creditAmount;

	@CsvParameter(value = "Running Balance")
	public String runningBalance;

	@Override
	public String toString() {
		return "txnDate:" + txnDate + " | valueDate:" + valueDate + " |refNo:" + refNo + " |description:" + description
				+ " | debitAmount:" + debitAmount + " | creditAmount:" + creditAmount + " | runningBalance:"
				+ runningBalance;
	}
}
