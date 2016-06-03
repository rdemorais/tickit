package br.com.manatus.service.dto;

public class IntervencaoDto {
	private Long id;
	private String dataHoraIntervencao;
	private String dataHoraFimIntervencao;
	private OSDto os;
	private DemandaDto demanda;
	private PessoaDto tecResponsavel;
	private PessoaDto clienteOrigem;
	private PessoaDto clienteDestino;
	private String observacao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDataHoraIntervencao() {
		return dataHoraIntervencao;
	}
	public void setDataHoraIntervencao(String dataHoraIntervencao) {
		this.dataHoraIntervencao = dataHoraIntervencao;
	}
	public String getDataHoraFimIntervencao() {
		return dataHoraFimIntervencao;
	}
	public void setDataHoraFimIntervencao(String dataHoraFimIntervencao) {
		this.dataHoraFimIntervencao = dataHoraFimIntervencao;
	}
	public OSDto getOs() {
		return os;
	}
	public void setOs(OSDto os) {
		this.os = os;
	}
	public DemandaDto getDemanda() {
		return demanda;
	}
	public void setDemanda(DemandaDto demanda) {
		this.demanda = demanda;
	}
	public PessoaDto getTecResponsavel() {
		return tecResponsavel;
	}
	public void setTecResponsavel(PessoaDto tecResponsavel) {
		this.tecResponsavel = tecResponsavel;
	}
	public PessoaDto getClienteOrigem() {
		return clienteOrigem;
	}
	public void setClienteOrigem(PessoaDto clienteOrigem) {
		this.clienteOrigem = clienteOrigem;
	}
	public PessoaDto getClienteDestino() {
		return clienteDestino;
	}
	public void setClienteDestino(PessoaDto clienteDestino) {
		this.clienteDestino = clienteDestino;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}