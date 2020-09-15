package br.com.foursys.locadora.teste;

import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.bean.Locacao;
import br.com.foursys.locadora.bean.LocacaoFilme;
import br.com.foursys.locadora.controller.LocacaoFilmeController;
import br.com.foursys.locadora.dao.LocacaoFilmeDAO;

/**
 * @author imaciel
 * @since 23/04/2020
 * @version 0.1
 */

public class TesteLocacaoFilme {

	public void salvar() {

		LocacaoFilme locacaoFilme = new LocacaoFilme();
		locacaoFilme.setFilmeCodigo(new Filme(1));
		locacaoFilme.setLocacaoCodigo(new Locacao(1));

		LocacaoFilmeDAO dao = new LocacaoFilmeDAO();
		dao.salvar(locacaoFilme);

		System.out.println("LocacaoFilme inserido com sucesso!");
		System.exit(0);
	}

	public void buscarTodos() {
		for (LocacaoFilme locacaoFilme : new LocacaoFilmeController().buscarTodos()) {
			System.out.println("Codigo da locacao: " + locacaoFilme.getLocacaoCodigo().getCodigo());
			System.out.println("Nome do Filme: " + locacaoFilme.getFilmeCodigo().getNome());
			System.out.println("Genero do filme: " + locacaoFilme.getFilmeCodigo().getGeneroCodigo().getDescricao());
			System.out.println("nome do cliente: " + locacaoFilme.getLocacaoCodigo().getClienteCodigo().getNome());
			System.out.println("data da locacao: " + locacaoFilme.getLocacaoCodigo().getDataLocacao());
			System.out.println("cidade do cliente: " + locacaoFilme.getLocacaoCodigo().getClienteCodigo()
					.getEnderecoCodigo().getCidadeCodigo().getNome());
			System.out.println("telefone do cliente: "
					+ locacaoFilme.getLocacaoCodigo().getClienteCodigo().getContatoCodigo().getTelefone());
			System.out.println("celulcar do cliente: "
					+ locacaoFilme.getLocacaoCodigo().getClienteCodigo().getContatoCodigo().getCelular());
			System.out.println("funcionario: " + locacaoFilme.getLocacaoCodigo().getFuncionarioCodigo().getNome());
			System.out.println(
					"Forma de pagamento: " + locacaoFilme.getLocacaoCodigo().getFormaPagamentoCodigo().getDescricao());

		}
		System.exit(0);
	}

	public static void main(String[] args) {
		new TesteLocacaoFilme().buscarTodos();
	}
}
