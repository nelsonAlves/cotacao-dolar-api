package com.coopersystem.desafio.client.request;

public class CotacaoDiaRequest {

	  private String dataCotacao;

	  public CotacaoDiaRequest(String dataCotacao) {
	    this.dataCotacao = "\'" + dataCotacao + "\'";
	  }

	  public String getDataCotacao() {
	    return dataCotacao;
	  }
}
