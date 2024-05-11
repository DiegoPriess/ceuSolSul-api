package com.ceuSolAzul.api.controller;

import com.ceuSolAzul.api.enums.TypeRegister;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/enum")
public class EnumController {
    @GetMapping(path = "/type-register")
    public List<Map<String, String>> listTypeRegister() {
        return TypeRegister.getAllValues();
    }
}
