package com.artifact.query.projection;

import java.time.Instant;
import java.util.List;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.Timestamp;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.stereotype.Component;

import com.artifact.query.query.ContatoHistoricoQuery;
import com.artifact.commad.events.AlterarCelularEvent;
import com.artifact.commad.events.IncluirEnderecoEvent;
import com.artifact.pessoarepository.entity.Celular;
import com.artifact.pessoarepository.entity.Contato;
import com.artifact.pessoarepository.repository.CelularRepository;
import com.artifact.pessoarepository.repository.ContatoRepository;
import com.artifact.query.query.CelularQuery;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CelularProjection {
	
	private final CelularRepository celularRepository;
	private final QueryUpdateEmitter updateEmitter;
	

	@QueryHandler
	public Iterable<Celular> handle(CelularQuery query){
		return celularRepository.findAllByCpfOrderByTimestamp(query.getCfp());
	}

}
