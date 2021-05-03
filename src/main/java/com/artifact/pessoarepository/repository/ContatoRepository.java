package com.artifact.pessoarepository.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.artifact.pessoarepository.entity.Contato;
import com.artifact.pessoarepository.entity.Endereco;

public interface ContatoRepository extends PagingAndSortingRepository<Contato, String> {
	
List<Contato> findAllByCpfOrderByTimestamp(String cpf);
	
}
