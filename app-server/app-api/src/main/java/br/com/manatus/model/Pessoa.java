package br.com.manatus.model;

import java.util.Date;

import br.com.akula.api.model.Usuario;

public interface Pessoa {
	public Boolean getAutoRegistro();
	public void setAutoRegistro(Boolean autoRegistro);
	public Long getId();
	public void setId(Long id);
	public String getAvatar();
	public void setAvatar(String avatar);
	public String getNome();
	public void setNome(String nome);
	public void setDatNascimento(Date datNascimento);
	public String getGenero();
	public void setGenero(String genero);
	public String getComentario();
	public void setComentario(String comentario);
	public String getWebsite();
	public void setWebsite(String website);
	public String getFacebook();
	public void setFacebook(String facebook);
	public String getTwitter();
	public void setTwitter(String twitter);
	public Usuario getUsuario();
	public void setUsuario(Usuario usuario);
	public String getCpfCnpj();
	public void setCpfCnpj(String cpfCnpj);
}