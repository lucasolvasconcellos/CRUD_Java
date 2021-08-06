package br.com.cotiinformatica.repositories;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.entities.Empresa;
import br.com.cotiinformatica.interfaces.IEmpresaRepository;

@Service
@Transactional
public class EmpresaRepository {
	@Autowired
	private IEmpresaRepository empresaRepository;
	
	public void save(Empresa empresa) throws Exception {
		empresaRepository.save(empresa);
		
	}
	
	
	public Empresa finByRazaoSocialNomeFantasia(String razaoSocial, String nomefantasia) throws Exception {
		return empresaRepository.findByNomeFantasiaRazaoSocial(nomefantasia, razaoSocial);
	}

}
