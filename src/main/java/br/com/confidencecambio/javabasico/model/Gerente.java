package br.com.confidencecambio.javabasico.model;

import br.com.confidencecambio.javabasico.exception.PessoaException;

/**
 * Classe que representa um gerente com as suas informações.
 *
 */
public class Gerente extends Pessoa {

	/**
	 * Construtor do gerente.
	 *
	 * @param nome o nome do gerente.
	 * @throws PessoaException caso ocorram erros de validação nas informações do
	 *                         gerente.
	 */
	public Gerente(String nome) throws PessoaException {
		super(nome);
	}

}
