package com.coopersystem.desafio.client.response;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import com.coopersystem.desafio.model.CotacaoDolar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoCotacaoDolar implements Serializable {

	private static final long serialVersionUID = 6616230116009546880L;

	private Double cotacaoCompra;
	private Double cotacaoVenda;
	private String dataHoraCotacao;
	
	public CotacaoDolar toCotacaoDolar(Date dataCotacao) throws ParseException {
		
		CotacaoDolar cotacaoDolar = new CotacaoDolar();
		
		return cotacaoDolar;
	}

}
