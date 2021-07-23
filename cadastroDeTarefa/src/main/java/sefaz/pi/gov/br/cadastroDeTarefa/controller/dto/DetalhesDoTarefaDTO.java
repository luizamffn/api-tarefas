package sefaz.pi.gov.br.cadastroDeTarefa.controller.dto;

import java.time.LocalDateTime;

import sefaz.pi.gov.br.cadastroDeTarefa.modelo.StatusTarefa;
import sefaz.pi.gov.br.cadastroDeTarefa.modelo.Tarefa;

public class DetalhesDoTarefaDTO {
	
	private Long id;
	private String titulo;
	private String descricao;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataConclusao;
	private StatusTarefa statusTarefa;
	
	public DetalhesDoTarefaDTO(Tarefa tarefa) {
		this.id = tarefa.getId();
		this.titulo = tarefa.getTitulo();
		this.descricao = tarefa.getDescricao();
		this.dataCriacao = tarefa.getDataCriacao();
		this.dataConclusao = tarefa.getDataConclusao();
		this.statusTarefa = tarefa.getStatusTarefa();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public LocalDateTime getDataConclusao() {
		return dataConclusao;
	}

	public StatusTarefa getStatusTarefa() {
		return statusTarefa;
	}
	
}
