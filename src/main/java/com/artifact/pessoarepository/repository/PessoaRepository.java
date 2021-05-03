package com.artifact.pessoarepository.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.artifact.pessoarepository.entity.Pessoa;


public interface PessoaRepository extends PagingAndSortingRepository<Pessoa, String> {
	
	Pessoa findByCpf(String cpf);
	
}
