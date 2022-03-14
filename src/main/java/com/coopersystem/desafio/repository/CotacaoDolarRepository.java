package com.coopersystem.desafio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coopersystem.desafio.model.CotacaoDolar;

@Repository
public interface CotacaoDolarRepository extends CrudRepository<CotacaoDolar, Long> {

}
