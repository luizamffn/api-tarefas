package sefaz.pi.gov.br.cadastroDeTarefa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport //para permitir a paginacao com o Pageable
public class CadastroDeTarefaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroDeTarefaApplication.class, args);
	}

}
