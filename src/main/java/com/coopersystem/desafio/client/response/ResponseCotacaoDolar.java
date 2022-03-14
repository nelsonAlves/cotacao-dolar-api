package com.coopersystem.desafio.client.response;

import java.util.List;

import com.coopersystem.desafio.model.CotacaoDolar;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseCotacaoDolar {

private boolean sucesso;
	
	private String mensagem;
	
	private List<CotacaoDolar> cotacoes;

	
	public ResponseCotacaoDolar(String message) {
		mensagem = message;
	}

}
