package br.com.manatus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="TipoOS")
@Table(name="tb_tipo_os")
public class TipoOSImpl implements TipoOS{

	@Id
    @SequenceGenerator(name="TickIt_SeqGen", sequenceName="tickit_tipo_os_seq")
    @GeneratedValue(generator="TickIt_SeqGen")
    @Column(name="co_tipo_os")
    private Long id;
	
	@Column(name="no_tipo_os")
	private String tipoOs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoOs() {
		return tipoOs;
	}

	public void setTipoOs(String tipoOs) {
		this.tipoOs = tipoOs;
	}
}