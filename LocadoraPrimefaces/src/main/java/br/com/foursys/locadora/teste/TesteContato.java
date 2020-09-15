package br.com.foursys.locadora.teste;

import br.com.foursys.locadora.bean.Contato;
import br.com.foursys.locadora.controller.ContatoController;
import br.com.foursys.locadora.dao.ContatoDAO;

/**
 * @author imaciel
 * @since 23/04/2020
 * @version 0.1
 */

public class TesteContato {

	public void salvar() {

		Contato contato = new Contato();
		contato.setCelular("(11) 946437993");
		contato.setTelefone("(11) 94555555");
		contato.setEmail("isaac@gmail.com");

		ContatoDAO dao = new ContatoDAO();
		dao.salvar(contato);

		System.out.println("Contato inserico com sucesso!");
		System.exit(0);

	}

	public void buscarTodos() {
		for (Contato contato : new ContatoController().buscarTodos()) {
			System.out.println("Codigo: " + contato.getCodigo());
			System.out.println("Telefone: " + contato.getTelefone());
			System.out.println("Celular: " + contato.getCelular());
			System.out.println("Email: " + contato.getEmail());

		}
		System.exit(0);
	}

	public static void main(String[] args) {
		new TesteContato().buscarTodos();
	}
}
