package com.api.yasminmonico.resources;

import java.awt.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.yasminmonico.models.Mensagem;
import com.api.yasminmonico.service.ServiceMensagem;

import ch.qos.logback.core.status.Status;

@RestController 
@RequestMapping("/api/mensagens")

public class ResourceMensagem {
	
	@Autowired
	private ServiceMensagem servicemensagem;
	
	@GetMapping("")
	public ResponseEntity<java.util.List<Mensagem>> listAll(){
		return new ResponseEntity<>(servicemensagem.listAll(), HttpStatus.OK);
	}
	
	@PostMapping("/salvar")
    public ResponseEntity<Mensagem> salvarMensagem(@RequestBody Mensagem mensagem){
		servicemensagem.salvarMensagem(mensagem);
        return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Mensagem> getMensagem(@PathVariable("codigo") int Id){
        Optional<Mensagem> mensagemOptional = servicemensagem.getMesagem(Id);
        if (mensagemOptional.isPresent()) {
            return new ResponseEntity<>(mensagemOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/excluir/{codigo}")
    public ResponseEntity<Mensagem> excluirMensagem(@PathVariable("codigo") int codigo){
        Optional<Mensagem> mensagemOptional = servicemensagem.getMesagem(codigo);
        if (mensagemOptional.isPresent()) {
        	servicemensagem.excluirMensagem(mensagemOptional.get());
            return new ResponseEntity<>(null, null, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/editar/{codigo}")
    public ResponseEntity<Mensagem> updateMensagem(@PathVariable("codigo") int codigo, @RequestBody Mensagem mensagem){
       
        Optional<Mensagem> mensagemOptional = servicemensagem.getMesagem(codigo);
        
        if (mensagemOptional.isPresent()) {
            mensagem.setId(codigo);
            servicemensagem.salvarMensagem(mensagem);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
}
