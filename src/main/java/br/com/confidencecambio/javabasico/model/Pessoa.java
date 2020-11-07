package br.com.confidencecambio.javabasico.model;

import org.springframework.lang.NonNull;

import br.com.confidencecambio.javabasico.exception.PessoaException;

/**
 * Classe abstrata para representar entidades, humanas ou robóticas, com suas
 * informações.
 *
 */
public abstract class Pessoa {

	/**
	 * Construtor da entidade pessoa onde é inserido suas informações.
	 *
	 * @param nome o nome desta entidade.
	 * @throws PessoaException caso ocorra erro nas inserções das informações.
	 */
	protected Pessoa(String nome) throws PessoaException {
		setNome(nome);
	}

	/**
	 * O nome desta entidade.
	 *
	 */
	@NonNull
	private String nome;

	/**
	 * Obtém o nome desta entidade.
	 *
	 * @return o nome da entidade.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Insere o nome desta entidade.
	 *
	 * @param nome o nome a ser inserido.
	 * @throws PessoaException caso ocorra algum erro de validação nesta inserção.
	 */
	public void setNome(String nome) throws PessoaException {
		// nome não pode ser nulo ou vazio
		if (nome == null || nome.isEmpty()) {
			throw new PessoaException("Nome não pode ser nulo ou vazio.");
		}

		// remove espaços em branco no início e no fim da string passada
		this.nome = nome.trim();
	}

	/**
	 * Obtém o primeiro nome da entidade.
	 *
	 * @return o primeiro nome da entidade.
	 */
	public String primeiroNome() {
		return getNome().split(" ")[0];
	}

	/**
	 * Obtém o último nome da entidade.
	 *
	 * @return o último nome da entidade.
	 */
	public String ultimoNome() {
		// nome da entidade
		var nome = getNome();

		// pega o índice do primeiro espaço da string e
		// retorna uma substring começando com o próximo índice até o fim da string
		return nome.substring(nome.indexOf(" ") + 1);
	}

	/**
	 * Obtém o nome da entidade em maiúsculo
	 *
	 * @return o nome da entidade em maiúsculo.
	 */
	public String nomeMaiusculo() {
		// retorna a string em maísculo
		return getNome().toUpperCase();
	}

	/**
	 * Obtém o nome abreviado da entidade.
	 *
	 * @return o nome abreviado da entidade.
	 */
	public String nomeAbreviado() {
		// nome da entidade dividida por espaços
		var splitNome = getNome().split(" ");

		var nomeAbreviado = "";

		// itera nas partes do nome separadas por espaços para abreviar o nome
		for (var posicaoParteNome = 0; posicaoParteNome < splitNome.length; posicaoParteNome++) {
			if (posicaoParteNome == 1) {
				// abreviar esta parte do nome
				nomeAbreviado += splitNome[posicaoParteNome].charAt(0) + ".";
			} else {
				// não abreviar esta parte do nome
				nomeAbreviado += splitNome[posicaoParteNome];
			}

			// adicionar espaços entre as partes do nome exceto na última parte do nome
			if (posicaoParteNome < splitNome.length - 1) {
				nomeAbreviado += " ";
			}
		}

		return nomeAbreviado;
	}

}
