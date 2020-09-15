package br.com.foursys.locadora.controller;

import java.util.ArrayList;

import br.com.foursys.locadora.bean.Cliente;
import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.bean.FormaPagamento;
import br.com.foursys.locadora.bean.Funcionario;
import br.com.foursys.locadora.bean.Locacao;
import br.com.foursys.locadora.dao.ClienteDAO;
import br.com.foursys.locadora.dao.FilmeDAO;
import br.com.foursys.locadora.dao.FormaPagamentoDAO;
import br.com.foursys.locadora.dao.FuncionarioDAO;
import br.com.foursys.locadora.dao.LocacaoDAO;

/**
 * @author imaciel
 * @since 23/04/2020
 * @version 0.1
 */

public class LocacaoController {

	public void salvar(Locacao locacao) {
		LocacaoDAO dao = new LocacaoDAO();
		try {
			dao.salvar(locacao);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Locacao locacao) {
		LocacaoDAO dao = new LocacaoDAO();
		try {
			dao.excluir(locacao);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Locacao> buscarTodos() {
		ArrayList<Locacao> listaRetorno = new ArrayList<Locacao>();
		LocacaoDAO dao = new LocacaoDAO();

		try {
			listaRetorno = dao.buscarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}

	public ArrayList<Locacao> buscarNome(String nome) {
		ArrayList<Locacao> listaRetorno = new ArrayList<Locacao>();
		LocacaoDAO dao = new LocacaoDAO();

		try {
			listaRetorno = dao.buscarNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}

	public ArrayList<Locacao> buscarNaoDevolvido() {
		ArrayList<Locacao> listaRetorno = new ArrayList<Locacao>();
		LocacaoDAO dao = new LocacaoDAO();

		try {
			listaRetorno = dao.buscarNaoDevolvido();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}

	public ArrayList<Locacao> buscarSimDevolvido() {
		ArrayList<Locacao> listaRetorno = new ArrayList<Locacao>();
		LocacaoDAO dao = new LocacaoDAO();

		try {
			listaRetorno = dao.buscarSimDevolvido();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}

	public ArrayList<Cliente> carregarComboCliente() {
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		try {
			lista = new ClienteDAO().buscarTodos();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lista;
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

	public ArrayList<FormaPagamento> carregarComboFormaPagamento() {
		ArrayList<FormaPagamento> lista = new ArrayList<FormaPagamento>();
		try {
			lista = new FormaPagamentoDAO().buscarTodos();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lista;
	}

	public ArrayList<Funcionario> carregarComboFuncionario() {
		ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
		try {
			lista = new FuncionarioDAO().buscarTodos();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lista;
	}

}
