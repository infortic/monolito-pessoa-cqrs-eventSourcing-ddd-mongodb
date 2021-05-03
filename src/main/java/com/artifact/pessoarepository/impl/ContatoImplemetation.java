package com.artifact.pessoarepository.impl;

import java.time.Instant;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.Timestamp;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.stereotype.Component;

import com.artifact.commad.events.AlterarCelularEvent;
import com.artifact.commad.events.IncluirContatoEvent;
import com.artifact.pessoarepository.entity.Celular;
import com.artifact.pessoarepository.entity.Contato;
import com.artifact.pessoarepository.repository.CelularRepository;
import com.artifact.pessoarepository.repository.ContatoRepository;
import com.artifact.query.query.CelularQuery;
import com.artifact.query.query.ContatoHistoricoQuery;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ContatoImplemetation {
	
	private final ContatoRepository contatoRepository;
	private final QueryUpdateEmitter updateEmitter;
	
	@EventHandler
	public void on(IncluirContatoEvent evt, @Timestamp Instant timestamp){
		Contato contato = new Contato();
		contato.setTimestamp(timestamp.toEpochMilli());
		contato.setCpf(evt.getCpf());
		contato.setTelefoneFixo(evt.getTelefoneFixo());
		contato.setEmail(evt.getEmail());
		contatoRepository.save(contato);
		updateEmitter.emit(ContatoHistoricoQuery.class, query -> query.getCpf().equals(evt.getCpf()),  contato );
	}	

}
