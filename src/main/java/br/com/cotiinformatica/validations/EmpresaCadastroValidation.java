package br.com.cotiinformatica.validations;

import java.util.ArrayList;
import java.util.List;

import br.com.cotiinformatica.dtos.EmpresaCadastroDTO;

public class EmpresaCadastroValidation {
	
	public static List<String> validate(EmpresaCadastroDTO dto) {
		
		List<String> mensagens = new ArrayList<String>();
		
		if (dto.getNomeFantasia() == null || dto.getNomeFantasia().length() == 0) {
			mensagens.add("Por favor, informe o nome do usuario.");
		}
		
		else if (dto.getNomeFantasia().trim().length() < 6
				|| dto.getNomeFantasia().trim().length() > 150) {
			mensagens.add("Por favor, infoma o a empressa contendo 6 a 150.");
		}
		
		if (dto.getRazaoSocial() == null || dto.getRazaoSocial().length() == 0) {
			mensagens.add("Por favor, infome a razao social.");
		}
		
		if (dto.getCnpj() == null || dto.getCnpj().length() == 0) {
			
			mensagens.add("Por favor, infome o cnpj da empresa");
		}
		
		else if (dto.getCnpj().trim().length() < 8 || dto.getCnpj().trim().length() > 20) {
			
			mensagens.add("Por favor, informe o cnpj contendo 8 a 20.");
			
			
		}
		
		if (dto.getCnpjConfirmacao() == null || dto.getCnpjConfirmacao().length() == 0) {
			
			mensagens.add("Por favor, confirme o cnpj da empresa.");
		}
		
		else if(!dto.getCnpjConfirmacao().equals(dto.getCnpj())) {
			mensagens.add("Cnpj não conferem.");
		}
		
		return mensagens;
			
	}

}
