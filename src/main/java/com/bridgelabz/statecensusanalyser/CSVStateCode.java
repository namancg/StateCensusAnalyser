package com.bridgelabz.statecensusanalyser;

import com.opencsv.bean.CsvBindByName;

public class CSVStateCode {
	  @CsvBindByName(column = "State Name", required = true)
	    public String State;

	    @CsvBindByName(column = "StateCode", required = true)
	    public String StateCode;

	    @Override
	    public String toString() {
	        return "IndianStateCodeCSV{" +
	                ", state='" + State + '\'' +
	                ", StateCode='" + StateCode + '\'' +
	                '}';
	    }
}
