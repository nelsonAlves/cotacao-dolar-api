package com.coopersystem.desafio.exception;

import javax.annotation.Resource;

import com.coopersystem.desafio.mapper.CotacaoMapper;
import com.coopersystem.desafio.service.CotacaoDiaService;

import lombok.Getter;
import lombok.Setter;

@Resource
@Getter
@Setter
public class CotacaoDiaResource {

	private final CotacaoDiaService cotacaoDiaService;
	private final CotacaoMapper cotacaoMapper;

	public CotacaoDiaResource(CotacaoDiaService cotacaoDiaService, CotacaoMapper cotacaoMapper) {
		this.cotacaoDiaService = cotacaoDiaService;
		this.cotacaoMapper = cotacaoMapper;

	}

}
