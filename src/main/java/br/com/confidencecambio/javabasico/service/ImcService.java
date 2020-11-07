package br.com.confidencecambio.javabasico.service;

import org.springframework.stereotype.Component;

/**
 * Camada de serviço para cálculo do IMC.
 *
 *
 */
@Component
public class ImcService {

	/**
	 * Calcula o IMC (indice de massa corporal) conforme parâmetros passados.
	 *
	 * @param peso   o peso em kilogramas.
	 * @param altura a altura em metros.
	 * @return o índice de massa corporal calculado.
	 */
	public Double calcularImc(Double peso, Double altura) {
		// fórmula do índice de massa corporal => imc = peso/altura²
		var imc = peso / Math.pow(altura, 2);

		return imc;
	}
}
