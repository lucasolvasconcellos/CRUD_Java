package br.com.cotiinformatica.interfaces;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.cotiinformatica.entities.Funcionario;

public interface IFuncionarioRepository 

   extends CrudRepository<Funcionario, Integer> {
	
	@Query("Select c from Funcionario c where c.dataAdmissao >= :param1 and c.dataAdmissao <= :param2")
	
	List<Funcionario> findByDataAdmissao(@Param("param1") Date dataMin,
			                             @Param("param2") Date dataMax);

}
