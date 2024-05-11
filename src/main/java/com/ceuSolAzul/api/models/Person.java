package com.ceuSolAzul.api.models;

import com.ceuSolAzul.api.enums.TypeRegister;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Lob
    @Column(name="img", nullable = false)
    private byte[] img;

    @Column(name="observation")
    private String observation;

    @Column(name="address", nullable = false)
    private String address;

    @Column(name="type_register", nullable = false)
    private TypeRegister type;

    @Column(name="responsable_name", nullable = false)
    private String responsableName;

    @Column(name="responsable_contact", nullable = false)
    private String responsableContact;

    @Column(name="date_created", nullable = false)
    private LocalDateTime dateCreation;
}
