package sefaz.pi.gov.br.cadastroDeTarefa.controller.form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import sefaz.pi.gov.br.cadastroDeTarefa.modelo.StatusTarefa;
import sefaz.pi.gov.br.cadastroDeTarefa.modelo.Tarefa;
import sefaz.pi.gov.br.cadastroDeTarefa.repository.TarefaRepository;

public class AtualizacaoTarefaForm {
	@NotNull @NotEmpty @Length(min = 5)
	private String titulo;
	
	@NotNull @NotEmpty @Length(min = 10)
	private String descricao;
	
	private StatusTarefa statusTarefa;

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

	public StatusTarefa getStatusTarefa() {
		return statusTarefa;
	}

	public void setStatusTarefa(StatusTarefa statusTarefa) {
		this.statusTarefa = statusTarefa;
	}

	public Tarefa atualizar(Long id, TarefaRepository tarefaRepository) {
		Tarefa tarefa = tarefaRepository.getOne(id);
		
		tarefa.setTitulo(this.titulo);
		tarefa.setDescricao(this.descricao);
		tarefa.setStatusTarefa(this.statusTarefa);
		
		if(this.statusTarefa.equals(StatusTarefa.CONCLUIDA)) {
			tarefa.setDataConclusao(LocalDateTime.now());
		}
		
		return tarefa;
	}

}
