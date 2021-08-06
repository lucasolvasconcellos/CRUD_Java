package br.com.cotiinformatica.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDFUNCIONARIO")
    private Integer idFuncionario;
	
	@Column(name = "NOME", length = 150,nullable = false)
	private String nome;
	
	@Column(name = "CPF",nullable = false)
	private String cpf;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATAADMISSAO", nullable = false)
	private Date dataAdmissao;
	
	@Column(name = "SALARIO", nullable = false)
	private Double salario;

	public Funcionario() {
		// TODO Auto-generated constructor stub
	}

	public Funcionario(Integer idFuncionario, String nome, String cpf, Date dataAdmissao, Double salario,
			Funcionario funcionario) {
		
		super();
		
		this.idFuncionario = idFuncionario;
		this.nome = nome;
		this.cpf = cpf;
		this.dataAdmissao = dataAdmissao;
		this.salario = salario;

	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Funcionario [idFuncionario=" + idFuncionario + ", nome=" + nome + ", cpf=" + cpf + ", dataAdmissao="
				+ dataAdmissao + ", salario=" + salario + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Funcionario) {
			Funcionario funcionaria = (Funcionario) obj;
			return this.idFuncionario.equals(funcionaria.getIdFuncionario());
		}
		
		return false;
	
	}
	
	@Override
	public int hashCode() {
		return this.idFuncionario.hashCode();
	}

}
