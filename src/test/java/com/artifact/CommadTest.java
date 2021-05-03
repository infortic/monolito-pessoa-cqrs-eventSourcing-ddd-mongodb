package com.artifact;

import java.util.UUID;

import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.artifact.commad.aggragate.PessoaAggragation;
import com.artifact.commad.commads.AlterarCelularCommad;
import com.artifact.commad.commads.CriarPessoaCommad;
import com.artifact.commad.commads.IncluirContatoCommad;
import com.artifact.commad.commads.IncluirEnderecoCommad;
import com.artifact.commad.events.AlterarCelularEvent;
import com.artifact.commad.events.CriarPessoaEvent;
import com.artifact.commad.events.IncluirContatoEvent;
import com.artifact.commad.events.IncluirEnderecoEvent;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class CommadTest {

	
	private FixtureConfiguration<PessoaAggragation> fixture;


	@Test
	public void alterarCelularCommadTest() {
		
		fixture = new AggregateTestFixture<>(PessoaAggragation.class);
		String cpf = UUID.randomUUID().toString();
		String numeroCelular = "(48 9.9848-7091)";
		
		fixture.given(new AlterarCelularEvent(cpf, numeroCelular))
				.when(new AlterarCelularCommad(cpf, numeroCelular))
				.expectEvents(new AlterarCelularEvent(cpf, numeroCelular));
	}
	
	@Test
	public void criarPessoaCommadTest() {
		
		fixture = new AggregateTestFixture<>(PessoaAggragation.class);
		String cpf = UUID.randomUUID().toString();
		String nome = "José da Silva";
		String sexo = "MaXó";
		
		fixture.given(new CriarPessoaEvent(cpf, nome, sexo))
				.when(new CriarPessoaCommad(cpf, nome, sexo))
				.expectEvents(new CriarPessoaEvent(cpf, nome, sexo));	
	}
	
	@Test
	public void incluirContatoCommadTest() {
		
		fixture = new AggregateTestFixture<>(PessoaAggragation.class);
		String cpf = UUID.randomUUID().toString();
		String telefoneFixo = "(48 3333-3333)";
		String email = "josedasilva@gmail.com";
		
		fixture.given(new IncluirContatoEvent(cpf, telefoneFixo, email))
				.when(new IncluirContatoCommad(cpf, telefoneFixo, email))
				.expectEvents(new IncluirContatoEvent(cpf, telefoneFixo, email));
	}
	
	
	@Test
	public void incluirEnderecoCommadTest() {
		
		fixture = new AggregateTestFixture<>(PessoaAggragation.class);
		String cpf = UUID.randomUUID().toString();
		String rua = "Rua Birosca do Maneco";
		Integer numero = 171;
		String bairro = "Favela da Rocinha";
		String cidade = "Lugar Nenhum City";
		String estado = "AC";
		String paIs = "Brazil";
		
		fixture.given(new IncluirEnderecoEvent(cpf, rua, numero, bairro, cidade, estado, paIs))
				.when(new IncluirEnderecoCommad(cpf, rua, numero, bairro, cidade, estado, paIs))
				.expectEvents(new IncluirEnderecoEvent(cpf, rua, numero, bairro, cidade, estado, paIs));
		
	}

}
