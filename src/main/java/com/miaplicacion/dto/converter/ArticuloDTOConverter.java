package com.miaplicacion.dto.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.miaplicacion.dto.ArticuloDTO;
import com.miaplicacion.modelo.Articulo;

@Component
public class ArticuloDTOConverter {

	@Autowired
	private ModelMapper modelMapper;
	
	
	public ArticuloDTO convertToDto(Articulo articulo) {
		return modelMapper.map(articulo, ArticuloDTO.class);
	}
	
	public Articulo convertToEntity(ArticuloDTO articuloDto) {
		return modelMapper.map(articuloDto, Articulo.class);
	}
	
}
