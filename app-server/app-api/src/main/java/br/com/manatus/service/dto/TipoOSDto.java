package br.com.manatus.service.dto;

public class TipoOSDto {
	private Long id;
	private String tipoOs;
	
	public TipoOSDto() {
	
	}
	
	public TipoOSDto(Long id, String tipoOs) {
		this.id = id;
		this.tipoOs = tipoOs;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipoOs() {
		return tipoOs;
	}
	public void setTipoOs(String tipoOs) {
		this.tipoOs = tipoOs;
	}

	@Override
	public String toString() {
		return "TipoOSDto [id=" + id + ", tipoOs=" + tipoOs + "]";
	}
	
}