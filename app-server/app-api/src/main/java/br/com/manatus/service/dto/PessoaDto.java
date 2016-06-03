package br.com.manatus.service.dto;

public class PessoaDto {
	private Long id;
	private String avatar;
	private String nome;
	private String datNascimento;
	private String cpfCnpj;
	private String genero;
	private String comentario;
	private String website;
	private String facebook;
	private String twitter;
	private Boolean autoRegistro;
	private String email;
	private String senha;
	
	//Funcionario
	private Double salario;
	private CargoDto cargo;
	private VeiculoDto veiculo;
	private String habilidade;
	private String areaAtuacao;
	
	//cliente
	private String razaoSocial;
	private String inscricaoEstadual;
	private String tipoCliente;
	
	public PessoaDto() {
		
	}
	
	/**
	 * Construtor usado para carregar listas de clientes e tecnicos
	 * 
	 * @param id
	 * @param nome
	 */
	public PessoaDto(Long id, String nome) {
		this.id = id;
		this.nome = nome;
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
	public String getDatNascimento() {
		return datNascimento;
	}
	public void setDatNascimento(String datNascimento) {
		this.datNascimento = datNascimento;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
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
	public Boolean getAutoRegistro() {
		return autoRegistro;
	}
	public void setAutoRegistro(Boolean autoRegistro) {
		this.autoRegistro = autoRegistro;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public CargoDto getCargo() {
		return cargo;
	}
	public void setCargo(CargoDto cargo) {
		this.cargo = cargo;
	}
	public VeiculoDto getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(VeiculoDto veiculo) {
		this.veiculo = veiculo;
	}
	public String getHabilidade() {
		return habilidade;
	}
	public void setHabilidade(String habilidade) {
		this.habilidade = habilidade;
	}
	public String getAreaAtuacao() {
		return areaAtuacao;
	}
	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	public String getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	@Override
	public String toString() {
		return "PessoaDto [id=" + id + ", nome=" + nome + ", datNascimento=" + datNascimento + ", cpfCnpj=" + cpfCnpj
				+ ", genero=" + genero + ", comentario=" + comentario + ", website=" + website + ", facebook="
				+ facebook + ", twitter=" + twitter + ", autoRegistro=" + autoRegistro + ", email=" + email + ", senha="
				+ senha + ", salario=" + salario + ", cargo=" + cargo + ", veiculo=" + veiculo + ", habilidade="
				+ habilidade + ", areaAtuacao=" + areaAtuacao + ", razaoSocial=" + razaoSocial + ", inscricaoEstadual="
				+ inscricaoEstadual + ", tipoCliente=" + tipoCliente + "]";
	}
}