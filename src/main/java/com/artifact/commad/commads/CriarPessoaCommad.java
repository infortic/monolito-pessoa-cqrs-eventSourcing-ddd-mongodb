package com.artifact.commad.commads;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CriarPessoaCommad {
	
	@TargetAggregateIdentifier	
	private String cpf;
	private String nome;
	private String sexo;	

}