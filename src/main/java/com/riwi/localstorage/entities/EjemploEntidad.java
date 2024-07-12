package com.riwi.localstorage.entities;

import java.time.LocalDate;
import java.util.Date;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity(name = "ejemplo")
@NoArgsConstructor
@AllArgsConstructor
public class EjemploEntidad {
    //esta tabla de supone que es total_ammount
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate firstDate;
    private LocalDate secondDate;

}
