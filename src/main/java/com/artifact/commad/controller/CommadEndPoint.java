package com.artifact.commad.controller;

import javax.validation.Valid;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.artifact.dto.CriarPessoaDTO;
import com.artifact.commad.commads.AlterarCelularCommad;
import com.artifact.commad.commads.CriarPessoaCommad;
import com.artifact.commad.commads.IncluirContatoCommad;
import com.artifact.commad.commads.IncluirEnderecoCommad;
import com.artifact.dto.AlterarCelularDTO;
import com.artifact.dto.IncluirContatoDTO;
import com.artifact.dto.IncluirEnderecoDTO;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CommadEndPoint {

	private final CommandGateway commandGateway;

	
	@PostMapping("/criar-pessoa-commad")
	public ResponseEntity<?> criarPessoaCommad(@RequestBody @Valid CriarPessoaDTO payLoad){
		//Assert.notNull(payLoad.getCpf(),"CFP inválido");
		commandGateway.sendAndWait(new CriarPessoaCommad(payLoad.getCpf(), payLoad.getNome(), payLoad.getSexo()));
		return new ResponseEntity<>("Sala: "+payLoad.getNome()+"Chave sua chave forte é o cpf: "+ payLoad.getCpf(), HttpStatus.OK);
	}
	
	@PostMapping("/alterar-celular-commad")
	public ResponseEntity<?> alterarCelularCommad(@RequestBody @Valid AlterarCelularDTO payLoad){
	//	Assert.notNull(payLoad.getCpf(),"CFP inválido");
		return new ResponseEntity<>(commandGateway.send(new AlterarCelularCommad(payLoad.getCpf(), payLoad.getNumeroCelular())), HttpStatus.OK);		
	}
	
	@PostMapping("/incluir-endereco-commad")
	public ResponseEntity<?> incluirEnderecoCommad(@RequestBody @Valid IncluirEnderecoDTO payLoad){
//		Assert.notNull(payLoad.getCpf(),"CFP inválido");
		return new ResponseEntity<>(commandGateway.send(new IncluirEnderecoCommad(payLoad.getCpf(), payLoad.getRua(),payLoad.getNumero(), payLoad.getBairro(), payLoad.getCidade(),payLoad.getEstado(), payLoad.getPaIs())),HttpStatus.OK);		
	}
	
	@PostMapping("/incluir-contato-commad")
	public ResponseEntity<?> postarMensagem(@RequestBody @Valid IncluirContatoDTO payLoad){
		Assert.notNull(payLoad.getCpf(),"cpf invalido");
		return new ResponseEntity<>(commandGateway.send(new IncluirContatoCommad(payLoad.getCpf(), payLoad.getTelefoneFixo(), payLoad.getEmail())) ,HttpStatus.OK);		
	}
}
