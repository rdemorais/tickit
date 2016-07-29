package br.com.manatus.service.dto;

public class FiltroDto {
	private int pagina = 1;
	private String numChamado = "";
	private PessoaDto cliente = null;
	private TipoOSDto tipoOs = null;
	
	private Long idChamado;
	private Long anoChamado;
	
	public int getPagina() {
		return pagina;
	}
	public void setPagina(int pagina) {
		this.pagina = pagina;
	}
	public String getNumChamado() {
		return numChamado;
	}
	public void setNumChamado(String numChamado) {
		this.numChamado = numChamado;
	}
	public Long getIdChamado() {
		return idChamado;
	}
	public void setIdChamado(Long idChamado) {
		this.idChamado = idChamado;
	}
	public Long getAnoChamado() {
		return anoChamado;
	}
	public void setAnoChamado(Long anoChamado) {
		this.anoChamado = anoChamado;
	}
	public PessoaDto getCliente() {
		return cliente;
	}
	public void setCliente(PessoaDto cliente) {
		this.cliente = cliente;
	}
	public TipoOSDto getTipoOs() {
		return tipoOs;
	}
	public void setTipoOs(TipoOSDto tipoOs) {
		this.tipoOs = tipoOs;
	}
}