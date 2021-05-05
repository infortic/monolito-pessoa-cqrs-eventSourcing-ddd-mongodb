package com.artifact.query.projection;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import com.artifact.pessoarepository.entity.Celular;
import com.artifact.pessoarepository.repository.CelularRepository;
import com.artifact.query.query.CelularQuery;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CelularProjection {
	
	private final CelularRepository celularRepository;

	@QueryHandler
	public Iterable<Celular> handle(CelularQuery query){
		return celularRepository.findAllByCpfOrderByTimestamp(query.getCfp());
	}
	
	

}
