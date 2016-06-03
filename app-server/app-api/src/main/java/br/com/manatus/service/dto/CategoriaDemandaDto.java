package br.com.manatus.service.dto;

public class CategoriaDemandaDto {
	private Long id;
	
	private String categoriaDemanda;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategoriaDemanda() {
		return categoriaDemanda;
	}
	public void setCategoriaDemanda(String categoriaDemanda) {
		this.categoriaDemanda = categoriaDemanda;
	}
}