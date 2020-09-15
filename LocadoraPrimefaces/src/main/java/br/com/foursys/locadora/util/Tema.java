package br.com.foursys.locadora.util;

/**
 * @author imaciel
 * @since 23/04/2020
 * @version 0.1
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Tema {

	private String tema = "pepper-grinder";

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

}
