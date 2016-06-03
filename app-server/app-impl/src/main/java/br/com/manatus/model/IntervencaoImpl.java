package br.com.manatus.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="Intervencao")
@Table(name="tb_intervencao")
public class IntervencaoImpl implements Intervencao{
	
	@Id
    @SequenceGenerator(name="TickIt_SeqGen", sequenceName="tickit_intervencao_seq")
    @GeneratedValue(generator="TickIt_SeqGen")
	@Column(name="co_intervencao")
	private Long id;
	
	@Column(name="dt_intervencao")
	private Date dataHoraIntervencao;
	
	@Column(name="dt_fim_intervencao")
	private Date dataHoraFimIntervencao;
	
	@OneToOne(cascade=CascadeType.REFRESH, targetEntity=OSImpl.class, fetch = FetchType.LAZY)
	@JoinColumn(name="co_os", unique=false)
	private OS os;
	
	@OneToOne(cascade=CascadeType.REFRESH, targetEntity=DemandaImpl.class, fetch = FetchType.LAZY)
	@JoinColumn(name="co_demanda", unique=false)
	private Demanda demanda;
	
	@OneToOne(cascade=CascadeType.REFRESH, targetEntity=FuncionarioImpl.class, fetch = FetchType.LAZY)
	@JoinColumn(name="co_tecnico_responsavel", unique=false)
	private Funcionario tecResponsavel;
	
	@OneToOne(cascade=CascadeType.REFRESH, targetEntity=ClienteImpl.class, fetch = FetchType.LAZY)
	@JoinColumn(name="co_cliente_origem")
	private Cliente clienteOrigem;
	
	@OneToOne(cascade=CascadeType.REFRESH, targetEntity=ClienteImpl.class, fetch = FetchType.LAZY)
	@JoinColumn(name="co_cliente_destino")
	private Cliente clienteDestino;
	
	@Column(name="ds_obs", columnDefinition="TEXT")
	private String observacao;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataHoraIntervencao() {
		return dataHoraIntervencao;
	}

	public void setDataHoraIntervencao(Date dataHoraIntervencao) {
		this.dataHoraIntervencao = dataHoraIntervencao;
	}

	public Date getDataHoraFimIntervencao() {
		return dataHoraFimIntervencao;
	}

	public void setDataHoraFimIntervencao(Date dataHoraFimIntervencao) {
		this.dataHoraFimIntervencao = dataHoraFimIntervencao;
	}
	
	public OS getOs() {
		return os;
	}

	public void setOs(OS os) {
		this.os = os;
	}

	public Demanda getDemanda() {
		return demanda;
	}

	public void setDemanda(Demanda demanda) {
		this.demanda = demanda;
	}

	public Funcionario getTecResponsavel() {
		return tecResponsavel;
	}

	public void setTecResponsavel(Funcionario tecResponsavel) {
		this.tecResponsavel = tecResponsavel;
	}

	public Cliente getClienteOrigem() {
		return clienteOrigem;
	}

	public void setClienteOrigem(Cliente clienteOrigem) {
		this.clienteOrigem = clienteOrigem;
	}

	public Cliente getClienteDestino() {
		return clienteDestino;
	}

	public void setClienteDestino(Cliente clienteDestino) {
		this.clienteDestino = clienteDestino;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}