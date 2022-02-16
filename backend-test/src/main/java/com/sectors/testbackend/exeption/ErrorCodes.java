package com.sectors.testbackend.exeption;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
public enum ErrorCodes {

    RECORD_NOT_FOUND("000001", "Record not found", HttpStatus.NOT_FOUND),
    SECTOR_NOT_FOUND("000002", "Sector not found", HttpStatus.NOT_FOUND);

    private String code;
    private String message;
    private HttpStatus httpStatus;;
}
