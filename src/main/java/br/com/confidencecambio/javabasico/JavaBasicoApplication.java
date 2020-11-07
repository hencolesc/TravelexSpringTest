package br.com.confidencecambio.javabasico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.confidencecambio.javabasico.exception.PessoaException;
import br.com.confidencecambio.javabasico.model.Cliente;
import br.com.confidencecambio.javabasico.model.Gerente;
import br.com.confidencecambio.javabasico.model.Robo;

/**
 * Classe que manterá um método main a ser executado no deploy desta aplicação
 * Spring.
 *
 */
@SpringBootApplication
public class JavaBasicoApplication {

	/**
	 * Método main a ser executado no deploy desta aplicação Spring.
	 *
	 * @param args argumentos passados ao executar este main.
	 * @throws PessoaException caso ocorra erros de validação nas entidades.
	 */
	public static void main(String[] args) throws PessoaException {
		SpringApplication.run(JavaBasicoApplication.class, args);

		// instâncias das entidades pedidas
		var cliente = new Cliente("Henrique Colodetti Escanferla Farrell");
		var gerente = new Gerente("Henrique Colodetti Escanferla Farrell");
		var robo = new Robo("Henrique Colodetti Escanferla Farrell");

		// abaixo está a exibição das funcionalidades pedidas
		System.out.println("Primeiro nome do cliente: " + cliente.primeiroNome());
		System.out.println("Último nome do gerente: " + gerente.ultimoNome());
		System.out.println("Nome em maíusculo do robo: " + robo.nomeMaiusculo());
		System.out.println("Nome abreviado do cliente: " + cliente.nomeAbreviado());

		// simulação de erro de validação na inserção do nome
		cliente = new Cliente("");

		// estas linhas não serão executadas por causa do erro na linha acima
		System.out.println("Primeiro nome do cliente: " + cliente.primeiroNome());
		System.out.println("Último nome do cliente: " + cliente.ultimoNome());
		System.out.println("Nome em maíusculo do cliente: " + cliente.nomeMaiusculo());
		System.out.println("Nome abreviado do cliente: " + cliente.nomeAbreviado());
	}

}
