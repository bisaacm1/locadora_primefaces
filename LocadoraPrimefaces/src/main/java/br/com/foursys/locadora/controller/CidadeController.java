package br.com.foursys.locadora.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.foursys.locadora.bean.Cidade;
import br.com.foursys.locadora.dao.CidadeDAO;

/**
 * @author imaciel
 * @since 23/04/2020
 * @version 0.1
 */

@ManagedBean(name = "cidadeController")
@ViewScoped
public class CidadeController {

	public void salvar(Cidade cidade) {
		CidadeDAO dao = new CidadeDAO();
		try {
			dao.salvar(cidade);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Cidade cidade) {
		CidadeDAO dao = new CidadeDAO();
		try {
			dao.excluir(cidade);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Cidade> buscarTodos() {
		ArrayList<Cidade> listaRetorno = new ArrayList<Cidade>();
		CidadeDAO dao = new CidadeDAO();

		try {
			listaRetorno = dao.buscarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}

	public ArrayList<Cidade> buscarNome(String nome) {
		ArrayList<Cidade> listaRetorno = new ArrayList<Cidade>();
		CidadeDAO dao = new CidadeDAO();

		try {
			listaRetorno = dao.buscarNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}

}
