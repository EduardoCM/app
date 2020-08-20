package com.miaplicacion.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Articulo implements Serializable {
	
	private static final long serialVersionUID = 7895782755243392855L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	
	private float precio;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "articulo_id", referencedColumnName = "id")
	private List<Ingrediente> integrediente = new ArrayList<>();

}
