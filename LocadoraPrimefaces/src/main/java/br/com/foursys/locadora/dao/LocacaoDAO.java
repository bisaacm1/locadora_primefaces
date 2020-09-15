package br.com.foursys.locadora.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.bean.Locacao;
import br.com.foursys.locadora.util.HibernateUtil;

/**
 * @author imaciel
 * @since 23/04/2020
 * @version 0.1
 */

public class LocacaoDAO extends GenericDAO {

	@SuppressWarnings("unchecked")
	public ArrayList<Locacao> buscarTodos() throws Exception {

		ArrayList<Locacao> listaRetorno = new ArrayList<Locacao>();
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = sessao.createCriteria(Locacao.class);
		criteria.addOrder(Order.asc("codigo"));
		listaRetorno = (ArrayList<Locacao>) criteria.list();
		sessao.close();
		return listaRetorno;
	}

	public ArrayList<Locacao> buscarNome(String nome) throws Exception {

		ArrayList<Locacao> listaRetorno = new ArrayList<Locacao>();
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = sessao.createCriteria(Locacao.class);
		criteria.add(Restrictions.ilike("nome", nome + "%"));
		criteria.addOrder(Order.asc("nome"));
		listaRetorno = (ArrayList<Locacao>) criteria.list();
		sessao.close();
		return listaRetorno;
	}

	public Locacao buscarPorCodigo(int codigo) throws Exception {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Locacao locacao = (Locacao) sessao.get(Locacao.class, codigo);
		sessao.close();
		return locacao;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Locacao> buscarNaoDevolvido() throws Exception {

		ArrayList<Locacao> listaRetorno = new ArrayList<Locacao>();
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = sessao.createCriteria(Locacao.class);
		criteria.add(Restrictions.ilike("devolvido", "NÃO"));
		criteria.addOrder(Order.asc("codigo"));
		listaRetorno = (ArrayList<Locacao>) criteria.list();

		return listaRetorno;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Locacao> buscarSimDevolvido() throws Exception {

		ArrayList<Locacao> listaRetorno = new ArrayList<Locacao>();
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = sessao.createCriteria(Locacao.class);
		criteria.add(Restrictions.ilike("devolvido", "SIM"));
		criteria.addOrder(Order.asc("codigo"));
		listaRetorno = (ArrayList<Locacao>) criteria.list();

		return listaRetorno;
	}
}
