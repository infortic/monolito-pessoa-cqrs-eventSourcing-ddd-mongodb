package com.artifact.commad.commads;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IncluirContatoCommad {
	
	@TargetAggregateIdentifier	private String cpf;
	private String telefoneFixo;
	private String email;	
	
}
