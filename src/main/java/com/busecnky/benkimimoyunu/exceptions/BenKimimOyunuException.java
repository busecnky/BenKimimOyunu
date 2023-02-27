package com.busecnky.benkimimoyunu.exceptions;

import lombok.Getter;

@Getter
public class BenKimimOyunuException extends RuntimeException{
    private final ErrorType errorType;

    public BenKimimOyunuException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public BenKimimOyunuException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }
}
