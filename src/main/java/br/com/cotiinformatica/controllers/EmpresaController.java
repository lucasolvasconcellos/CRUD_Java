package br.com.cotiinformatica.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cotiinformatica.dtos.EmpresaCadastroDTO;
import br.com.cotiinformatica.validations.EmpresaCadastroValidation;
@Controller

public class EmpresaController {
	
	private static final String ENDPOINT = "/api/empresas";
	
	@RequestMapping(value = ENDPOINT,method = RequestMethod.POST)
	
	@ResponseBody
	public ResponseEntity<List<String>> cadastrarEmpresa
		(@RequestBody EmpresaCadastroDTO dto) {
		
		
		List<String> mensagens = new ArrayList<String>();
		
		try {
			
			mensagens = EmpresaCadastroValidation.validate(dto);
			
			if(mensagens.size() == 0) {
			
			mensagens.add("Empresa Cadastrada com sucesso.");
			
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(mensagens);
			}
			
			else {
				
				return ResponseEntity
						.status(HttpStatus.BAD_REQUEST)
						.body(mensagens);
			}
			
		}
		
		catch(Exception e) {
			mensagens.add("Ocorreu em erro: " + e.getMessage());
			
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(mensagens);
			
			
		}
		
	}

}
