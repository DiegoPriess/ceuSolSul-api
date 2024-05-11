package com.ceuSolAzul.api.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TypeRegister {

    FOUND(0),
    LOST(1);

    private final int value;

    TypeRegister(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    @JsonCreator
    public static TypeRegister fromValue(int value) {
        for (TypeRegister status : TypeRegister.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}