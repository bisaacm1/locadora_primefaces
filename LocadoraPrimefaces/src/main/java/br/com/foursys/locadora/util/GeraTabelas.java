package br.com.foursys.locadora.util;

/**
 * @author imaciel
 * @since 23/04/2020
 * @version 0.1
 */

public class GeraTabelas {

	public static void main(String[] args) {
		HibernateUtil.getSessionFactory().openSession();
		System.out.println("Tabela criada com sucesso!");
		System.exit(0);
	}

}
