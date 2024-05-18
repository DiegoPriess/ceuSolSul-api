package com.ceuSolAzul.api.filtro;

import com.ceuSolAzul.api.enums.TypeRegister;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonFilter {

    private String name;

    private String address;

    private TypeRegister type;

    private Integer page;

    private Integer size;

}
