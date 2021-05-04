package com.artifact.pessoarepository.eventprocessing.query;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import com.artifact.query.query.EnderecoQuery;
import com.artifact.pessoarepository.entity.Endereco;
import com.artifact.pessoarepository.repository.EnderecoRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class EnderecoProjection {
	
	private final EnderecoRepository enderecoRepository;	

	@QueryHandler
	public Iterable<Endereco> handle(EnderecoQuery query){
		return enderecoRepository.findByCpfOrderByTimestamp(query.getCpf());
	}
	
	
	
}
