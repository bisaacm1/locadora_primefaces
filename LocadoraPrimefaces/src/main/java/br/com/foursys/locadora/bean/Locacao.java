/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foursys.locadora.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author imaciel
 * @since 23/04/2020
 * @version 0.1
 */
@Entity
@Table(name = "locacao")
@NamedQueries({ @NamedQuery(name = "Locacao.findAll", query = "SELECT l FROM Locacao l"),
		@NamedQuery(name = "Locacao.findByCodigo", query = "SELECT l FROM Locacao l WHERE l.codigo = :codigo"),
		@NamedQuery(name = "Locacao.findByDataDevolucao", query = "SELECT l FROM Locacao l WHERE l.dataDevolucao = :dataDevolucao"),
		@NamedQuery(name = "Locacao.findByDataLocacao", query = "SELECT l FROM Locacao l WHERE l.dataLocacao = :dataLocacao"),
		@NamedQuery(name = "Locacao.findByValor", query = "SELECT l FROM Locacao l WHERE l.valor = :valor"),
		@NamedQuery(name = "Locacao.findByDevolvido", query = "SELECT l FROM Locacao l WHERE l.devolvido = :devolvido") })
public class Locacao implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "codigo")
	private Integer codigo;
	@Column(name = "data_devolucao")
	private String dataDevolucao;
	@Column(name = "data_locacao")
	private String dataLocacao;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "valor")
	private Double valor;
	@Column(name = "devolvido")
	private String devolvido;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "locacaoCodigo")
	private List<LocacaoFilme> locacaoFilmeList;
	@JoinColumn(name = "forma_pagamento_codigo", referencedColumnName = "codigo")
	@ManyToOne(optional = false)
	private FormaPagamento formaPagamentoCodigo;
	@JoinColumn(name = "cliente_codigo", referencedColumnName = "codigo")
	@ManyToOne(optional = false)
	private Cliente clienteCodigo;
	@JoinColumn(name = "funcionario_codigo", referencedColumnName = "codigo")
	@ManyToOne(optional = false)
	private Funcionario funcionarioCodigo;

	public Locacao() {
	}

	public Locacao(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public String getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(String dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDevolvido() {
		return devolvido;
	}

	public void setDevolvido(String devolvido) {
		this.devolvido = devolvido;
	}

	public List<LocacaoFilme> getLocacaoFilmeList() {
		return locacaoFilmeList;
	}

	public void setLocacaoFilmeList(List<LocacaoFilme> locacaoFilmeList) {
		this.locacaoFilmeList = locacaoFilmeList;
	}

	public FormaPagamento getFormaPagamentoCodigo() {
		return formaPagamentoCodigo;
	}

	public void setFormaPagamentoCodigo(FormaPagamento formaPagamentoCodigo) {
		this.formaPagamentoCodigo = formaPagamentoCodigo;
	}

	public Cliente getClienteCodigo() {
		return clienteCodigo;
	}

	public void setClienteCodigo(Cliente clienteCodigo) {
		this.clienteCodigo = clienteCodigo;
	}

	public Funcionario getFuncionarioCodigo() {
		return funcionarioCodigo;
	}

	public void setFuncionarioCodigo(Funcionario funcionarioCodigo) {
		this.funcionarioCodigo = funcionarioCodigo;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (codigo != null ? codigo.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Locacao)) {
			return false;
		}
		Locacao other = (Locacao) object;
		if ((this.codigo == null && other.codigo != null)
				|| (this.codigo != null && !this.codigo.equals(other.codigo))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "jurema1.Locacao[ codigo=" + codigo + " ]";
	}

}
