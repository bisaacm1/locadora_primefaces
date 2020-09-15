package br.com.foursys.locadora.backingbean;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import br.com.foursys.locadora.bean.Cliente;
import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.bean.FormaPagamento;
import br.com.foursys.locadora.bean.Funcionario;
import br.com.foursys.locadora.bean.Locacao;
import br.com.foursys.locadora.bean.LocacaoFilme;
import br.com.foursys.locadora.controller.ClienteController;
import br.com.foursys.locadora.controller.FilmeController;
import br.com.foursys.locadora.controller.FormaPagamentoController;
import br.com.foursys.locadora.controller.FuncionarioController;
import br.com.foursys.locadora.controller.LocacaoController;
import br.com.foursys.locadora.controller.LocacaoFilmeController;
import br.com.foursys.locadora.dao.ClienteDAO;
import br.com.foursys.locadora.dao.FilmeDAO;
import br.com.foursys.locadora.dao.FormaPagamentoDAO;
import br.com.foursys.locadora.dao.FuncionarioDAO;
import br.com.foursys.locadora.util.Data;
import br.com.foursys.locadora.util.JSFUtil;
import br.com.foursys.locadora.util.Mensagem;
import br.com.foursys.locadora.util.Rotulo;
import br.com.foursys.locadora.util.Valida;

/**
 * @author imaciel
 * @since 23/04/2020
 * @version 0.1
 */

@ManagedBean(name = "locacaoBacking")
@SessionScoped
public class LocacaoBacking implements Serializable {
	private static final long serialVersionUID = 1L;

	private String pesquisaNome = "";
	private String codigo;
	private Date dataLocacao;
	private Date dataDevolucao;
	private double valor;
	private String cliente;
	private String filme;
	private String formaPagamento;
	private String funcionario;

	private Locacao locacaoUpdate;
	private boolean alterar = false;

	private String codigoLocacao;
	private Filme filme1;

	private Locacao locacao = new Locacao();
	private Locacao locacaoSelecionado = new Locacao();
	private List<SelectItem> itensLocacaos;
	static List<Locacao> listaLocacao = new ArrayList<Locacao>();
	private int i = 0;
	private ArrayList<LocacaoFilme> listaLocacaoFilmes;

	private ArrayList<Locacao> listaLocacaos;
	private ArrayList<Locacao> listaLocacaos2;
	private ArrayList<Locacao> listaLocacaos1;
	private ArrayList<Cliente> listaClientes;
	private ArrayList<Filme> listaFilmes;
	Filme filme3 = new Filme();
	private Filme filme4;

	private List<String> filmes = new ArrayList<String>();

	private ArrayList<Funcionario> listaFuncionarios;
	private ArrayList<FormaPagamento> listaFormaPagamentos;

	
	
	public ArrayList<Locacao> getListaLocacaos2() {
		return listaLocacaos2;
	}

	public void setListaLocacaos2(ArrayList<Locacao> listaLocacaos2) {
		this.listaLocacaos2 = listaLocacaos2;
	}

	public Locacao getLocacaoUpdate() {
		return locacaoUpdate;
	}

	public ArrayList<Locacao> getListaLocacaos1() {
		return listaLocacaos1;
	}

	public void setListaLocacaos1(ArrayList<Locacao> listaLocacaos1) {
		this.listaLocacaos1 = listaLocacaos1;
	}

	public void setLocacaoUpdate(Locacao locacaoUpdate) {
		this.locacaoUpdate = locacaoUpdate;
	}

	public boolean isAlterar() {
		return alterar;
	}

	public void setAlterar(boolean alterar) {
		this.alterar = alterar;
	}

	public List<String> getFilmes() {
		return filmes;
	}

	public String getCodigoLocacao() {
		return codigoLocacao;
	}

