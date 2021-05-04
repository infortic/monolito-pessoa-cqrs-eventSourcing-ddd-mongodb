package com.artifact.pessoarepository.eventprocessing.query;

import java.util.Date;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import com.artifact.query.query.ContatoHistoricoQuery;
import com.artifact.pessoarepository.entity.Contato;
import com.artifact.pessoarepository.repository.ContatoRepository;
import com.artifact.query.query.ContatoAtualQuery;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ContatoProjection {

	
	private final ContatoRepository contatoRepository;	

	@QueryHandler
	public Iterable<Contato> handle(ContatoHistoricoQuery query){
		return contatoRepository.findAllByCpfOrderByTimestamp(query.getCpf());
	}
	
	
	@QueryHandler
	public Contato handle(ContatoAtualQuery query){
		Iterable<Contato> contatoList = contatoRepository.findAllByCpfOrderByTimestamp(query.getCpf());		
		Date date = new Date(0);
		Contato contatoAtual = new Contato();
		for(Contato contato : contatoList) {
			if(contato.getDataCadastro().after(date)) {
				contatoAtual.setCpf(contato.getCpf());
				contatoAtual.setEmail(contato.getEmail());
				contatoAtual.setTelefoneFixo(contato.getTelefoneFixo());
			}
		};
		return contatoAtual;
	}
	
}
