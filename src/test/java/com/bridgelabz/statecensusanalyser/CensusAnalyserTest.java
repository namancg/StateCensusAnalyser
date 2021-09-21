package com.bridgelabz.statecensusanalyser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest 
{
	private static final String INDIA_STATE_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndianStateCensusData.csv";
	private static final String WRONG_CSV_FILE_PATH = "./src/main/com/bridgelabz/StateCensusAnaylyser/IndianStateCensusData.csv";
	private static final String INCORRECT_FILE_FORMAT = "./src/test/resources/WrongFileFormat.txt";
	private static final String CSV_WITH_WRONG_DELIMITER = "./src/test/resources/WrongDelimiter.csv";
	private static final String CSV_WITH_INCORRECT_HEADER = "./src/test/resources/WrongHeader.csv";
	
	private static final String INDIA_STATE_CODE_CSV = "./src/test/resources/IndianStateCode.csv";
	private static final String WRONG_STATE_CODE_CSV_PATH = "./src/main/resources/IndianStateCode.csv";
	
	
	@Test
	public void givenIndianCensusCSVFile_WhenCorrectPath_ShouldReturnCorrectRecords() 
	{
		try {
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			int numOfRecords = censusAnalyser.LoadCensusData(INDIA_STATE_CENSUS_CSV_FILE_PATH);
			Assert.assertEquals(33, numOfRecords);
		} 
		catch (CensusAnalyserException e) 
		{
		}
		
	}
	@Test
	public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() 
	{
		try {
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.LoadCensusData(WRONG_CSV_FILE_PATH);
		} 
		catch (CensusAnalyserException e)
		{
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
			e.printStackTrace();
		}
	}
	 @Test
	    public void givenIndiaCensusData_WithWrongFileType_ShouldThrowException()
	 {
	        try {
	            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
	            ExpectedException exceptionRule = ExpectedException.none();
	            exceptionRule.expect(CensusAnalyserException.class);
	            censusAnalyser.LoadCensusData(INCORRECT_FILE_FORMAT);
	        } catch (CensusAnalyserException e) 
	        {
	            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
	        }
	    }
	 @Test
	    public void givenIndiaCensusData_WithWrongDelimiter_ShouldThrowException() 
	 {
	        try {
	            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
	            ExpectedException exceptionRule = ExpectedException.none();
	            exceptionRule.expect(CensusAnalyserException.class);
	            censusAnalyser.LoadCensusData(CSV_WITH_WRONG_DELIMITER);
	        } catch (CensusAnalyserException e)
	        {
	            Assert.assertEquals(CensusAnalyserException.ExceptionType.INVALID_HEADER_AND_DELIMITER, e.type);
	        }
	    }
	  @Test
	    public void givenIndiaCensusData_WithWrongHeader_ShouldThrowException()
	  {
	        try {
	            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
	            censusAnalyser.LoadCensusData(CSV_WITH_INCORRECT_HEADER);
	        } catch (CensusAnalyserException e) 
	        {
	            Assert.assertEquals(CensusAnalyserException.ExceptionType.INVALID_HEADER_AND_DELIMITER, e.type);
	        }
	    }
	  
	  
	  @Test
	    public void givenIndiaStateCodeCSVFile_WhenCorrectPath_ShouldReturnsCorrectRecords()
	    {
	        try
	        {
	            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
	            int numOfRecords = censusAnalyser.loadStateCodeData(INDIA_STATE_CODE_CSV);
	            Assert.assertEquals(37,numOfRecords);
	        }
	        catch (CensusAnalyserException e) { }
	    }

	    @Test
	    public void givenIndianStateCodeCSVFile_WhenWithWrongFilePath_ShouldThrowException()
	    {
	        try
	        {
	        	StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
		        ExpectedException exceptionRule =  ExpectedException.none();
		        exceptionRule.expect(CensusAnalyserException.class);
	            censusAnalyser.loadStateCodeData(WRONG_STATE_CODE_CSV_PATH);
	        }
	        catch (CensusAnalyserException e)
	        {
	            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
	        }
	    }

}
