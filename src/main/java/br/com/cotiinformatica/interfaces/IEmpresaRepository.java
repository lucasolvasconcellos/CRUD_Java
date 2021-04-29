package br.com.cotiinformatica.interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.cotiinformatica.entities.Empresa;

public interface IEmpresaRepository
extends CrudRepository<Empresa, Integer> {
	
	@Query("Select u from Usuario u where u.nomeFntasia =:param1")
	Empresa findByNomeFantasia(@Param("param1")String nomeFantasia);
	
	@Query("select u from Empresa u where u.nomeFantasia =:param1 and u.razaoSocial = :param2")
	
	Empresa findByNomeFantasiaRazaoSocial(@Param("param1")String nomeFantasia,
			                              @Param("param2")String razaoSocial);
			
                                          	

}