package br.ufrn.PDSgrupo5.enumeration;

public enum EnumTipoRegistro {
	NUTRICIONISTA("Nutricionista"),
	MEDICO("Médico"),
	EDUCADOR_FISICO("Educador físico");

	private String descricao;

	private EnumTipoRegistro(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
