package com.bridgelabz.statecensusanalyser;
import org.junit.Assert;
import org.junit.Test;

public class CensusAnalyserTest {
	private static final String INDIA_STATE_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndianStateCensusData.csv";
	
	@Test
	public void givenIndianCensusCSVFile_WhenCorrectPath_ShouldReturnCorrectRecords() 
	{
		try {
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			int numOfRecords = censusAnalyser.LoadCensusData(INDIA_STATE_CENSUS_CSV_FILE_PATH);
			Assert.assertEquals(33, numOfRecords);
		} 
		catch (CensusAnalyserException e) {
		}
	}
	
}
