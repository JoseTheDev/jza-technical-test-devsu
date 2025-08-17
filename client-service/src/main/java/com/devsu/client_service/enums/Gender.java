package com.devsu.client_service.enums;

import lombok.Getter;

@Getter
public enum Gender {
    MALE("M"),
    FEMALE("F"),
    OTHER("O"),
    PREFER_NOT_TO_SAY("X");
    
    private final String code;
    
    Gender(String code) {
        this.code = code;
    }
}
