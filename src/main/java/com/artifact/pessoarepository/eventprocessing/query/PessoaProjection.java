package com.artifact.pessoarepository.eventprocessing.query;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import com.artifact.query.query.PessoaQuery;
import com.artifact.pessoarepository.entity.Pessoa;
import com.artifact.pessoarepository.repository.PessoaRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PessoaProjection {

	private final PessoaRepository pessoaRepository;	
	
	@QueryHandler
	public Pessoa handle(PessoaQuery query){
		return pessoaRepository.findByCpf(query.getCpf());		
	}
		
}
