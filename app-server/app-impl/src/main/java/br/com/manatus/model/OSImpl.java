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

@Entity(name="OS")
@Table(name="tb_os")
public class OSImpl implements OS{

	@Id
    @SequenceGenerator(name="TickIt_SeqGen", sequenceName="tickit_os_seq")
    @GeneratedValue(generator="TickIt_SeqGen")
	@Column(name="co_os")
	private Long id;
	
	@Column(name="dt_chamado")
	private Date dataHoraChamado;
	
	@Column(name="ds_demanda", columnDefinition="TEXT")
	private String descricaoDemanda;
	
	@Column(name="ds_solucao", columnDefinition="TEXT")
	private String sugestaoSolucao;
	
	@Column(name="dt_limite_atendimento")
	private Date dataLimiteAtendimento;
	
	@Column(name="dt_agendamento")
	private Date dataAgendamento;
	
	@OneToOne(cascade = CascadeType.REFRESH, targetEntity=ClienteImpl.class, fetch = FetchType.LAZY)
	@JoinColumn(name="co_cliente")
	private Cliente cliente;
	
	@OneToOne(cascade = CascadeType.REFRESH, targetEntity=CategoriaDemandaImpl.class, fetch = FetchType.LAZY)
	@JoinColumn(name="co_categoria_demanda", unique=false)
	private CategoriaDemanda categoriaDemanda;
	
	@OneToOne(cascade = CascadeType.REFRESH, targetEntity=TipoOSImpl.class, fetch = FetchType.LAZY)
	@JoinColumn(name="co_tipo_os")
	private TipoOS tipoOs;
	
	@OneToOne(cascade = CascadeType.REFRESH, targetEntity=FuncionarioImpl.class, fetch = FetchType.LAZY)
	@JoinColumn(name="co_tecnico_responsavel", unique=false)
	private Funcionario tecResponsavel;
	
	@OneToOne(cascade = CascadeType.REFRESH, targetEntity=FuncionarioImpl.class, fetch = FetchType.LAZY)
	@JoinColumn(name="co_tecnico_agendamento", unique=false)
	private Funcionario tecAgendamento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataHoraChamado() {
		return dataHoraChamado;
	}

	public void setDataHoraChamado(Date dataHoraChamado) {
		this.dataHoraChamado = dataHoraChamado;
	}

	public String getDescricaoDemanda() {
		return descricaoDemanda;
	}

	public void setDescricaoDemanda(String descricaoDemanda) {
		this.descricaoDemanda = descricaoDemanda;
	}

	public String getSugestaoSolucao() {
		return sugestaoSolucao;
	}

	public void setSugestaoSolucao(String sugestaoSolucao) {
		this.sugestaoSolucao = sugestaoSolucao;
	}

	public Date getDataLimiteAtendimento() {
		return dataLimiteAtendimento;
	}

	public void setDataLimiteAtendimento(Date dataLimiteAtendimento) {
		this.dataLimiteAtendimento = dataLimiteAtendimento;
	}

	public Date getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public CategoriaDemanda getCategoriaDemanda() {
		return categoriaDemanda;
	}

	public void setCategoriaDemanda(CategoriaDemanda categoriaDemanda) {
		this.categoriaDemanda = categoriaDemanda;
	}

	public TipoOS getTipoOs() {
		return tipoOs;
	}

	public void setTipoOs(TipoOS tipoOs) {
		this.tipoOs = tipoOs;
	}

	public Funcionario getTecResponsavel() {
		return tecResponsavel;
	}

	public void setTecResponsavel(Funcionario tecResponsavel) {
		this.tecResponsavel = tecResponsavel;
	}

	public Funcionario getTecAgendamento() {
		return tecAgendamento;
	}

	public void setTecAgendamento(Funcionario tecAgendamento) {
		this.tecAgendamento = tecAgendamento;
	}

	@Override
	public String toString() {
		return "OS [id=" + id + ", dataHoraChamado=" + dataHoraChamado
				+ ", descricaoDemanda=" + descricaoDemanda
				+ ", sugestaoSolucao=" + sugestaoSolucao
				+ ", dataLimiteAtendimento=" + dataLimiteAtendimento
				+ ", dataAgendamento=" + dataAgendamento + ", cliente="
				+ cliente + ", categoriaDemanda=" + categoriaDemanda
				+ ", tipoOs=" + tipoOs + ", tecResponsavel=" + tecResponsavel
				+ ", tecAgendamento=" + tecAgendamento + "]";
	}
	
}