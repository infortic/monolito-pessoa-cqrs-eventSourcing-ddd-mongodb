package com.artifact.pessoarepository.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
		
	@Id
	private String cpf;
	private String nome;
	private String sexo;
	private Long timestamp;
	
	private Date DataCadastro = new Date();
	
}
