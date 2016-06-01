package br.com.manatus.model;

public interface Cliente extends Pessoa{
	public String getRazaoSocial();
	public void setRazaoSocial(String razaoSocial);
	public String getInscricaoEstadual();
	public void setInscricaoEstadual(String inscricaoEstadual);
	public TipoCliente getTipoCliente();
	public void setTipoCliente(TipoCliente tipoCliente);
}