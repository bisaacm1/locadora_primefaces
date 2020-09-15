package br.com.foursys.locadora.teste;

import br.com.foursys.locadora.bean.Estado;
import br.com.foursys.locadora.controller.EstadoController;
import br.com.foursys.locadora.dao.EstadoDAO;

/**
 * @author imaciel
 * @since 23/04/2020
 * @version 0.1
 */

public class TesteEstado {

	public void salvar() {

		Estado estado = new Estado();
		estado.setNome("São Paulo");
		estado.setUf("SP");

		EstadoDAO dao = new EstadoDAO();
		dao.salvar(estado);

		System.out.println("Estado inserico com sucesso!");
		System.exit(0);

	}

	public void buscarTodos() {
		for (Estado estado : new EstadoController().buscarTodos()) {
			System.out.println("Codigo: " + estado.getCodigo());
			System.out.println("Telefone: " + estado.getNome());
			System.out.println("Celular: " + estado.getUf());

		}
		System.exit(0);
	}

	public static void main(String[] args) {
		new TesteEstado().buscarTodos();
	}
}
