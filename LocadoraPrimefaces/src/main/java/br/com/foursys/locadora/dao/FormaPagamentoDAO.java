package br.com.foursys.locadora.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import br.com.foursys.locadora.bean.FormaPagamento;
import br.com.foursys.locadora.util.HibernateUtil;

/**
 * @author imaciel
 * @since 23/04/2020
 * @version 0.1
 */

public class FormaPagamentoDAO extends GenericDAO {

	@SuppressWarnings("unchecked")
	public ArrayList<FormaPagamento> buscarTodos() throws Exception {

		ArrayList<FormaPagamento> listaRetorno = new ArrayList<FormaPagamento>();
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = sessao.createCriteria(FormaPagamento.class);
		criteria.addOrder(Order.asc("codigo"));
		listaRetorno = (ArrayList<FormaPagamento>) criteria.list();
		sessao.close();
		return listaRetorno;
	}

}
