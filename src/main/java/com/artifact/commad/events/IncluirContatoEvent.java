package com.artifact.commad.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class IncluirContatoEvent {
	private String cpf;
	private String telefoneFixo;
	private String email;	
}
