package com.riwi.localstorage.repository;

import com.riwi.localstorage.entities.EjemploEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface EjemploRepository extends JpaRepository <EjemploEntidad, Serializable>{
}
