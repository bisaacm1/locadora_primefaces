package br.com.foursys.locadora.backingbean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.foursys.locadora.controller.LoginController;
import br.com.foursys.locadora.util.JSFUtil;
import br.com.foursys.locadora.util.Mensagem;
import br.com.foursys.locadora.util.Rotulo;

/**
 * @author imaciel
 * @since 23/04/2020
 * @version 0.1
 */

@ManagedBean(name = "loginBacking")
@SessionScoped
public class LoginBacking implements Serializable {
	private static final long serialVersionUID = 1L;

	private String login;
	private String senha;
	private String usuarioLogado;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(String usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public void efetuarLogin() {
		try {

			// verificar senha e login com bancco de dados

//			ArrayList<Funcionario> listaFuncionario = new FuncionarioController().buscaLogin(login);
			usuarioLogado = new LoginController().verificarUsuario(login, senha);
			if (!usuarioLogado.equals("")) {

				FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");

			} else {
				JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.problemasNoLogin,
						Mensagem.credenciaisIncalidas);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String retornaUsuarioLogado() {
		return getUsuarioLogado();
	}
}