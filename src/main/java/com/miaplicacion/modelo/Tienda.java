package com.miaplicacion.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ingrediente")
public class Tienda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String nombre;
	
	@ManyToMany
	@JoinTable(name = "articulos_tiendas", 
	   joinColumns = @JoinColumn(name="articulo_id", referencedColumnName = "id"),
	   inverseJoinColumns = @JoinColumn(name="ingrediente_id", referencedColumnName = "id"))
	private Set<Articulo> articulos = new HashSet<>();
	
	
	

}
