package br.com.manatus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
}