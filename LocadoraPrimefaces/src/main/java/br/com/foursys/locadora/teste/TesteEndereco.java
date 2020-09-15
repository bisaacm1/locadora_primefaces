package br.com.foursys.locadora.teste;

import br.com.foursys.locadora.bean.Cidade;
import br.com.foursys.locadora.bean.Endereco;
import br.com.foursys.locadora.controller.EnderecoController;

/**
 * @author imaciel
 * @since 23/04/2020
 * @version 0.1
 */

public class TesteEndereco {

	public void salvar() {

		Endereco endereco = new Endereco();
		endereco.setLogradouro("Rua de Teste");
		endereco.setNumero(123);
		endereco.setComplemento(null);
		endereco.setBairro("Centro");
		endereco.setCep("12.21218.55");
		endereco.setCidadeCodigo(new Cidade(1));

		new EnderecoController().salvar(endereco);

		System.out.println("Endereco inserico com sucesso!");
		System.exit(0);

	}

	public void buscarTodos() {
		for (Endereco endereco : new EnderecoController().buscarTodos()) {
			System.out.println("Logradouro: " + endereco.getLogradouro());
			System.out.println("Numero: " + endereco.getNumero());
			System.out.println("Complemento: " + endereco.getComplemento());
			System.out.println("Bairro: " + endereco.getBairro());
			System.out.println("Cep: " + endereco.getCep());
			System.out.println("Cidade: " + endereco.getCidadeCodigo().getNome());
			System.out.println("Estado: " + endereco.getCidadeCodigo().getEstadoCodigo().getNome());

		}
		System.exit(0);
	}

	public static void main(String[] args) {
		new TesteEndereco().buscarTodos();
	}
}
