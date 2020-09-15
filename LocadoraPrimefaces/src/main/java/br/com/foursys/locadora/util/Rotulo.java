package br.com.foursys.locadora.util;

/**
 * @author imaciel
 * @since 23/04/2020
 * @version 0.1
 */

public enum Rotulo {

	INFO(1, "INFO"), ERROR(2, "ERROR"), FATAL(3, "FATAL"), WARN(4, "WARN");

	private int codigo;
	private String descricao;

	private Rotulo(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
