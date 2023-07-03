package br.com.tech4me.tech4jogadores.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.tech4jogadores.model.Jogadores;

public interface JogadoresRepository extends MongoRepository<Jogadores, String> {
    
}