	public void setCodigoLocacao(String codigoLocacao) {
		this.codigoLocacao = codigoLocacao;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public ArrayList<LocacaoFilme> getListaLocacaoFilmes() {
		return listaLocacaoFilmes;
	}

	public void setListaLocacaoFilmes(ArrayList<LocacaoFilme> listaLocacaoFilmes) {
		this.listaLocacaoFilmes = listaLocacaoFilmes;
	}

	public Filme getFilme3() {
		return filme3;
	}

	public void setFilme3(Filme filme3) {
		this.filme3 = filme3;
	}

	public Filme getFilme4() {
		return filme4;
	}

	public void setFilme4(Filme filme4) {
		this.filme4 = filme4;
	}

	public void setFilmes(List<String> filmes) {
		this.filmes = filmes;
	}

	public ArrayList<FormaPagamento> getListaFormaPagamentos() {
		return listaFormaPagamentos;
	}

	public void setListaFormaPagamentos(ArrayList<FormaPagamento> listaFormaPagamentos) {
		this.listaFormaPagamentos = listaFormaPagamentos;
	}

	public ArrayList<Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}

	public void setListaFuncionarios(ArrayList<Funcionario> listaFuncionarios) {
		this.listaFuncionarios = listaFuncionarios;
	}

	public String getFilme() {
		return filme;
	}

	public void setFilme(String filme) {
		this.filme = filme;
	}

	public String getPesquisaNome() {
		return pesquisaNome;
	}

