package com.coopersystem.desafio.mapper;

import javax.persistence.MappedSuperclass;

import com.coopersystem.desafio.client.response.CotacaoDTO;
import com.coopersystem.desafio.exception.CotacaoResponse;

@MappedSuperclass
public interface CotacaoMapper {

	CotacaoResponse toCotacaoResponse(CotacaoDTO cotacaovalue);
}
