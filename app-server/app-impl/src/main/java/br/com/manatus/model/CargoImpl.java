package br.com.manatus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author Rafael de Morais
 *
 */
@Entity(name="Cargo")
@Table(name="tb_cargo")
public class CargoImpl implements Cargo{
	
	@Id
    @SequenceGenerator(name="TickIt_SeqGen", sequenceName="tickit_cargo_seq")
    @GeneratedValue(generator="TickIt_SeqGen")
    @Column(name="co_cargo")
    private Long id;
	
	@Column(name="no_cargo")
	private String nome;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}