package com.miaplicacion.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class ApiError {
	
	@NotNull
	private HttpStatus status;
	
	@JsonFormat(shape = Shape.STRING, pattern="dd/MM/yyyy hh:mm:ss")
	private LocalDateTime fecha = LocalDateTime.now() ;
	
	@NotNull
	private String mensaje;
	

}
