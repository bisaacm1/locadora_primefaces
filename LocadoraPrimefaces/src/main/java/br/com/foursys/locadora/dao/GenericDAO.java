package br.com.foursys.locadora.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.foursys.locadora.util.HibernateUtil;

/**
 * @author imaciel
 * @since 23/04/2020
 * @version 0.1
 */

public abstract class GenericDAO {

	@SuppressWarnings("finally")
	public void salvar(Object object) {
		Session sessao = null;
		Transaction transacao = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();

			sessao.saveOrUpdate(object);
			transacao.commit();
		} catch (Exception e) {
			transacao.rollback();
			sessao.close();
		} finally {
			sessao.close();
		}

	}

	public void excluir(Object object) {
		Session sessao = null;
		Transaction transacao = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(object);
			transacao.commit();
		} catch (Exception e) {
			transacao.rollback();
			sessao.close();
		} finally {
			sessao.close();
		}

	}

}
