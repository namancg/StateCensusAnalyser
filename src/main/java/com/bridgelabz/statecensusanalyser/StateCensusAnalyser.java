package com.bridgelabz.statecensusanalyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

import com.bridgelabz.statecensusanalyser.CensusAnalyserException.ExceptionType;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyser {
	public int LoadCensusData(String csvFilePath) throws CensusAnalyserException {
		if(csvFilePath.contains("txt"))
		{
			throw new CensusAnalyserException("",ExceptionType.CENSUS_FILE_PROBLEM);
		}
		try {
	        Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
	        CsvToBeanBuilder<CSVStateCensus> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
	        csvToBeanBuilder.withType(CSVStateCensus.class);
	        csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
	        CsvToBean<CSVStateCensus> csvToBean = csvToBeanBuilder.build();
	        Iterator<CSVStateCensus> censusCSVIterator = csvToBean.iterator();;
	        Iterable<CSVStateCensus> csvIterable = () -> censusCSVIterator;
	        int numOfEateries = (int) StreamSupport.stream(csvIterable.spliterator(),false).count();
	        return numOfEateries;
	    } catch (IOException e) {
	        throw new CensusAnalyserException(e.getMessage(),
	                                          CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
	    } catch (IllegalStateException e) {
	        throw new CensusAnalyserException(e.getMessage(),
	                                         CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);
	    } catch (RuntimeException e) {
	        throw new CensusAnalyserException("Invalid header or Delimiter",
	                                         CensusAnalyserException.ExceptionType.INVALID_HEADER_AND_DELIMITER);
	    }
	}
	 public int loadStateCodeData(String csvFilePath) throws CensusAnalyserException {
	        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
	            CsvToBeanBuilder<CSVStateCode> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
	            csvToBeanBuilder.withType(CSVStateCode.class);
	            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
	            CsvToBean<CSVStateCode> csvToBean = csvToBeanBuilder.build();
	            Iterator<CSVStateCode> stateCodeCSVIterator = csvToBean.iterator();;
	            Iterable<CSVStateCode> csvIterable = () -> stateCodeCSVIterator;
	            int numOfEateries = (int) StreamSupport.stream(csvIterable.spliterator(),false).count();
	            return numOfEateries;
	        } catch (IOException e) {
	            throw new CensusAnalyserException(e.getMessage(),
	                                              CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
	        } catch (IllegalStateException e) {
	            throw new CensusAnalyserException(e.getMessage(),
	                                             CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);
	        } catch (RuntimeException e) {
	            throw new CensusAnalyserException("Invalid header or Delimiter",
	                                            CensusAnalyserException.ExceptionType.INVALID_HEADER_AND_DELIMITER);
	        }
	    }
}
