package com.coopersystem.desafio.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.coopersystem.desafio.exception.FormatoDataInvalidoException;

public class CotacaoUtil {

	public static Date convertStringToDate(String dataStr, String formato) {
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		sdf.setLenient(false);
		Date dataFormatada = null;
		try {
			dataFormatada = sdf.parse(dataStr);
		} catch (Exception e) {
			e.printStackTrace();
			throw new FormatoDataInvalidoException(String.format("A data %s é inválida!"
					+ " Formato correto: %s",  dataStr, formato));
		}
		return dataFormatada;
	}
	
}
