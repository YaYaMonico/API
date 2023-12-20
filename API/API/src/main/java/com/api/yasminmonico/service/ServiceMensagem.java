package com.api.yasminmonico.service;

import java.awt.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.yasminmonico.models.Mensagem;
import com.api.yasminmonico.repositories.RepositoryMensagem;

@Service
public class ServiceMensagem {

		@Autowired
		private RepositoryMensagem repositoryMensagem;
		
		public void salvarMensagem(Mensagem mensagem) {
			repositoryMensagem.save(mensagem);
		}
		
	    public java.util.List<Mensagem> listAll() {
	    	return repositoryMensagem.findAll();
			
		}
	    
	    public Optional<Mensagem> getMesagem(int id){
	    	return repositoryMensagem.findById(id);
	    }
	    
	    public void excluirMensagem(Mensagem mensagem)
	    {
	    	repositoryMensagem.delete(mensagem);
	    }
}
