package br.com.cotiinformatica.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

import org.hibernate.secure.spi.GrantedPermission;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cotiinformatica.dtos.EmpresaCadastroDTO;
import br.com.cotiinformatica.dtos.EmpresaLoginDTO;
import br.com.cotiinformatica.entities.Empresa;
import br.com.cotiinformatica.validations.EmpresaCadastroValidation;
import br.com.cotiinformatica.validations.EmpresaLoginValidation;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Controller

public class LoginController {
	
	private static final String ENDPOINT = "/api/login";
	

	@RequestMapping(value = ENDPOINT,method = RequestMethod.POST)
	
	@ResponseBody
	public ResponseEntity<List<String>> cadastrarEmpresa
		(@RequestBody EmpresaCadastroDTO dto) {
		
		
		List<String> mensagens = new ArrayList<String>();
		
		try {
			
			mensagens = EmpresaCadastroValidation.validate(dto);
			
			if(mensagens.size() == 0) {
				
				
			
			if(empresaRepository.findByNomeFantasia(dto.getNomeFantasia())!= null) {
				
				throw new Exception("O nome informado já encontra-se cadastrado.");
			}
			
			
			Empresa empresa = new Empresa();
			
			empresa.setNomeFantasia(dto.getNomeFantasia());
			empresa.setRazaoSocial(dto.getRazaoSocial());
			empresa.setCnpj(dto.getCnpj());
			
			
			
			mensagens.add("Empresa cadastrada com sucesso.");
			
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
		
		private String getJWTToken(String nomeFantasia) {
			//Todo TOKEN é gerado de forma criptografada,
			//mas precisamos gerar essa criptografia
			//utilizando uma palavra secreta, isso irá
			//garantir que nenhum outro projeto conseguirá
			//falsificar TOKENs da nossa aplicação.
			String secretKey = "5eebb082-4046-4d7f-a638-3c16d9dec4";
			//Gerando o TOKEN de acesso do usuário
			List<GrantedAuthority> grantedAuthorities = AuthorityUtils
			.commaSeparatedStringToAuthorityList("ROLE_USER");
			String token = Jwts
			.builder()
			.setId("COTI_JWT")
			.setSubject(nomeFantasia)
			.claim("authorities", grantedAuthorities.stream()
			.map(GrantedAuthority::getAuthority)
			.collect(Collectors.toList()))
			.setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis()
			+ 600000)) //expira em 10 minutos

			.signWith(SignatureAlgorithm.HS512,
			secretKey.getBytes())

			.compact();

			return token;
			
			
		
	}
	
	}
			

		
	
