package com.bridgelabz.statecensusanalyser;

public class CensusAnalyserException extends Exception {

	public enum ExceptionType {
        CENSUS_FILE_PROBLEM, UNABLE_TO_PARSE, INVALID_HEADER_AND_DELIMITER,WRONG_CENSUS_FILE_EXTENSION;
    }

    public ExceptionType type;

    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public CensusAnalyserException(String message, ExceptionType type, Throwable cause) {
        super(message, cause);
        this.type = type;
    }
}
