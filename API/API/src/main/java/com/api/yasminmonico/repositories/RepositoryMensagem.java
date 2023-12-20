package com.api.yasminmonico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.yasminmonico.models.Mensagem;

@Repository
public interface RepositoryMensagem extends JpaRepository<Mensagem, Integer> {


	
}
