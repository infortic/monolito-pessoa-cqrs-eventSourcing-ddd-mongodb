package com.artifact.pessoarepository.entity;


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
public class Contato {
	
	@Id
	private String id = UUID.randomUUID().toString();
	private String cpf;
	private String telefoneFixo;
	private String email;	
	private Date DataCadastro = new Date();
	private Long timestamp;
	
}
