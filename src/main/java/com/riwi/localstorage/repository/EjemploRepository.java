package com.riwi.localstorage.repository;

import com.riwi.localstorage.entities.EjemploEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface EjemploRepository extends JpaRepository<EjemploEntidad, Serializable> {

//   @Query("SELECT u FROM ejemplo u ORDER BY u.sales DESC BETWEEN ?1 AND ?2")
//   List<EjemploEntidad> findTopNByAge( Date startDate, Date endDate);

  @Query(value = "SELECT id FROM ejemplo WHERE firstDate = ? GROUP BY id LIMIT 1;", nativeQuery = true)
  Long findProductMostSellDay(LocalDate startDate);

}
