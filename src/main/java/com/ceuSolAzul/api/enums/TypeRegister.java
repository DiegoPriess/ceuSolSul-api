package com.ceuSolAzul.api.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

import java.util.*;

@Getter
public enum TypeRegister {

    FOUND("Pessoas Encontradas"),
    LOST("Pessoas Desaparecidas");

    private final String displayName;

    TypeRegister(String displayName) {
        this.displayName = displayName;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static synchronized TypeRegister create(final HashMap<?, ?> value) {
        return TypeRegister.getByName(value.get("name").toString());
    }

    public static synchronized TypeRegister getByName(final String name) {
        return Arrays.stream(TypeRegister.values()).filter(filter -> filter.name().equals(name)).findFirst().orElse(null);
    }

    public static List<Map<String, String>> getAllValues() {
        List<Map<String, String>> valuesList = new ArrayList<>();
        for (TypeRegister type : TypeRegister.values()) {
            Map<String, String> valueMap = new HashMap<>();
            valueMap.put("name", type.name());
            valueMap.put("displayName", type.getDisplayName());
            valuesList.add(valueMap);
        }
        return valuesList;
    }
}