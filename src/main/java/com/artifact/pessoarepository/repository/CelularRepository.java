package com.artifact.pessoarepository.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.artifact.pessoarepository.entity.Celular;
import com.artifact.pessoarepository.entity.Endereco;


public interface CelularRepository extends PagingAndSortingRepository<Celular, String> {
List<Celular> findAllByCpfOrderByTimestamp(String cpf);


	
}
