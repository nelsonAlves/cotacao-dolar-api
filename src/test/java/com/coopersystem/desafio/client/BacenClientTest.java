package com.coopersystem.desafio.client;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;

import com.coopersystem.desafio.client.request.CotacaoDiaRequest;
import com.coopersystem.desafio.client.response.CotacaoDiaResponse;

@RestClientTest
public class BacenClientTest {

	@Test
	  void testGetCotacaoDolarDia() {
	    CotacaoDiaRequest request = new CotacaoDiaRequest("13-03-2022");

	    CotacaoDiaResponse expected = new CotacaoDiaResponse(Set.of());
	  }

	  @Test
	  void testGetCotacaoDolarDiaNaoUtil() {
	    CotacaoDiaRequest request = new CotacaoDiaRequest("03-17-2022");

	    CotacaoDiaResponse expected = new CotacaoDiaResponse();
	  }

	  @Test
	  void testGetCotacaoDolarDiaFuturo() {
	    CotacaoDiaRequest request = new CotacaoDiaRequest(
	        LocalDate.now().plusDays(5).format(DateTimeFormatter.ofPattern("MM-dd-yyyy")));

	    CotacaoDiaResponse expected = new CotacaoDiaResponse();

	  }
	}

