package br.com.foursys.locadora.controller;

import java.text.NumberFormat;
import java.util.ArrayList;

import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.bean.Genero;
import br.com.foursys.locadora.dao.FilmeDAO;
import br.com.foursys.locadora.dao.GeneroDAO;

/**
 * @author imaciel
 * @since 23/04/2020
 * @version 0.1
 */

public class FilmeController {

	private NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance();

	public void salvar(Filme filme) {
		FilmeDAO dao = new FilmeDAO();
		try {
			dao.salvar(filme);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Genero> carregarComboGenero() {
		ArrayList<Genero> lista = new ArrayList<Genero>();
		try {
			lista = new GeneroDAO().buscarTodos();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return lista;
	}

	public Filme buscarPorCodigo(int codigo) {
		Filme filme = new Filme();
		try {
			filme = new FilmeDAO().buscarPorCodigo(codigo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filme;
	}

	public void excluir(Filme filme) {
		FilmeDAO dao = new FilmeDAO();
		try {
			dao.excluir(filme);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Filme> buscarTodos() {
		ArrayList<Filme> listaRetorno = new ArrayList<Filme>();
		FilmeDAO dao = new FilmeDAO();

		try {
			listaRetorno = dao.buscarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}

	public ArrayList<Filme> buscarNome(String nome) {
		ArrayList<Filme> listaRetorno = new ArrayList<Filme>();
		FilmeDAO dao = new FilmeDAO();

		try {
			listaRetorno = dao.buscarNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}

	public ArrayList<Filme> buscarDisponivel() {
		ArrayList<Filme> lista = new ArrayList<Filme>();
		try {
			lista = new FilmeDAO().buscarDisponivel();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lista;
	}

	public ArrayList<Filme> buscarIndisponivel() {
		ArrayList<Filme> listaRetorno = new ArrayList<Filme>();
		FilmeDAO dao = new FilmeDAO();
		try {
			listaRetorno = dao.buscarIndisponivel();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
}
