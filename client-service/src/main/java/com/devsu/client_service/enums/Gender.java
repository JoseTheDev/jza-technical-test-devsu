package com.devsu.client_service.enums;

import lombok.Getter;

@Getter
public enum Gender {
    M("MALE"),
    F("FEMALE"),
    O("OTHER"),
    X("PREFER NOT TO SAY");
    
    private final String description;
    
    Gender(String description) {
        this.description = description;
    }
}
