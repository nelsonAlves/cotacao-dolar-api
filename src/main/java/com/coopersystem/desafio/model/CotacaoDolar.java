package com.coopersystem.desafio.model;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tb_cotacao_dolar")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class CotacaoDolar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Version
	private Timestamp timestamp;
	private LocalDate dataCotacao;
	private BigDecimal cotacaoCompra;
	private BigDecimal cotacaoVenda;
	private Date dataHoraCotacao;
	private LocalDateTime now;

	public CotacaoDolar(LocalDate dataCotacao, BigDecimal cotacaoCompra, BigDecimal cotacaoVenda,
			Date dataHoraCotacao) {
		this.dataCotacao = dataCotacao;
		this.cotacaoCompra = cotacaoCompra;
		this.cotacaoVenda = cotacaoVenda;
		this.dataHoraCotacao = dataHoraCotacao;
	}

	public CotacaoDolar(LocalDate dataCotacao2, BigDecimal dataCompra, BigDecimal dataVenda, LocalDateTime now) {

		this.dataCotacao = dataCotacao2;
		this.cotacaoCompra = dataCompra;
		this.cotacaoVenda = dataVenda;
		this.now = now;
	}
	
}
