package com.artifact.commad.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class IncluirEnderecoEvent {
	private String cpf;
	private String rua;
	private Integer numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String paIs;
}