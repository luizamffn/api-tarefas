package sefaz.pi.gov.br.cadastroDeTarefa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSpringDataWebSupport //para permitir a paginacao com o Pageable
@EnableSwagger2 // para habilitar o swwager
public class CadastroDeTarefaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroDeTarefaApplication.class, args);
	}

}
