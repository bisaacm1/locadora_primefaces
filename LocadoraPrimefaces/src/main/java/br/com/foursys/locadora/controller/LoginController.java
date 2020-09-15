package br.com.foursys.locadora.controller;

import br.com.foursys.locadora.bean.Funcionario;

/**
 * @author imaciel
 * @since 23/04/2020
 * @version 0.1
 */

public class LoginController {

	public String verificarUsuario(String login, String senha) {
		for (Funcionario funcionario : new FuncionarioController().buscaLogin(login)) {

			if (funcionario.getSenha().equals(senha)) {
				return funcionario.getNome();

			}

		}
		return "";

	}
}
