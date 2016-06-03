package br.com.manatus.model;

public interface Demanda {
	public Long getId();
	public void setId(Long id);
	public String getDemanda();
	public void setDemanda(String demanda);
	public CategoriaDemanda getCategoriaDemanda();
	public void setCategoriaDemanda(CategoriaDemanda categoriaDemanda);
}