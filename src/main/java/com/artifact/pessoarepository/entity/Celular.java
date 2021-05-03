package com.artifact.pessoarepository.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Celular implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private String id = UUID.randomUUID().toString();
	
	private String cpf;
	private String numeroCelular;	
	private Long timestamp;
	
	private Date DataCadastro = new Date();
	
	
}
