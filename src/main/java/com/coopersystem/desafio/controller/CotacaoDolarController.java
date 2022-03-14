package com.coopersystem.desafio.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.coopersystem.desafio.client.response.ResponseCotacaoDolar;
import com.coopersystem.desafio.client.response.ResponseTipoCotacaoDolar;
import com.coopersystem.desafio.client.response.TipoCotacaoDolar;
import com.coopersystem.desafio.exception.DataInvalidaException;
import com.coopersystem.desafio.model.CotacaoDolar;
import com.coopersystem.desafio.service.CotacaoDiaService;
import com.coopersystem.desafio.util.CotacaoUtil;

@RestController
public class CotacaoDolarController {

	@Autowired(required = false)
	private CotacaoDiaService cotacaoDiaService;

	RestTemplate restTemplate = new RestTemplate();

	@RequestMapping(path = "/cotacoes/{dataCotacao}", method = RequestMethod.GET)
	public ResponseEntity<ResponseCotacaoDolar> consultarCotacoesDolar(
			@PathVariable("dataCotacao") String dataCotacaoStr) {
		ResponseCotacaoDolar retorno = new ResponseCotacaoDolar();
		List<CotacaoDolar> cotacoes = new ArrayList<CotacaoDolar>(0);
		try {
			if (dataCotacaoStr == null || dataCotacaoStr.isEmpty()) {
				throw new DataInvalidaException(" Favor informar a data da cotação!");
			}
			Date dataCotacao = CotacaoUtil.convertStringToDate(dataCotacaoStr, "MM-dd-yyyy");
			ResponseTipoCotacaoDolar resposta = cotacaoDiaService.consultarCotacoesDolar(dataCotacaoStr);
			List<TipoCotacaoDolar> values = resposta.getValue();
			CotacaoDolar cotacaoDolar = null;
			for (TipoCotacaoDolar tipoCotacaoDolar : values) {
				cotacaoDolar = cotacaoDiaService.salvar(tipoCotacaoDolar.toCotacaoDolar(dataCotacao));
				cotacoes.add(cotacaoDolar);
			}

			retorno.setSucesso(true);
			retorno.setCotacoes(cotacoes);
			retorno.setMensagem(String
					.format("A Consulta realizada para cotações do dólar na data %s foi registrado com sucesso.", dataCotacao));

		} catch (Exception e) {
			e.printStackTrace();
			retorno.setSucesso(false);
			retorno.setMensagem(e.getMessage());
		}

		return new ResponseEntity<ResponseCotacaoDolar>(retorno, HttpStatus.OK);
	}

}
