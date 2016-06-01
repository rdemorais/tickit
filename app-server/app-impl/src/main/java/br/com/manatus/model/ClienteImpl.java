package br.com.manatus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity(name="Cliente")
@Table(name="tb_cliente")
@PrimaryKeyJoinColumn(name="co_pessoa")
public class ClienteImpl extends PessoaImpl implements Cliente{
	
	@Column(name="ds_razao_social")
	private String razaoSocial;
	
	@Column(name="ds_inscricao_estadual")
	private String inscricaoEstadual;
	
	@Column(name="ds_tipo_cliente")
	@Enumerated(EnumType.STRING)
	private TipoCliente tipoCliente;

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
}