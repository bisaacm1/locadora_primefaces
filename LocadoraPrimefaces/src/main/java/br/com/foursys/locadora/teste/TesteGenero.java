package br.com.foursys.locadora.teste;

import br.com.foursys.locadora.bean.Genero;
import br.com.foursys.locadora.controller.GeneroController;

/**
 * @author imaciel
 * @since 23/04/2020
 * @version 0.1
 */

public class TesteGenero {

	public void buscarTodos() {
		for (Genero genero : new GeneroController().buscarTodos()) {
			System.out.println("Codigo: " + genero.getCodigo());
			System.out.println("Codigo: " + genero.getDescricao());

		}
		System.exit(0);
	}

	public static void main(String[] args) {
		new TesteGenero().buscarTodos();
	}
}
