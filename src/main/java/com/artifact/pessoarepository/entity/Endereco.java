package com.artifact.pessoarepository.entity;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.google.type.DateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Endereco {

	private Long timestamp;
	@Id
	private String id = UUID.randomUUID().toString();
	private String cpf;
	private String rua;
	private Integer numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String paIs;
	private Date DataCadastro = new Date();
	
	
}
