package br.com.manatus.service.dto;

public class OSDto {
	private Long id;
	private String dataHoraChamado;
	private String descricaoDemanda;
	private String sugestaoSolucao;
	private String dataLimiteAtendimento;
	private String dataAgendamento;
	private CategoriaDemandaDto categoriaDemanda;
	private TipoOSDto tipoOs;
	private PessoaDto cliente;
	private PessoaDto tecResponsavel;
	private PessoaDto tecAgendamento;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDataHoraChamado() {
		return dataHoraChamado;
	}
	public void setDataHoraChamado(String dataHoraChamado) {
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
	public String getDataLimiteAtendimento() {
		return dataLimiteAtendimento;
	}
	public void setDataLimiteAtendimento(String dataLimiteAtendimento) {
		this.dataLimiteAtendimento = dataLimiteAtendimento;
	}
	public String getDataAgendamento() {
		return dataAgendamento;
	}
	public void setDataAgendamento(String dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	public CategoriaDemandaDto getCategoriaDemanda() {
		return categoriaDemanda;
	}
	public void setCategoriaDemanda(CategoriaDemandaDto categoriaDemanda) {
		this.categoriaDemanda = categoriaDemanda;
	}
	public TipoOSDto getTipoOs() {
		return tipoOs;
	}
	public void setTipoOs(TipoOSDto tipoOs) {
		this.tipoOs = tipoOs;
	}
	public PessoaDto getCliente() {
		return cliente;
	}
	public void setCliente(PessoaDto cliente) {
		this.cliente = cliente;
	}
	public PessoaDto getTecResponsavel() {
		return tecResponsavel;
	}
	public void setTecResponsavel(PessoaDto tecResponsavel) {
		this.tecResponsavel = tecResponsavel;
	}
	public PessoaDto getTecAgendamento() {
		return tecAgendamento;
	}
	public void setTecAgendamento(PessoaDto tecAgendamento) {
		this.tecAgendamento = tecAgendamento;
	}
	
}