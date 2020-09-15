package br.com.foursys.locadora.teste;

import br.com.foursys.locadora.bean.Cliente;
import br.com.foursys.locadora.bean.Contato;
import br.com.foursys.locadora.bean.Endereco;
import br.com.foursys.locadora.controller.ClienteController;

/**
 * @author imaciel
 * @since 23/04/2020
 * @version 0.1
 */

public class TesteCliente {

	public void salvar() {

		Cliente cliente = new Cliente();
		cliente.setNome("Isaac");
		cliente.setCpf("239.009.058-35");
		cliente.setRg("555555555");
		cliente.setDataNascimento("28/07/2003");
		cliente.setIdade(12);
		cliente.setSexo("M");
		cliente.setEnderecoCodigo(new Endereco(1));
		cliente.setContatoCodigo(new Contato(1));

		new ClienteController().salvar(cliente);

		System.out.println("Cliente salvo com sucesso");

		System.exit(0);
	}

	public void buscarTodos() {
		for (Cliente cliente : new ClienteController().buscarTodos()) {
			System.out.println("Codigo: " + cliente.getCodigo());
			System.out.println("Nome: " + cliente.getNome());
			System.out.println("Logradouro: " + cliente.getEnderecoCodigo().getLogradouro());
			System.out.println("Numero: " + cliente.getEnderecoCodigo().getNumero());
			System.out.println("Complemento: " + cliente.getEnderecoCodigo().getComplemento());
			System.out.println("Bairro: " + cliente.getEnderecoCodigo().getBairro());
			System.out.println("Cidade: " + cliente.getEnderecoCodigo().getCidadeCodigo().getNome());
			System.out.println("Estado: " + cliente.getEnderecoCodigo().getCidadeCodigo().getEstadoCodigo().getNome());
			System.out.println("Data de Nascimento: " + cliente.getDataNascimento());
			System.out.println("Idade: " + cliente.getIdade());
			System.out.println("Cpf: " + cliente.getCpf());
			System.out.println("RG: " + cliente.getRg());
			System.out.println("Sexo: " + cliente.getSexo());
			System.out.println("Telefone: " + cliente.getContatoCodigo().getTelefone());
			System.out.println("Celular: " + cliente.getContatoCodigo().getCelular());
			System.out.println("Email: " + cliente.getContatoCodigo().getEmail());

		}
		System.exit(0);
	}

	public static void main(String[] args) {
		new TesteCliente().buscarTodos();
	}
}
