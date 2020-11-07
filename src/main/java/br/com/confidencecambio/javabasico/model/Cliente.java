package br.com.confidencecambio.javabasico.model;

import br.com.confidencecambio.javabasico.exception.PessoaException;

/**
 * Classe que representa um cliente com as suas informações.
 *
 */
public class Cliente extends Pessoa {

	/**
	 * Construtor do cliente.
	 *
	 * @param nome o nome do cliente.
	 * @throws PessoaException caso ocorram erros de validação nas informações do
	 *                         cliente.
	 */
	public Cliente(String nome) throws PessoaException {
		super(nome);
	}

}
