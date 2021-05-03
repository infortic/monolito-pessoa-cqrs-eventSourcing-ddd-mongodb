package com.artifact.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class IncluirContatoDTO {	
	
	@NotEmpty
	private String cpf;
	private String telefoneFixo;
	private String email;	
	
}