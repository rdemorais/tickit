package br.com.manatus.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.akula.api.model.Usuario;
import br.com.akula.impl.model.UsuarioImpl;

@Entity(name="Pessoa")
@Table(name="tb_pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public class PessoaImpl implements Pessoa{

	@Id
    @SequenceGenerator(name="TickIt_SeqGen", sequenceName="tickit_pessoa_seq")
    @GeneratedValue(generator="TickIt_SeqGen")
	@Column(name="co_pessoa")
	private Long id;
	
	@Column(name="ds_avatar")
	private String avatar;
	
	@Column(name="ds_nome")
	private String nome;
	
	@Column(name="ds_sobrenome")
	private String sobrenome = "";
	
	@Column(name="dt_nascimento")
	private Date datNascimento;
	
	@Column(name="ds_cpf_cnpj")
	private String cpfCnpj;
	
	@Column(name="ds_genero")
	private String genero;
	
	@Column(name="ds_comentario")
	private String comentario;
	
	@Column(name="ds_email")
	private String email;
	
	@Column(name="ds_website")
	private String website;
	
	@Column(name="ds_facebook")
	private String facebook;
	
	@Column(name="ds_twitter")
	private String twitter;
	
	@OneToOne(cascade = CascadeType.ALL, optional = false, targetEntity=UsuarioImpl.class, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name="co_usuario")
	private Usuario usuario;
	
	@Column(name="ind_auto_registro")
	private Boolean autoRegistro;
	
	public Boolean getAutoRegistro() {
		return autoRegistro;
	}
	public void setAutoRegistro(Boolean autoRegistro) {
		this.autoRegistro = autoRegistro;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public Date getDatNascimento() {
		return datNascimento;
	}
	public void setDatNascimento(Date datNascimento) {
		this.datNascimento = datNascimento;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
}