package com.coopersystem.desafio.service;


import java.util.Set;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coopersystem.desafio.client.response.CotacaoDTO;
import com.coopersystem.desafio.client.response.CotacaoDiaResponse;
import com.coopersystem.desafio.client.response.ResponseTipoCotacaoDolar;
import com.coopersystem.desafio.model.CotacaoDolar;
import com.coopersystem.desafio.repository.CotacaoDolarRepository;

@Service
public class CotacaoDiaService {

	 private static final org.slf4j.Logger log = LoggerFactory.getLogger(CotacaoDiaService.class);

	 @Autowired(required=true)
	 private CotacaoDolarRepository cotacaoDolarRepository;
	 
		public CotacaoDolar salvar(CotacaoDolar cotacaoDolar) {
			return this.cotacaoDolarRepository.save(cotacaoDolar);
		}
		

	  public CotacaoDiaService(CotacaoDolarRepository cotacaoDolarRepository) {
	    
	    this.cotacaoDolarRepository = cotacaoDolarRepository;
	  }

	  CotacaoDTO toCotacaoValue(CotacaoDiaResponse cotacaodiaresponse) {
	    Set<CotacaoDTO> cotacoes = cotacaodiaresponse.getValue();

	    if (!cotacoes.isEmpty()) {
	      return cotacoes.iterator().next();
	    }

	    return null;
	  }

	public ResponseTipoCotacaoDolar consultarCotacoesDolar(String dataCotacaoStr) {
		
		return null;
	}

	}
