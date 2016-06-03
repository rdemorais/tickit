package br.com.manatus.service.dto;

public class CategoriaDemandaDto {
	private Long id;
	
	private String categoriaDemanda;
	
	public CategoriaDemandaDto() {
	
	}

	public CategoriaDemandaDto(Long id, String categoriaDemanda) {
		this.id = id;
		this.categoriaDemanda = categoriaDemanda;
	}

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

	@Override
	public String toString() {
		return "CategoriaDemandaDto [id=" + id + ", categoriaDemanda=" + categoriaDemanda + "]";
	}
	
}