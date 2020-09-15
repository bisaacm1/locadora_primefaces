
package br.com.foursys.locadora.teste;

import br.com.foursys.locadora.bean.Contato;
import br.com.foursys.locadora.bean.Endereco;
import br.com.foursys.locadora.bean.Funcionario;
import br.com.foursys.locadora.controller.FuncionarioController;

/**
 * @author imaciel
 * @since 23/04/2020
 * @version 0.1
 */

public class TesteFuncionario {

	public void salvar() {
		Funcionario funcionario = new Funcionario();

		funcionario.setNome("Claudio");
		funcionario.setCpf("489.137.598-10");
		funcionario.setRg("50.718.938-3");
		funcionario.setDataNascimento("11/01/1999");
		funcionario.setIdade(21);
		funcionario.setSexo("M");
		funcionario.setEnderecoCodigo(new Endereco(1));
		funcionario.setContatoCodigo(new Contato(1));
		funcionario.setLogin("csleite");
		funcionario.setSenha("123");

		new FuncionarioController().salvar(funcionario);

		System.out.println("Funcionario salvo com sucesso");

		System.exit(0);

	}

	public void buscarTodos() {
		for (Funcionario funcionario : new FuncionarioController().buscarTodos()) {
			System.out.println("Codigo: " + funcionario.getCodigo());
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Lografouro: " + funcionario.getEnderecoCodigo().getLogradouro());
			System.out.println("Numero: " + funcionario.getEnderecoCodigo().getNumero());
			System.out.println("Complemento: " + funcionario.getEnderecoCodigo().getComplemento());
			System.out.println("Bairro: " + funcionario.getEnderecoCodigo().getBairro());
			System.out.println("Cidade: " + funcionario.getEnderecoCodigo().getCidadeCodigo().getNome());
			System.out
					.println("Estado: " + funcionario.getEnderecoCodigo().getCidadeCodigo().getEstadoCodigo().getNome()
							+ "-" + funcionario.getEnderecoCodigo().getCidadeCodigo().getEstadoCodigo().getUf());
			System.out.println("Cpf: " + funcionario.getCpf());
			System.out.println("Rg: " + funcionario.getRg());
			System.out.println("Data Nascimento: " + funcionario.getDataNascimento());
			System.out.println("Idade: " + funcionario.getIdade());
			System.out.println("Sexo: " + funcionario.getSexo());
			System.out.println("Telefone: " + funcionario.getContatoCodigo().getTelefone());
			System.out.println("Celular: " + funcionario.getContatoCodigo().getCelular());
			System.out.println("Email: " + funcionario.getContatoCodigo().getEmail());
			System.out.println("Login: " + funcionario.getLogin());
			System.out.println("Senha: " + funcionario.getSenha());
		}
	}

	public static void main(String[] args) {
		new TesteFuncionario().buscarTodos();
	}

}
