package br.com.manatus.service.dto;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class OSDto {
	private Long id;
	private String codigoChamado;
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
	
	public OSDto() {
	
	}
	
	public OSDto(Long id, Date dataHoraChamado, String nomeCliente, Date dataLimiteAtendimento, String nomeTecnico) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Calendar dtAgend = Calendar.getInstance();
		dtAgend.setTime(dataHoraChamado);
		
		this.id = id;
		this.dataHoraChamado = sdf.format(dataHoraChamado);
		this.dataLimiteAtendimento = sdf.format(dataLimiteAtendimento);
		this.cliente = new PessoaDto(1L, nomeCliente);
		this.tecResponsavel = new PessoaDto(1L, nomeTecnico);
		this.codigoChamado = id + "/" + dtAgend.get(Calendar.YEAR);
	}
	
	public OSDto(Long id, Date dataHoraChamado, Long idCliente, String nomeCliente, Date dataLimiteAtendimento, String nomeTecnico, 
			String descricaoDemanda, String sugestaoSolucao, Long idCategoriaDemanda, String categoriaDemanda, String tipoOs) {
		this(id, dataHoraChamado, nomeCliente, dataLimiteAtendimento, nomeTecnico);
		this.cliente.setId(idCliente);
		this.descricaoDemanda = descricaoDemanda;
		this.sugestaoSolucao = sugestaoSolucao;
		this.categoriaDemanda = new CategoriaDemandaDto(idCategoriaDemanda, categoriaDemanda);
		this.tipoOs = new TipoOSDto(1L, tipoOs);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCodigoChamado() {
		return codigoChamado;
	}

	public void setCodigoChamado(String codigoChamado) {
		this.codigoChamado = codigoChamado;
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
	@Override
	public String toString() {
		return "OSDto [id=" + id + ", dataHoraChamado=" + dataHoraChamado + ", descricaoDemanda=" + descricaoDemanda
				+ ", sugestaoSolucao=" + sugestaoSolucao + ", dataLimiteAtendimento=" + dataLimiteAtendimento
				+ ", dataAgendamento=" + dataAgendamento + "]";
	}
	
}