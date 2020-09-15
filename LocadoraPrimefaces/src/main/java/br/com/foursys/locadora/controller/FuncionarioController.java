package br.com.foursys.locadora.controller;

import java.util.ArrayList;

import br.com.foursys.locadora.bean.Cidade;
import br.com.foursys.locadora.bean.Estado;
import br.com.foursys.locadora.bean.Funcionario;
import br.com.foursys.locadora.dao.FuncionarioDAO;

/**
 * @author imaciel
 * @since 23/04/2020
 * @version 0.1
 */

public class FuncionarioController {

	public void salvar(Funcionario funcionario) {
		FuncionarioDAO dao = new FuncionarioDAO();
		try {
			dao.salvar(funcionario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Funcionario funcionario) {
		FuncionarioDAO dao = new FuncionarioDAO();
		try {
			dao.excluir(funcionario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Funcionario> buscarTodos() {
		ArrayList<Funcionario> listaRetorno = new ArrayList<Funcionario>();
		FuncionarioDAO dao = new FuncionarioDAO();

		try {
			listaRetorno = dao.buscarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}

	public ArrayList<Funcionario> buscarNome(String nome) {
		ArrayList<Funcionario> listaRetorno = new ArrayList<Funcionario>();
		FuncionarioDAO dao = new FuncionarioDAO();

		try {
			listaRetorno = dao.buscarNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}

	public ArrayList<Funcionario> buscarLogin(String login) {
		ArrayList<Funcionario> listaRetorno = new ArrayList<Funcionario>();
		FuncionarioDAO dao = new FuncionarioDAO();

		try {
			listaRetorno = dao.buscarNome(login);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}

	public ArrayList<Funcionario> buscaLogin(String login) {
		ArrayList<Funcionario> listaRetorno = new ArrayList<Funcionario>();
		FuncionarioDAO dao = new FuncionarioDAO();

		try {
			listaRetorno = dao.buscaLogin(login);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	
	public ArrayList<Cidade> carregarComboCidade() {
		ArrayList<Cidade> lista = new ArrayList<Cidade>();
		try {
			lista = new CidadeController().buscarTodos();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lista;
	}

	public ArrayList<Estado> carregarComboEstado() {
		ArrayList<Estado> lista = new ArrayList<Estado>();
		try {
			lista = new EstadoController().buscarTodos();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lista;
	}


}
