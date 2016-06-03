package br.com.manatus.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="CategoriaDemanda")
@Table(name="tb_categoria_demanda")
public class CategoriaDemandaImpl implements CategoriaDemanda{

	@Id
    @SequenceGenerator(name="TickIt_SeqGen", sequenceName="tickit_categoria_demanda_seq")
    @GeneratedValue(generator="TickIt_SeqGen")
    @Column(name="co_categoria_demanda")
    private Long id;
	
	@Column(name="no_categoria")
	private String categoriaDemanda;
	
	@OneToMany(targetEntity=DemandaImpl.class, cascade=CascadeType.REMOVE, fetch=FetchType.LAZY, mappedBy="categoriaDemanda")
	private Collection<Demanda> demandas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoriaDemanda() {
		return categoriaDemanda;
	}

	public void setCategoriaDemanda(String categoriaDemanda) {
		this.categoriaDemanda = categoriaDemanda;
	}

	public Collection<Demanda> getDemandas() {
		return demandas;
	}

	public void setDemandas(Collection<Demanda> demandas) {
		this.demandas = demandas;
	}
}