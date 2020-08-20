package com.miaplicacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miaplicacion.modelo.Articulo;

public interface ArticuloRepository extends JpaRepository<Articulo, Long> {

}