	public void setPesquisaNome(String pesquisaNome) {
		this.pesquisaNome = pesquisaNome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(Date dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Filme getFilme1() {
		return filme1;
	}

	public void setFilme1(Filme filme1) {
		this.filme1 = filme1;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}

	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}

	public Locacao getLocacaoSelecionado() {
		return locacaoSelecionado;
	}

	public void setLocacaoSelecionado(Locacao locacaoSelecionado) {
		this.locacaoSelecionado = locacaoSelecionado;
	}

	public List<SelectItem> getItensLocacaos() {
		return itensLocacaos;
	}

	public void setItensLocacaos(List<SelectItem> itensLocacaos) {
		this.itensLocacaos = itensLocacaos;
	}

	public static List<Locacao> getListaLocacao() {
		return listaLocacao;
	}

	public static void setListaLocacao(List<Locacao> listaLocacao) {
		LocacaoBacking.listaLocacao = listaLocacao;
	}

	public ArrayList<Locacao> getListaLocacaos() {
		return listaLocacaos;
	}

	public void setListaLocacaos(ArrayList<Locacao> listaLocacaos) {
		this.listaLocacaos = listaLocacaos;
	}

	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public ArrayList<Filme> getListaFilmes() {
		return listaFilmes;
	}

	public void setListaFilmes(ArrayList<Filme> listaFilmes) {
		this.listaFilmes = listaFilmes;
	}

//	public ArrayList<Locacao> pesquisarLocacao() {
//
//		return new LocacaoController().buscarNome(pesquisaNome);
//	}

	public void limparDados() {
		dataDevolucao = null;
		dataLocacao = null;
		valor = 0;
		cliente = null;
		formaPagamento = null;
		funcionario = null;
		filme = null;
		filmes = null;

	}

	public String salvar() {
		if (alterar) {

			if (validarAlterar()) {
				// procedimentos para salvar utilizando update
				alterar = false;
				new ClienteController().salvar(locacaoUpdate.getClienteCodigo());
				new FormaPagamentoController().salvar(locacaoUpdate.getFormaPagamentoCodigo());
				new FuncionarioController().salvar(locacaoUpdate.getFuncionarioCodigo());
				new LocacaoController().salvar(locacaoUpdate);
				JSFUtil.addInfoMessage("INFO", Mensagem.sucesso, Mensagem.locacaoAlteradoComSucesso);

				locacaoUpdate = null;
				return "consultarLocacao";
			}

		} else {
			if (validarCampos()) {
				new Filme();
				Locacao locacao = new Locacao();

				locacao.setDataDevolucao(Data.formataData(dataDevolucao));
				locacao.setDataLocacao(Data.data);
				locacao.setValor(valor);
				locacao.setClienteCodigo(new Cliente(Integer.parseInt(cliente)));
				locacao.setFormaPagamentoCodigo(new FormaPagamento(Integer.parseInt(formaPagamento)));
				locacao.setFuncionarioCodigo(new Funcionario(Integer.parseInt(funcionario)));
				filme3.setDisponivel("NÃO");
				locacao.setDevolvido("NÃO");
				LocacaoController controller = new LocacaoController();
				try {
					new LocacaoController().salvar(locacao);
					for (String string : filmes) {
						for (Filme filme : listaFilmes) {
							if (string.equals(filme.getCodigo() + "")) {
								filme.setDisponivel("NÃO");
								new FilmeController().salvar(filme);
								LocacaoFilme locacaoFilme = new LocacaoFilme();
								locacaoFilme.setFilmeCodigo(filme);
								locacaoFilme.setLocacaoCodigo(locacao);
								new LocacaoFilmeController().salvar(locacaoFilme);
//								listaLocacaos.clear();
							}
						}
					}
					JSFUtil.addInfoMessage(Rotulo.INFO.getDescricao(), Mensagem.locacaoInseridoComSucesso,
							Mensagem.locacaoInseridoComSucesso);

				} catch (Exception e) {
					JSFUtil.addInfoMessage("ERROR", Mensagem.erro, Mensagem.ErroAoInserirLocacao);
				}
				limparDados();
				carregarCombos();
			}
		}
		return "";
	}

	public void atualizarValorTotal() {
		valor = 0;
		double auxSoma = 0.0;
		for (String string : filmes) {
			for (Filme filme : listaFilmes) {
				if (string.equals(filme.getCodigo() + "")) {
					if (filme.getPromocao().equals("SIM")) {
						auxSoma = auxSoma + filme.getValorPromocao();
					} else {
						auxSoma = auxSoma + filme.getValor();
					}
				}
			}
		}

		valor = auxSoma;
	}

	public void init() {
		listaClientes = new LocacaoController().carregarComboCliente();
		listaFilmes = new LocacaoController().buscarDisponivel();
		listaFuncionarios = new LocacaoController().carregarComboFuncionario();
		listaFormaPagamentos = new LocacaoController().carregarComboFormaPagamento();
		listaLocacaos = new LocacaoController().buscarNaoDevolvido();
		listaLocacaos1 = new LocacaoController().buscarSimDevolvido();
		listaLocacaos2 = new LocacaoController().buscarTodos();
	}

	public void carregarCombos() {
		listaClientes = new LocacaoController().carregarComboCliente();
		listaFilmes = new LocacaoController().buscarDisponivel();
		listaFuncionarios = new LocacaoController().carregarComboFuncionario();
		listaFormaPagamentos = new LocacaoController().carregarComboFormaPagamento();
		listaLocacaos = new LocacaoController().buscarNaoDevolvido();
		listaLocacaos1 = new LocacaoController().buscarSimDevolvido();
	}

	public String sairTeste() {

		return "index.xhtml";

	}

	public static String formataData(Date data) {
		if (data == null)
			return "";
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = format.format(data);

		return dataFormatada;

	}

	public boolean validarCampos() {

		if (Valida.validaListaVazia(filmes)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeFilme);
			return false;
		}

		if (Valida.verificaVazio(formaPagamento)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio,
					Mensagem.informeFormaPagamento);
			return false;
		}

		if (Valida.verificaVazio(cliente)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informecliente);
			return false;
		}
		if (Valida.verificaVazio(funcionario)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeFuncionaio);
			return false;
		}

