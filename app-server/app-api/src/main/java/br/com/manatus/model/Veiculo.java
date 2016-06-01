package br.com.manatus.model;

public interface Veiculo {
	public Long getId();
	public void setId(Long id);
	public String getMarca();
	public void setMarca(String marca);
	public String getModelo();
	public void setModelo(String modelo);
	public String getConsumo();
	public void setConsumo(String consumo);
}