package br.com.cotiinformatica.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cotiinformatica.dtos.FuncionarioCadastroDTO;
import br.com.cotiinformatica.dtos.FuncionarioEdicaoDTO;
import br.com.cotiinformatica.entities.Funcionario;
import br.com.cotiinformatica.repositories.EmpresaRepository;
import br.com.cotiinformatica.repositories.FuncionarioRepository;

@Controller
public class FuncionarioController {
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	private static final String  ENPOINT = "/api/funcionarios";
	
	@RequestMapping(value = ENPOINT, method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<List<String>> cadastrarFuncionario
	
		(@ResponseBody FuncionarioCadastroDTO dto) {
				
		List<String> mensagens = new ArrayList<String>();
		
		try {
			
			Funcionario funcionario = new Funcionario();
			
			funcionario.setNome(dto.getNome());
			funcionario.setCpf(dto.getCpf());
			funcionario.setDataAdmissao(dto.getDataAdmissao());
			funcionario.setSalario(dto.getSalario());
			
			funcionarioRepository.save(funcionario);
			
			mensagens.add("Funcionario cadrastrado com sucesso,");
			
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(mensagens);
		}
		
		catch (Exception e) {
			// TODO: handle exception
			
			mensagens.add("Ocorreu um erro: " + e.getMessage());
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(mensagens);
		}
		
	}
	@RequestMapping(value = ENPOINT, method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<List<String>> atualizarFuncinario
		(@ResponseBody FuncionarioEdicaoDTO dto) {
		
		List<String> mensagens = new ArrayList<String>();
		
		
		try {
			Funcionario funcionario = new Funcionario();
			
			funcionario.setIdFuncionario(dto.getIdFuncionario());
			funcionario.setNome(dto.getNome());
			funcionario.setDataAdmissao(dto.getDataAdmissao());
			funcionario.setSalario(dto.getSalario());
			
			funcionarioRepository.save(funcionario);
			
			mensagens.add("Funcionario atualizado com sucesso.");
			
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(mensagens);
		}
			
		catch (Exception e) {
			// TODO: handle exception
			
			mensagens.add("Ocorreu um erro: " + e.getMessage());
			
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(mensagens);
		}
		
	}
	@RequestMapping(value = ENPOINT + "{id} ", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<List<String>> excluirFuncinario
	
		(@PathVariable("id") Integer id) {
		
		List<String> mensagens = new ArrayList<String>();
		
		try {
			Funcionario funcionario = FuncionarioRepository(id);
			
			funcionarioRepository.delete(funcionario);
			
			mensagens.add("Conta excluída com sucesso.");
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(mensagens);
			}
		catch (Exception e) {
			// TODO: handle exception
			
			mensagens.add("Ocorreu um erro : " + e.getMessage());
					return ResponseEntity
							.status(HttpStatus.INTERNAL_SERVER_ERROR)
							.body(mensagens);
		}
		
	}
	
	@RequestMapping(value = ENPOINT + "/{dataInicio}/{dataFim}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<String>> consultarFuncinario(
		@PathVariable("dataInicio") Date dataInicio,
		@PathVariable("dataFim") Date datafim) {
		
		return null;
	}
		
}
