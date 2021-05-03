package com.artifact.commad.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AlterarCelularEvent {
	private String cpf;
	private String numeroCelular;	
}
