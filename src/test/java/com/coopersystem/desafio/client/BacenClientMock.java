package com.coopersystem.desafio.client;

import java.math.BigDecimal;

import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;

import com.coopersystem.desafio.client.response.CotacaoDTO;

@MockBeans(value = { @MockBean })
@RestClientTest
public class BacenClientMock {

	 public static final CotacaoDTO COTACAO_VALUE_DTO = new CotacaoDTO(
		      new BigDecimal("5.04730"), new BigDecimal("5.04790"), "2022-03-13 13:04:52.092");
}
