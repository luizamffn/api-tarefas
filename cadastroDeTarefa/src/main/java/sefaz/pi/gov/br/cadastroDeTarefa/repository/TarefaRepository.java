package sefaz.pi.gov.br.cadastroDeTarefa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sefaz.pi.gov.br.cadastroDeTarefa.modelo.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

	Page<Tarefa> findByTitulo(String titulo, Pageable paginacao);

}
