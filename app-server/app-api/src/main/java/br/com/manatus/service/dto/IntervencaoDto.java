package br.com.manatus.service.dto;

import br.com.manatus.model.StatusOS;

public class IntervencaoDto {
	private Long id;
	private String dataHoraIntervencao;
	private String dataHoraFimIntervencao;
	private OSDto os;
	private DemandaDto demanda;
	private PessoaDto tecAgendamento;
	private PessoaDto clienteOrigem;
	private PessoaDto clienteDestino;
	private String observacao;
	private StatusOS statusOs;
	
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
	
	public PessoaDto getTecAgendamento() {
		return tecAgendamento;
	}
	public void setTecAgendamento(PessoaDto tecAgendamento) {
		this.tecAgendamento = tecAgendamento;
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
	public StatusOS getStatusOs() {
		return statusOs;
	}
	public void setStatusOs(StatusOS statusOs) {
		this.statusOs = statusOs;
	}
}