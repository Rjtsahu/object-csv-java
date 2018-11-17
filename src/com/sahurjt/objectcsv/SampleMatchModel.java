package com.sahurjt.objectcsv;

import java.util.Date;

import com.sahurjt.objectcsv.annotations.CsvModel;
import com.sahurjt.objectcsv.annotations.CsvParameter;

@CsvModel(headerPresent = true)
public class SampleMatchModel {

	@CsvParameter(value = "MATCH_ID")
	public int MATCH_ID;

	@CsvParameter(value = "SEASON")
	public int SEASON;
	
	@CsvParameter(value = "CITY")
	public String CITY;
	
	@CsvParameter(value = "DATE")
	public Date DATE;
	
	@CsvParameter(value = "TEAM1")
	public String TEAM1;
	
	@CsvParameter(value = "TEAM2")
	public String TEAM2;
	
	@CsvParameter(value = "TOSS_WINNER")
	public String TOSS_WINNER;
	
	@CsvParameter(value = "TOSS_DECISION")
	public String TOSS_DECISION;
	
	@CsvParameter(value = "RESULT")
	public String RESULT;
	
	@CsvParameter(value = "WINNER")
	public String WINNER;
	
	public String toString() {
		return "MATCH_ID:"+MATCH_ID+" | SEASON:"+SEASON+" | CITY:"+CITY+
				" | DATE:"+DATE+" | TEAM1:"+TEAM1+" | TEAM2:"+TEAM2+" | TOSS_WINNER:"+TOSS_WINNER+" | TOSS_DECISION:"+
				" | RESULT:" + RESULT + " | WINNER:" + WINNER;
	}
}
