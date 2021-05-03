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
public class IncluirEnderecoCommad {

	@TargetAggregateIdentifier private String cpf;
	private String rua;
	private Integer numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String paIs;

}