//		if (Valida.verificaVazio12(dataDevolucao)) {
//			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio,
//					Mensagem.informeDataDevolucao);
//			return false;
//		}

		if (Valida.verificaVazio(formataData(dataDevolucao))) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio,
					Mensagem.informeDataDevolucao);
			return false;
		}

		return true;
	}

	public boolean validarAlterar() {

//		if (Valida.validaListaVazia(filmes)) {
//			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeFilme);
//			return false;
//		}
//
//		if (Valida.verificaVazio(formaPagamento)) {
//			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio,
//					Mensagem.informeFormaPagamento);
//			return false;
//		}
//
//		if (Valida.verificaVazio(cliente)) {
//			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informecliente);
//			return false;
//		}
//		if (Valida.verificaVazio(funcionario)) {
//			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeFuncionaio);
//			return false;
//		}
//
//		if (Valida.verificaVazio12(dataDevolucao)) {
//			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio,
//					Mensagem.informeDataDevolucao);
//			return false;
//		}

		return true;
	}

	public String popularCliente(ValueChangeEvent e) {
		cliente = e.getNewValue().toString();
		return "";
	}

	public String dataAtual() {
		return Data.data;
	}

	public void devolverLocacao() {
		if (validarCamposDevolvido()) {
			Locacao locacao = new Locacao();
			listaLocacaoFilmes = new LocacaoFilmeController().buscarTodos();

			locacao.setCodigo(Integer.parseInt(codigoLocacao));

			for (LocacaoFilme locacaoFilme : listaLocacaoFilmes) {
				if (locacaoFilme.getLocacaoCodigo().getCodigo().equals(locacao.getCodigo())) {
					locacao.setValor(locacaoFilme.getLocacaoCodigo().getValor());
					locacao.setDevolvido("SIM");
					locacao.setClienteCodigo(locacaoFilme.getLocacaoCodigo().getClienteCodigo());
					locacao.setFuncionarioCodigo(locacaoFilme.getLocacaoCodigo().getFuncionarioCodigo());
					locacao.setFormaPagamentoCodigo(locacaoFilme.getLocacaoCodigo().getFormaPagamentoCodigo());
					locacao.setDataDevolucao(Data.data);
					locacao.setDataLocacao(locacaoFilme.getLocacaoCodigo().getDataLocacao());
					listaLocacaos.clear();
					new LocacaoController().salvar(locacao);
					Filme filme = new FilmeController().buscarPorCodigo(locacaoFilme.getFilmeCodigo().getCodigo());
					filme.setDisponivel("SIM");

					try {
						new FilmeController().salvar(filme);
						JSFUtil.addInfoMessage(Rotulo.INFO.getDescricao(), Mensagem.sucesso,
								Mensagem.devolucaoInseridoComSucesso);
					} catch (Exception e) {
						JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.erro,
								Mensagem.ErroAoInserrirDevolucao);
					}

					limparCamposDevolucao();
					carregarCombos();
				}

			}
		}
	}

	public void limparCamposDevolucao() {
		codigo = null;
	}

	public boolean validarCamposDevolvido() {
		if (Valida.verificaVazio(codigoLocacao)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.selecioneDevolvido);
			return false;
		}

		return true;
	}

	public String telaConsulta() {
		JSFUtil.addInfoMessage(Rotulo.INFO.getDescricao(), Mensagem.sucesso, Mensagem.locacaoAlteradoComSucesso);
		return "consultarLocacao";

	}

	public String alterar() {
		alterar = true;
		return "alterarLocacao";
	}

	public String excluir() {
		listaLocacaos.remove(locacaoUpdate);
		new ClienteController().excluir(locacaoUpdate.getClienteCodigo());
		new FuncionarioController().excluir(locacaoUpdate.getFuncionarioCodigo());
		new FormaPagamentoController().excluir(locacaoUpdate.getFormaPagamentoCodigo());

		JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio,
				Mensagem.locacaoExcluidoComSucesso);
		locacaoUpdate = null;

		return "";
	}

}
