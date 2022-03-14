package com.coopersystem.desafio.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.coopersystem.desafio.client.response.ResponseCotacaoDolar;
import com.coopersystem.desafio.model.CotacaoDolar;

public class CotacaoDolarControllerTest {

	private final static String URL_API_REST = "http://localhost:8080/cotacoes/%s";

	private final static String DATA_VALIDA = "03-13-2022";

	private final static String DATA_INVALIDA = "03-32-2022";

	private final static String DATA_FORMATO_INVALID0 = "2022-03-13";

	private RestTemplate restTemplate = new RestTemplate();

	@Test
	public void testeRestApiDataValida() {
		try {
			ResponseCotacaoDolar resposta = consultarCotacoesDolar(DATA_VALIDA);
			System.out.println(resposta.getMensagem());
			for (CotacaoDolar cotacao : resposta.getCotacoes()) {
				System.out.println(cotacao);
			}

			assertNotNull(resposta);
			assertNotNull(resposta.getMensagem());
			assertNotNull(resposta.getCotacoes());
			assertEquals(true, resposta.getCotacoes().size() > 0);
			assertEquals(true, resposta.isSucesso());

		} catch (RestClientException e) {
			e.printStackTrace();
			fail("Falha no teste");
		} catch (URISyntaxException e) {
			e.printStackTrace();
			fail("Falha no teste");
		}
	}

	@Test
	public void testeRestApiDataInvalida() {
		ResponseCotacaoDolar resposta = null;
		try {
			resposta = consultarCotacoesDolar(DATA_INVALIDA);
			System.out.println(resposta.getMensagem());
			assertEquals(false, resposta.isSucesso());
			assertNull(resposta.getCotacoes());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Falha no teste");
		}
	}

	@Test
	public void testeRestApiDataFormatoInvalido() {
		ResponseCotacaoDolar resposta = null;
		try {
			resposta = consultarCotacoesDolar(DATA_FORMATO_INVALID0);
			System.out.println(resposta.getMensagem());
			assertEquals(false, resposta.isSucesso());
			assertNull(resposta.getCotacoes());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Falha no teste");
		}
	}

	private ResponseCotacaoDolar consultarCotacoesDolar(String dataCotacao) throws URISyntaxException {
		String uri = String.format(URL_API_REST, dataCotacao);
		return restTemplate.getForObject(new URI(uri), ResponseCotacaoDolar.class);
	}
}
