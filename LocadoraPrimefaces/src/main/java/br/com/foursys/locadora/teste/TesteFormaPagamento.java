package br.com.foursys.locadora.teste;

import br.com.foursys.locadora.bean.FormaPagamento;
import br.com.foursys.locadora.controller.FormaPagamentoController;

/**
 * @author imaciel
 * @since 23/04/2020
 * @version 0.1
 */

public class TesteFormaPagamento {

	public void buscarTodos() {
		for (FormaPagamento formaPagamento : new FormaPagamentoController().buscarTodos()) {
			System.out.println("Codigo: " + formaPagamento.getCodigo());
			System.out.println("Descrição: " + formaPagamento.getDescricao());

		}
		System.exit(0);
	}

	public static void main(String[] args) {
		new TesteFormaPagamento().buscarTodos();
	}
}
