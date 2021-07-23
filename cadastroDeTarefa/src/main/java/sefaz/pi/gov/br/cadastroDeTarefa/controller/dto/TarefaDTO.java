package sefaz.pi.gov.br.cadastroDeTarefa.controller.dto;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.springframework.data.domain.Page;

import sefaz.pi.gov.br.cadastroDeTarefa.controller.form.TarefaForm;
import sefaz.pi.gov.br.cadastroDeTarefa.modelo.StatusTarefa;
import sefaz.pi.gov.br.cadastroDeTarefa.modelo.Tarefa;

public class TarefaDTO {
	
	private Long id;
	private String titulo;
	private String descricao;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataConclusao;
	private StatusTarefa statusTarefa;

	
	public TarefaDTO(Tarefa tarefa) {
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

	public static Page<TarefaDTO> converter(Page<Tarefa> tarefas) {
		// TODO Auto-generated method stub
		return tarefas.map(TarefaDTO::new);        
	}

}
