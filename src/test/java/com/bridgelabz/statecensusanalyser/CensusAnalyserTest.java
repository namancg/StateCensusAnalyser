package com.bridgelabz.statecensusanalyser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest {
	private static final String INDIA_STATE_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndianStateCensusData.csv";
	private static final String WRONG_CSV_FILE_PATH = "./src/main/com/bridgelabz/StateCensusAnaylyser/IndianStateCensusData.csv";
	private static final String INCORRECT_FILE_FORMAT = "./src/test/resources/WrongFileFormat.txt";
	
	
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
	@Test
	public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
		try {
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.LoadCensusData(WRONG_CSV_FILE_PATH);
		} 
		catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
			e.printStackTrace();
		}
	}
	 @Test
	    public void givenIndiaCensusData_WithWrongFileType_ShouldThrowException() {
	        try {
	            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
	            ExpectedException exceptionRule = ExpectedException.none();
	            exceptionRule.expect(CensusAnalyserException.class);
	            censusAnalyser.LoadCensusData(INCORRECT_FILE_FORMAT);
	        } catch (CensusAnalyserException e) {
	            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
	        }
	    }
	 
}
