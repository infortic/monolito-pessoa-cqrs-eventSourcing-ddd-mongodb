package com.artifact.pessoarepository.impl;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.Timestamp;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.stereotype.Component;
import java.time.Instant;
import com.artifact.query.query.ContatoHistoricoQuery;
import com.artifact.commad.events.AlterarCelularEvent;
import com.artifact.commad.events.IncluirEnderecoEvent;
import com.artifact.pessoarepository.entity.Celular;
import com.artifact.pessoarepository.entity.Contato;
import com.artifact.pessoarepository.repository.CelularRepository;
import com.artifact.pessoarepository.repository.ContatoRepository;
import com.artifact.query.query.CelularQuery;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CelularImplemetation {
	
	private final CelularRepository celularRepository;
	private final QueryUpdateEmitter updateEmitter;
	
	@EventHandler
	public void on(AlterarCelularEvent evt, @Timestamp Instant timestamp){
		Celular celular = new Celular();
		celular.setTimestamp(timestamp.toEpochMilli());
		celular.setCpf(evt.getCpf());
		celular.setNumeroCelular(evt.getNumeroCelular());
		celularRepository.save(celular);
		updateEmitter.emit(CelularQuery.class,  query -> query.getCfp().equals(evt.getCpf()),  celular );
	}

}
