package com.artifact.pessoarepository.impl;

import java.time.Instant;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.Timestamp;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.stereotype.Component;

import com.artifact.commad.events.IncluirEnderecoEvent;
import com.artifact.pessoarepository.entity.Endereco;
import com.artifact.pessoarepository.repository.EnderecoRepository;
import com.artifact.query.query.EnderecoQuery;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class EnderecoImplemetation {
	
	private final EnderecoRepository enderecoRepository;
	private final QueryUpdateEmitter updateEmitter;
	
	@EventHandler
	public void on(IncluirEnderecoEvent evt, @Timestamp Instant timestamp){
		Endereco endereco = new Endereco();
		endereco.setTimestamp(timestamp.toEpochMilli());
		endereco.setCpf(evt.getCpf());
		endereco.setRua(evt.getRua());
		endereco.setNumero(evt.getNumero());
		endereco.setBairro(evt.getBairro());
		endereco.setCidade(evt.getCidade());
		endereco.setEstado(evt.getEstado());
		endereco.setPaIs(evt.getPaIs());
		enderecoRepository.save(endereco);
	    updateEmitter.emit(EnderecoQuery.class, query -> query.getCpf().equals(evt.getCpf()),  endereco );
	}
}
