package com.artifact.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class IncluirEnderecoDTO {

	@NotEmpty
	private String cpf;
	private String rua;
	private Integer numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String paIs;
	
}
