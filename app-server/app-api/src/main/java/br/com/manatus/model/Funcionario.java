package br.com.manatus.model;

public interface Funcionario extends Pessoa{
	public Double getSalario();
	public void setSalario(Double salario);
	public Cargo getCargo();
	public void setCargo(Cargo cargo);
	public Veiculo getVeiculo();
	public void setVeiculo(Veiculo veiculo);
	public String getHabilidade();
	public void setHabilidade(String habilidade);
	public String getAreaAtuacao();
	public void setAreaAtuacao(String areaAtuacao);
}