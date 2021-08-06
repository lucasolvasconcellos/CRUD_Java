package br.com.cotiinformatica.repositories;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.entities.Funcionario;
import br.com.cotiinformatica.interfaces.IFuncionarioRepository;

@Service
@Transactional
public class FuncionarioRepository {
	@Autowired
	private IFuncionarioRepository funcionarioRepository;
	
	public void save (Funcionario funcionario) throws Exception {
		funcionarioRepository.save(funcionario);
	}
	
	public void delete(Funcionario funcionario) throws Exception {
		funcionarioRepository.delete(funcionario);
	}
	
	public List<Funcionario> findAllByDataAdmissao(Date dataInicio,
			Date dataFim) throws Exception {
		return funcionarioRepository.findByDataAdmissao(dataInicio, dataFim);
	}
	
}
