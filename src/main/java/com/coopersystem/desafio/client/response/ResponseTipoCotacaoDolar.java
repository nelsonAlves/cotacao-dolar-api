package com.coopersystem.desafio.client.response;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTipoCotacaoDolar implements Serializable {

	private static final long serialVersionUID = 7172262754347981908L;
	
	private String context;
	private List<TipoCotacaoDolar> value;
	
}
