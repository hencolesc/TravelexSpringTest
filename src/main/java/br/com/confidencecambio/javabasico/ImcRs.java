package br.com.confidencecambio.javabasico;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.confidencecambio.javabasico.service.ImcService;

/**
 * Camada de controle para o serviço que calcula o IMC.
 *
 *
 */
@RestController
public class ImcRs {

	// instância da camada de serviço deste controlador
	private ImcService service;

	/**
	 * Construtor do controlador injetando instância da camada de serviço da mesma.
	 *
	 * @param service a instância da camada de serviço a ser injetada.
	 */
	public ImcRs(final ImcService service) {

		this.service = service;
	}

	/**
	 * Método GET no caminho '/meu-imc' para calcular o IMC (índice de massa
	 * corporal) conforme parâmetros passados.
	 *
	 * @param strPeso   o peso em kilogramas.
	 * @param strAltura a altura em metros.
	 * @return Objeto de resposta com o resultado do IMC calculado.
	 */
	@RequestMapping(value = "/meu-imc", method = RequestMethod.GET)
	public ResponseEntity<String> meuImc(@RequestParam(value = "peso", defaultValue = "0.0") String strPeso,
			@RequestParam(value = "altura", defaultValue = "0.0") String strAltura) {
		var peso = 0D;
		var altura = 0D;

		try {
			// conversão de string para double
			// aceita números separados por vírgula ou por ponto
			peso = Double.valueOf(strPeso.replaceFirst(",", "."));
			altura = Double.valueOf(strAltura.replaceFirst(",", "."));
		} catch (NumberFormatException e) {
			// Tratamento do erro com mensagem informativa.
			return new ResponseEntity<>(
					"Erro de conversão ao ler os parâmetros. Os valores esperados podem ser, por exemplo, peso = 69,7 e altura = 1,63. Verifique os dados passados peso = "
							+ strPeso + " e altura = " + strAltura,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		// validar peso
		if (peso == 0D) {
			return new ResponseEntity<>("O peso, em kilogramas, deve ser algum valor acima de 0. Por exemplo 69,7.",
					HttpStatus.BAD_REQUEST);
		}

		// validar altura
		if (altura == 0D) {
			return new ResponseEntity<>("A altura, em metros, deve ser algum valor acima de 0. Por exemplo 1,63.",
					HttpStatus.BAD_REQUEST);
		}

		// cálculo do IMC na camada de serviço
		var imc = service.calcularImc(peso, altura);

		return new ResponseEntity<>(imc.toString(), HttpStatus.OK);
	}
}
