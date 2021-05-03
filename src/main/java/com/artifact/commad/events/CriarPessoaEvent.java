package com.artifact.commad.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CriarPessoaEvent {
	private String cpf;
	private String nome;
	private String sexo;
}
