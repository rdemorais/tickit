package br.com.manatus.service.dto;

public class DemandaDto {
	private Long id;
	private String demanda;
	
	public DemandaDto() {
	
	}
	
	public DemandaDto(Long id, String demanda) {
		this.id = id;
		this.demanda = demanda;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDemanda() {
		return demanda;
	}
	public void setDemanda(String demanda) {
		this.demanda = demanda;
	}

	@Override
	public String toString() {
		return "DemandaDto [id=" + id + ", demanda=" + demanda + "]";
	}
	
}