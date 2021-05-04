package com.artifact.query.controller;

import org.axonframework.messaging.responsetypes.InstanceResponseType;
import org.axonframework.messaging.responsetypes.MultipleInstancesResponseType;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.artifact.query.query.EnderecoQuery;
import com.artifact.query.query.PessoaQuery;
import com.artifact.query.query.ContatoHistoricoQuery;
import com.artifact.pessoarepository.entity.Celular;
import com.artifact.pessoarepository.entity.Contato;
import com.artifact.pessoarepository.entity.Endereco;
import com.artifact.pessoarepository.entity.Pessoa;
import com.artifact.query.query.CelularQuery;
import com.artifact.query.query.ContatoAtualQuery;

import lombok.AllArgsConstructor;

@RestController               
@AllArgsConstructor
public class QueryEndPoint {

	private final QueryGateway queryGateway; 
	
	@GetMapping("/pessoa/endereco/{cpf}")
	public ResponseEntity<?> endereco(@PathVariable String cpf){
		return new ResponseEntity<>(queryGateway.query(new EnderecoQuery(cpf), new MultipleInstancesResponseType<Endereco>(Endereco.class)).join(), HttpStatus.OK);
	}
	
	@GetMapping("/pessoa/{cpf}")
	public ResponseEntity<?> pessoa(@PathVariable String cpf){
		return new ResponseEntity<>(queryGateway.query(new PessoaQuery(cpf), new InstanceResponseType<Pessoa>(Pessoa.class)).join(), HttpStatus.OK);
	}
	
	@GetMapping("/pessoa/celular/{cpf}")
	public ResponseEntity<?> celular(@PathVariable String cpf){
		return new ResponseEntity<>(queryGateway.query(new CelularQuery(cpf), new MultipleInstancesResponseType<Celular>(Celular.class)).join(), HttpStatus.OK);
	}

	@GetMapping("/pessoa/contato/historico/{cpf}")
	public ResponseEntity<?> contatoHistorico(@PathVariable String cpf){
		return new ResponseEntity<>(queryGateway.query(new ContatoHistoricoQuery(cpf), new MultipleInstancesResponseType<Contato>(Contato.class)).join(), HttpStatus.OK);
	}

	@GetMapping("/pessoa/contato/atual/{cpf}")
	public ResponseEntity<?> contatoAtual(@PathVariable String cpf){
		return new ResponseEntity<>(queryGateway.query(new ContatoAtualQuery(cpf), new InstanceResponseType<Contato>(Contato.class)).join(), HttpStatus.OK);
	}
}
