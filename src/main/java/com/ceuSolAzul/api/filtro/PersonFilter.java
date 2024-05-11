package com.ceuSolAzul.api.filtro;

import com.ceuSolAzul.api.enums.TypeRegister;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonFilter {

    private Integer page;

    private Integer size;

    private String name;

    private TypeRegister type;
}
