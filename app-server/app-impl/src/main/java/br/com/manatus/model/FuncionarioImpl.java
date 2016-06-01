package br.com.manatus.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity(name="Funcionario")
@Table(name="tb_funcionario")
@PrimaryKeyJoinColumn(name="co_pessoa")
public class FuncionarioImpl extends PessoaImpl implements Funcionario{

	@Column(name="ds_salario")
	private Double salario;
	
	@OneToOne(cascade = CascadeType.ALL, optional = false, targetEntity=CargoImpl.class, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name="co_cargo", unique=false)
	private Cargo cargo;
	
	@OneToOne(cascade = CascadeType.ALL, optional = false, targetEntity=VeiculoImpl.class, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name="co_veiculo", unique=false)
	private Veiculo veiculo;
	
	@Column(name="ds_habilidade")
	private String habilidade;
	
	@Column(name="ds_area_atuacao")
	private String areaAtuacao;
	
	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public String getHabilidade() {
		return habilidade;
	}

	public void setHabilidade(String habilidade) {
		this.habilidade = habilidade;
	}

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	@Override
	public String toString() {
		return "Funcionario [salario=" + salario + ", cargo=" + cargo
				+ ", veiculo=" + veiculo + ", habilidade=" + habilidade
				+ ", areaAtuacao=" + areaAtuacao + "]";
	}

	
}