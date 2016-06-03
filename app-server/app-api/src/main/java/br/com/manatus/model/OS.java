package br.com.manatus.model;

import java.util.Collection;
import java.util.Date;

import br.com.akula.api.model.Auditavel;

public interface OS extends Auditavel{
	public Long getId();
	public void setId(Long id);
	public Date getDataHoraChamado();
	public void setDataHoraChamado(Date dataHoraChamado);
	public Date getDataConclusao();
	public void setDataConclusao(Date dataConclusao);
	public String getDescricaoDemanda();
	public void setDescricaoDemanda(String descricaoDemanda);
	public String getSugestaoSolucao();
	public void setSugestaoSolucao(String sugestaoSolucao);
	public Date getDataLimiteAtendimento();
	public void setDataLimiteAtendimento(Date dataLimiteAtendimento);
	public Date getDataAgendamento();
	public void setDataAgendamento(Date dataAgendamento);
	public Cliente getCliente();
	public void setCliente(Cliente cliente);
	public CategoriaDemanda getCategoriaDemanda();
	public void setCategoriaDemanda(CategoriaDemanda categoriaDemanda);
	public TipoOS getTipoOs();
	public void setTipoOs(TipoOS tipoOs);
	public Funcionario getTecResponsavel();
	public void setTecResponsavel(Funcionario tecResponsavel);
	public Funcionario getTecAgendamento();
	public void setTecAgendamento(Funcionario tecAgendamento);
	public StatusOS getStatusOs();
	public void setStatusOs(StatusOS statusOs);
	public Collection<Intervencao> getIntervencoes();
	public void setIntervencoes(Collection<Intervencao> intervencoes);
}