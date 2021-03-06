package br.ufrn.PDSgrupo5.model;

import br.ufrn.PDSgrupo5.enumeration.EnumTipoAtendimento;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "atendimento")
public class Atendimento extends EntidadeAbstrata {

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "horario", nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date horario;

	private Integer duracao;

	private Double preco;

	private String titulo;

	private String descricao;

	private String status;

	@OneToOne
	private Paciente paciente;

	@OneToOne(cascade = CascadeType.ALL)
	private ProfissionalSaude profissionalSaude;

	@Column(name="tipo_atendimento")
	@Enumerated(EnumType.STRING)
	private EnumTipoAtendimento enumTipoAtendimento;

	public Atendimento() {
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public ProfissionalSaude getProfissionalSaude() {
		return profissionalSaude;
	}

	public void setProfissionalSaude(ProfissionalSaude profissionalSaude) {
		this.profissionalSaude = profissionalSaude;
	}

	public EnumTipoAtendimento getEnumTipoAtendimento() {
		return enumTipoAtendimento;
	}

	public void setEnumTipoAtendimento(EnumTipoAtendimento enumTipoAtendimento) {
		this.enumTipoAtendimento = enumTipoAtendimento;
	}
}
