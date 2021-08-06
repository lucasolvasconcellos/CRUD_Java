package br.com.cotiinformatica.validations;

import java.util.ArrayList;
import java.util.List;

import br.com.cotiinformatica.dtos.EmpresaLoginDTO;

public class EmpresaLoginValidation {
	
	public static List<String> validate(EmpresaLoginDTO dto) {
		
		List<String> mensagens = new ArrayList<String>();
		
		if (dto.getRazaoSocial() == null || dto.getRazaoSocial().length() == 0) {
			
			mensagens.add("Por favor , informe o razao social da empresa");
			
		}
		
		if (dto.getCnpj() == null || dto.getCnpj().length() == 0) {
			
			mensagens.add("Por favor, informe a cnpj da empresa.");
		}
		
		return mensagens;
		
	}

}