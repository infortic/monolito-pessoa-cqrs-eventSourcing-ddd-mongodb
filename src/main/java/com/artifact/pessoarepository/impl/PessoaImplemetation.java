package com.artifact.pessoarepository.impl;

import java.time.Instant;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.Timestamp;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.stereotype.Component;

import com.artifact.commad.events.CriarPessoaEvent;
import com.artifact.commad.events.IncluirEnderecoEvent;
import com.artifact.pessoarepository.entity.Endereco;
import com.artifact.pessoarepository.entity.Pessoa;
import com.artifact.pessoarepository.repository.EnderecoRepository;
import com.artifact.pessoarepository.repository.PessoaRepository;
import com.artifact.query.query.EnderecoQuery;
import com.artifact.query.query.PessoaQuery;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class PessoaImplemetation {
	
	private final PessoaRepository pessoaRepository;
	private final QueryUpdateEmitter updateEmitter;
	
	@EventHandler
	public void on(CriarPessoaEvent evt, @Timestamp Instant timestamp){
		Pessoa pessoa = new Pessoa();
		pessoa.setTimestamp(timestamp.toEpochMilli());
		pessoa.setCpf(evt.getCpf());
		pessoa.setNome(evt.getNome());
		pessoa.setSexo(evt.getSexo());
		
		pessoaRepository.save(pessoa);
		
		updateEmitter.emit(PessoaQuery.class, query -> query.getCpf().equals(evt.getCpf()),  pessoa );
		
	}
}
