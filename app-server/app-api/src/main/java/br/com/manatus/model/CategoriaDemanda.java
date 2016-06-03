package br.com.manatus.model;

import java.util.Collection;

public interface CategoriaDemanda {
	public Long getId();
	public void setId(Long id);
	public String getCategoriaDemanda();
	public void setCategoriaDemanda(String categoriaDemanda);
	public Collection<Demanda> getDemandas();
	public void setDemandas(Collection<Demanda> demandas);
}