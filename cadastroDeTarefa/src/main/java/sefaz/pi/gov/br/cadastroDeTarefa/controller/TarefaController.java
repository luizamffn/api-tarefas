package sefaz.pi.gov.br.cadastroDeTarefa.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import sefaz.pi.gov.br.cadastroDeTarefa.controller.dto.DetalhesDoTarefaDTO;
import sefaz.pi.gov.br.cadastroDeTarefa.controller.dto.TarefaDTO;
import sefaz.pi.gov.br.cadastroDeTarefa.controller.form.AtualizacaoTarefaForm;
import sefaz.pi.gov.br.cadastroDeTarefa.controller.form.TarefaForm;
import sefaz.pi.gov.br.cadastroDeTarefa.modelo.Tarefa;
import sefaz.pi.gov.br.cadastroDeTarefa.repository.TarefaRepository;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
	
	@Autowired
	private TarefaRepository tarefaRepository;
	
	@GetMapping
//	@Cacheable(value = "listaDeTopicos")
	public Page<TarefaDTO> lista(@RequestParam(required = false) String titulo, 
			@PageableDefault(sort="id", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao){
		
		if(titulo == null) {
			Page<Tarefa> tarefas = tarefaRepository.findAll(paginacao);
			return TarefaDTO.converter(tarefas);
		}else {
			Page<Tarefa> tarefas = tarefaRepository.findByTitulo(titulo, paginacao);
			return TarefaDTO.converter(tarefas);
		}
	}
	
	@PostMapping
	@Transactional
//	@CacheEvict(value = "listaDeTopicos", allEntries = true) //limpar o cache
	public ResponseEntity<TarefaDTO> cadastrar(@RequestBody @Valid TarefaForm form, UriComponentsBuilder uriBuilder) {
		Tarefa tarefa = form.converter();

		tarefaRepository.save(tarefa);
		
		URI uri = uriBuilder.path("/tarefa/{id}").buildAndExpand(tarefa.getId()).toUri();
		return ResponseEntity.created(uri).body(new TarefaDTO(tarefa));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDoTarefaDTO> detalhar(@PathVariable Long id) {
		Optional<Tarefa> tarefa = tarefaRepository.findById(id);
		if (tarefa.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoTarefaDTO(tarefa.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
//	@CacheEvict(value = "listaDeTopicos", allEntries = true) //limpar o cache
	public ResponseEntity<TarefaDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTarefaForm form) {
		Optional<Tarefa> optional = tarefaRepository.findById(id);
		if (optional.isPresent()) {
			Tarefa tarefa = form.atualizar(id, tarefaRepository);
			return ResponseEntity.ok(new TarefaDTO(tarefa));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
//	@CacheEvict(value = "listaDeTopicos", allEntries = true) //limpar o cache
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Tarefa> optional = tarefaRepository.findById(id);
		if (optional.isPresent()) {
			tarefaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
