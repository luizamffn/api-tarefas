package sefaz.pi.gov.br.cadastroDeTarefa.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tarefa {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String descricao;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataConclusao;
	
	@Enumerated(EnumType.STRING)
	private StatusTarefa statusTarefa;
	
	public Tarefa() {

	}
	
	public Tarefa(String titulo, String descricao) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataCriacao = LocalDateTime.now();
		this.dataConclusao = null;
		this.statusTarefa = StatusTarefa.ABERTA;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public LocalDateTime getDataConclusao() {
		return dataConclusao;
	}
	public void setDataConclusao(LocalDateTime dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public StatusTarefa getStatusTarefa() {
		return statusTarefa;
	}

	public void setStatusTarefa(StatusTarefa statusTarefa) {
		this.statusTarefa = statusTarefa;
	}
	
}
