package br.com.manatus.model;

import java.util.Date;

public interface Intervencao {
	public Long getId();
	public void setId(Long id);
	public Date getDataHoraIntervencao();
	public void setDataHoraIntervencao(Date dataHoraIntervencao);
	public Date getDataHoraFimIntervencao();
	public void setDataHoraFimIntervencao(Date dataHoraFimIntervencao);
	public OS getOs();
	public void setOs(OS os);
	public Demanda getDemanda();
	public void setDemanda(Demanda demanda);
	public Funcionario getTecAgendamento();
	public void setTecAgendamento(Funcionario tecAgendamento);
	public Cliente getClienteOrigem();
	public void setClienteOrigem(Cliente clienteOrigem);
	public Cliente getClienteDestino();
	public void setClienteDestino(Cliente clienteDestino);
	public String getObservacao();
	public void setObservacao(String observacao);
}