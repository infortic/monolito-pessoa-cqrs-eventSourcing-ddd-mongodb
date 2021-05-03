package com.artifact.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class AlterarCelularDTO {

	@NotEmpty
	private String cpf;
	private String numeroCelular;	
	
}
