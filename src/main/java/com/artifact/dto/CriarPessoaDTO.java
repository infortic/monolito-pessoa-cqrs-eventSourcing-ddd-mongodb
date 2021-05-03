package com.artifact.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CriarPessoaDTO {

	@NotEmpty
	private String cpf;
	private String nome;
	private String sexo;
	
	
}
