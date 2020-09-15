package br.com.foursys.locadora.teste;

import br.com.foursys.locadora.bean.Cidade;
import br.com.foursys.locadora.controller.CidadeController;

/**
 * @author imaciel
 * @since 23/04/2020
 * @version 0.1
 */

public class TesteCidade {

	public void buscarTodos() {
		for (Cidade cidade : new CidadeController().buscarTodos()) {
			System.out.println("Codigo: " + cidade.getCodigo());
			System.out.println("Telefone: " + cidade.getNome());
			System.out.println("Celular: " + cidade.getEstadoCodigo().getUf());

		}
		System.exit(0);
	}

	public static void main(String[] args) {
		new TesteCidade().buscarTodos();
	}

}
