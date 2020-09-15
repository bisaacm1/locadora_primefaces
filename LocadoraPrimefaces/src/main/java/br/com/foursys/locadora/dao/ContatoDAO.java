package br.com.foursys.locadora.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import br.com.foursys.locadora.bean.Contato;
import br.com.foursys.locadora.util.HibernateUtil;

/**
 * @author imaciel
 * @since 23/04/2020
 * @version 0.1
 */

public class ContatoDAO extends GenericDAO {

	@SuppressWarnings("unchecked")
	public ArrayList<Contato> buscarTodos() throws Exception {

		ArrayList<Contato> listaRetorno = new ArrayList<Contato>();
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = sessao.createCriteria(Contato.class);
		criteria.addOrder(Order.asc("codigo"));
		listaRetorno = (ArrayList<Contato>) criteria.list();
		sessao.close();
		return listaRetorno;
	}

}
