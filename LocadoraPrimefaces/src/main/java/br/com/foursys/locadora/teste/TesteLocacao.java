package br.com.foursys.locadora.teste;

import br.com.foursys.locadora.bean.Cliente;
import br.com.foursys.locadora.bean.FormaPagamento;
import br.com.foursys.locadora.bean.Funcionario;
import br.com.foursys.locadora.bean.Locacao;
import br.com.foursys.locadora.dao.LocacaoDAO;

/**
 * @author imaciel
 * @since 23/04/2020
 * @version 0.1
 */

public class TesteLocacao {

	public void salvar() {

		Locacao locacao = new Locacao();

		locacao.setDataDevolucao("04/06/2020");
		locacao.setDataLocacao("04/04/2020");
		locacao.setValor(20.5);

		locacao.setClienteCodigo(new Cliente(1));
		locacao.setFormaPagamentoCodigo(new FormaPagamento(1));
		locacao.setFuncionarioCodigo(new Funcionario(1));

		new LocacaoDAO().salvar(locacao);
		;

		System.out.println("Locacao inserido com sucesso!");
		System.exit(0);
	}

	public void buscarTodos() throws Exception {

		for (Locacao locacao : new LocacaoDAO().buscarTodos()) {
			System.out.println("--------------------------------");
			System.out.println("Código: " + locacao.getCodigo());
			System.out.println("Data de Locação: " + locacao.getDataLocacao());
			System.out.println("Data de devolução: " + locacao.getDataDevolucao());
			System.out.println("Valor: " + locacao.getValor());

			System.out.println("Nome do Cliente: " + locacao.getClienteCodigo().getNome());

			System.out.println("Forma de Pagamento: " + locacao.getFormaPagamentoCodigo().getDescricao());

			System.out.println("Nome do Funcionario: " + locacao.getFuncionarioCodigo().getNome());

		}
		System.out.println("--------------------------------");
		System.exit(0);
	}

	public static void main(String[] args) throws Exception {
		new TesteLocacao().buscarTodos();
	}

}
