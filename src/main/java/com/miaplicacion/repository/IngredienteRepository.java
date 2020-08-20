package com.miaplicacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miaplicacion.modelo.Ingrediente;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {

}
