package br.com.confidencecambio.javabasico.model;

import br.com.confidencecambio.javabasico.exception.PessoaException;

/**
 * Classe que representa um robô com as suas informações.
 *
 */
public class Robo extends Pessoa {

	/**
	 * Construtor do robô.
	 *
	 * @param nome o nome do robô.
	 * @throws PessoaException caso ocorram erros de validação nas informações do
	 *                         robô.
	 */
	public Robo(String nome) throws PessoaException {
		super(nome);
	}

}
