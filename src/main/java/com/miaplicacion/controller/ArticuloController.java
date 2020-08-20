package com.miaplicacion.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miaplicacion.dto.ArticuloDTO;
import com.miaplicacion.dto.converter.ArticuloDTOConverter;
import com.miaplicacion.error.ArticuloNotFoundException;
import com.miaplicacion.modelo.Articulo;
import com.miaplicacion.repository.ArticuloRepository;

@RestController
@RequestMapping("/api/articulo")
public class ArticuloController {
	
	@Autowired
	private ArticuloRepository articuloRepository;
	
	@Autowired
	private ArticuloDTOConverter articuloDTOConverter;
	
	@GetMapping("/test")
	public void guardarUnValor() {
		Articulo articulo = new Articulo();
		articulo.setNombre("Primer Articulo");
		articulo.setPrecio(2000);
		articuloRepository.save(articulo);
	}
	

	@GetMapping
	public ResponseEntity<?> obtenerTodos(){
		List<Articulo> resultado = articuloRepository.findAll();
		if(resultado.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			List<ArticuloDTO> articuloList = 
					resultado.stream()
					         .map(articuloDTOConverter::convertToDto)
					         .collect(Collectors.toList());
			return ResponseEntity.ok(articuloList);
		}
	}
	
	@GetMapping("/{id}")
	public Articulo obtenerUno(@PathVariable Long id) {
		return articuloRepository.findById(id)
				.orElseThrow(() -> new ArticuloNotFoundException(id));
	}
	
	@PostMapping
	public ResponseEntity<Articulo> nuevoarticulo(@RequestBody ArticuloDTO articulo) {
		Articulo articuloEntity = articuloDTOConverter.convertToEntity(articulo);		
		return ResponseEntity.status(HttpStatus.CREATED).body(articuloRepository.save(articuloEntity));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editarArticulo(@RequestBody Articulo nuevo, @PathVariable Long id) {
		return articuloRepository.findById(id).map(p -> {
			p.setNombre(nuevo.getNombre());
			p.setPrecio(nuevo.getPrecio());
			return ResponseEntity.ok(articuloRepository.save(p));
		}).orElseThrow(() -> new ArticuloNotFoundException(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> borrarProducto(@PathVariable Long id) {
		 
	Articulo articulo = articuloRepository.findById(id)
		  .orElseThrow(() -> new ArticuloNotFoundException(id));
		 
         articuloRepository.delete(articulo);
    return ResponseEntity.noContent().build();
	}
	

}
