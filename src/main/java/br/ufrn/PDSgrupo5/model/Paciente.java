package br.ufrn.PDSgrupo5.model;

import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;
import java.util.List;

@ApiIgnore
@Entity
@Table(name = "paciente")
public class Paciente extends EntidadeAbstrata {

	private Double altura;

	private Double peso;

	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Pessoa pessoa;

	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Paciente> dependentes;

	public Paciente() {
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Paciente> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<Paciente> dependentes) {
		this.dependentes = dependentes;
	}
}