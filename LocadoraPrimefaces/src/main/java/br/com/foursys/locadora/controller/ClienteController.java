package br.com.foursys.locadora.controller;

import java.util.ArrayList;

import br.com.foursys.locadora.bean.Cidade;
import br.com.foursys.locadora.bean.Cliente;
import br.com.foursys.locadora.bean.Estado;
import br.com.foursys.locadora.dao.ClienteDAO;

/**
 * @author imaciel
 * @since 23/04/2020
 * @version 0.1
 */

public class ClienteController {

	public void salvar(Cliente cliente) {
		ClienteDAO dao = new ClienteDAO();
		try {
			dao.salvar(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Cliente cliente) {
		ClienteDAO dao = new ClienteDAO();
		try {
			dao.excluir(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Cliente> buscarTodos() {
		ArrayList<Cliente> listaRetorno = new ArrayList<Cliente>();
		ClienteDAO dao = new ClienteDAO();

		try {
			listaRetorno = dao.buscarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}

	public ArrayList<Cliente> buscarNome(String nome) {
		ArrayList<Cliente> listaRetorno = new ArrayList<Cliente>();
		ClienteDAO dao = new ClienteDAO();

		try {
			listaRetorno = dao.buscarNome(nome);
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
