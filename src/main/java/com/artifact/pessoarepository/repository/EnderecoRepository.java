package com.artifact.pessoarepository.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.artifact.pessoarepository.entity.Endereco;

public interface EnderecoRepository extends PagingAndSortingRepository<Endereco, String> {
	
List<Endereco> findByCpfOrderByTimestamp(String salaId);
	
}
