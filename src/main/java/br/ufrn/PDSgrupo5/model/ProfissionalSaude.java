package br.ufrn.PDSgrupo5.model;

import br.ufrn.PDSgrupo5.enumeration.EnumTipoRegistro;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "profissional_saude")
public class ProfissionalSaude extends EntidadeAbstrata {
	@Column(name="numero_registro")
	private Long numeroRegistro;
	
	@NotNull(message = "A data de aprovação do registro não pode ser vazia")
	@Past(message="A data de aprovação deve ser anterior ao dia de hoje")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="data_aprovacao_registro")
	private Date dataAprovacaoRegistro;

	private String descricao;

	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Pessoa pessoa;

	@Column(name="tipo_registro")
	@Enumerated(EnumType.STRING)
	private EnumTipoRegistro enumTipoRegistro;

	@Column(name="turno_atendimento")
	@OneToMany(cascade = CascadeType.ALL)
	private List<TurnoAtendimento> turnoAtendimento;
	
	private boolean legalizado = false;

	public ProfissionalSaude() {
	}

	public Long getNumeroRegistro() {
		return numeroRegistro;
	}

	public void setNumeroRegistro(Long numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

	public Date getDataAprovacaoRegistro() {
		return dataAprovacaoRegistro;
	}

	public void setDataAprovacaoRegistro(Date dataAprovacaoRegistro) {
		this.dataAprovacaoRegistro = dataAprovacaoRegistro;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public EnumTipoRegistro getEnumTipoRegistro() {
		return enumTipoRegistro;
	}

	public void setEnumTipoRegistro(EnumTipoRegistro enumTipoRegistro) {
		this.enumTipoRegistro = enumTipoRegistro;
	}

	public List<TurnoAtendimento> getTurnoAtendimento() {
		return turnoAtendimento;
	}

	public void setTurnoAtendimento(List<TurnoAtendimento> turnoAtendimento) {
		this.turnoAtendimento = turnoAtendimento;
	}
	
	public boolean getLegalizado() {
		return legalizado;
	}
	
	public void setLegalizado(boolean legalizado) {
		this.legalizado = legalizado;
	}
}
