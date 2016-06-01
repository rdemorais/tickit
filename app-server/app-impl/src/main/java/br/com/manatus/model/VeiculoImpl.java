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
@Entity(name="Veiculo")
@Table(name="tb_veiculo")
public class VeiculoImpl implements Veiculo{

	@Id
    @SequenceGenerator(name="TickIt_SeqGen", sequenceName="tickit_veiculo_seq")
    @GeneratedValue(generator="TickIt_SeqGen")
    @Column(name="co_veiculo")
    private Long id;
	
	@Column(name="no_marca")
	private String marca;
	
	@Column(name="ds_modelo")
	private String modelo;
	
	@Column(name="ds_consumo")
	private String consumo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getConsumo() {
		return consumo;
	}

	public void setConsumo(String consumo) {
		this.consumo = consumo;
	}
}