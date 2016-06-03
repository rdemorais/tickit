package br.com.manatus.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="Demanda")
@Table(name="tb_demanda")
public class DemandaImpl implements Demanda{
	
	@Id
    @SequenceGenerator(name="TickIt_SeqGen", sequenceName="tickit_demanda_seq")
    @GeneratedValue(generator="TickIt_SeqGen")
	@Column(name="co_demanda")
	private Long id;
	
	@Column(name="ds_demanda")
	private String demanda;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=CategoriaDemandaImpl.class, cascade=CascadeType.REFRESH)
	@JoinColumn(name = "co_categoria_demanda", referencedColumnName = "co_categoria_demanda")
	private CategoriaDemanda categoriaDemanda;

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

	public CategoriaDemanda getCategoriaDemanda() {
		return categoriaDemanda;
	}

	public void setCategoriaDemanda(CategoriaDemanda categoriaDemanda) {
		this.categoriaDemanda = categoriaDemanda;
	}
}