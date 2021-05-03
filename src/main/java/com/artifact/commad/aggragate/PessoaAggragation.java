package com.artifact.commad.aggragate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import com.artifact.commad.commads.AlterarCelularCommad;
import com.artifact.commad.commads.CriarPessoaCommad;
import com.artifact.commad.commads.IncluirContatoCommad;
import com.artifact.commad.commads.IncluirEnderecoCommad;
import com.artifact.commad.events.AlterarCelularEvent;
import com.artifact.commad.events.CriarPessoaEvent;
import com.artifact.commad.events.IncluirContatoEvent;
import com.artifact.commad.events.IncluirEnderecoEvent;

import lombok.AllArgsConstructor;


@Aggregate
@AllArgsConstructor
public class PessoaAggragation {

	@AggregateIdentifier
	private String cpf;
	private String numeroCelular;
	private String bairro;
	private String cidade;
	private String estado;
	private Integer numero;
	private String paIs;
	private String rua;
	private String nome;
	private String sexo;
	private String email;
	private String telefoneFixo;
		
	public PessoaAggragation() {}

	@CommandHandler
	public PessoaAggragation(CriarPessoaCommad cmd) {
		AggregateLifecycle.apply(new CriarPessoaEvent(cmd.getCpf(), cmd.getNome(), cmd.getSexo()));
	}
	
	@CommandHandler
	public void handle(IncluirEnderecoCommad cmd) {
		AggregateLifecycle.apply(new IncluirEnderecoEvent(cmd.getCpf(), cmd.getRua(), cmd.getNumero(), cmd.getBairro(), cmd.getCidade(), cmd.getEstado(), cmd.getPaIs()));
	}
	
	@CommandHandler
	public void handle(AlterarCelularCommad cmd) {
	//	if(cmd.getCpf().isBlank()) throw new IllegalArgumentException("é preciso informar uma pessoa");
		AggregateLifecycle.apply(new AlterarCelularEvent(cmd.getCpf(), cmd.getNumeroCelular()));
	}
	
	@CommandHandler
	public void handle(IncluirContatoCommad cmd) {
		if(cmd.getCpf().isBlank()) throw new IllegalArgumentException("é preciso informar uma pessoa");
		AggregateLifecycle.apply(new IncluirContatoEvent(cmd.getCpf(), cmd.getTelefoneFixo(), cmd.getEmail()));
	}
	
	@EventSourcingHandler
	protected void on(AlterarCelularEvent evt) {
		this.cpf = evt.getCpf();
		this.numeroCelular = evt.getNumeroCelular();	
	}
	
	@EventSourcingHandler
	protected void on(IncluirEnderecoEvent evt) {
		this.cpf = evt.getCpf();
		this.bairro = evt.getBairro();
		this.cidade = evt.getCidade();
		this.estado = evt.getEstado();
		this.numero = evt.getNumero();
		this.paIs = evt.getPaIs();
		this.rua = evt.getRua();	
	}
	
	@EventSourcingHandler
	protected void on(CriarPessoaEvent evt) {
		this.cpf = evt.getCpf();
		this.nome = evt.getNome();
		this.sexo = evt.getSexo();
	}
	
	@EventSourcingHandler
	protected void on(IncluirContatoEvent evt) {
		this.cpf = evt.getCpf();
		this.email = evt.getEmail();
		this.telefoneFixo = evt.getTelefoneFixo();
	}

}
