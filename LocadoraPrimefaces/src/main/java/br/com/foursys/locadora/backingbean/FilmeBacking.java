package br.com.foursys.locadora.backingbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.bean.Genero;
import br.com.foursys.locadora.controller.FilmeController;
import br.com.foursys.locadora.controller.GeneroController;
import br.com.foursys.locadora.dao.GeneroDAO;
import br.com.foursys.locadora.util.JSFUtil;
import br.com.foursys.locadora.util.Mensagem;
import br.com.foursys.locadora.util.Rotulo;
import br.com.foursys.locadora.util.Valida;

@ManagedBean(name = "filmeBacking")
@SessionScoped
public class FilmeBacking implements Serializable {
	private static final long serialVersionUID = 1L;

	private String pesquisaNome = "";
	private String codigo;
	private String nome;
	private String valor;
	private String disponivel;
	private String promocao;
	private String valorPromocao;
	private String genero;

	private Filme filmeUpdate;

	private boolean alterar = false;

	private Filme filme = new Filme();
	private Filme filmeSelecionado = new Filme();
	private List<SelectItem> itensFilmes;
	static List<Filme> listaFilme = new ArrayList<Filme>();

	private ArrayList<Filme> listaFilmes;
	private ArrayList<Genero> listaGeneros;

	public ArrayList<Genero> getListaGeneros() {
		return listaGeneros;
	}

	public ArrayList<Filme> getListaFilmes() {
		return listaFilmes;
	}

	public void setListaFilmes(ArrayList<Filme> listaFilmes) {
		this.listaFilmes = listaFilmes;
	}

	public void setListaGeneros(ArrayList<Genero> listaGeneros) {
		this.listaGeneros = listaGeneros;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(String disponivel) {
		this.disponivel = disponivel;
	}

	public String getPromocao() {
		return promocao;
	}

	public void setPromocao(String promocao) {
		this.promocao = promocao;
	}

	public String getValorPromocao() {
		return valorPromocao;
	}

	public void setValorPromocao(String valorPromocao) {
		this.valorPromocao = valorPromocao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Filme getFilmeSelecionado() {
		return filmeSelecionado;
	}

	public void setFilmeSelecionado(Filme filmeSelecionado) {
		this.filmeSelecionado = filmeSelecionado;
	}

	public List<SelectItem> getItensFilmes() {
		return itensFilmes;
	}

	public void setItensFilmes(List<SelectItem> itensFilmes) {
		this.itensFilmes = itensFilmes;
	}

	public Filme getFilmeUpdate() {
		return filmeUpdate;
	}

	public void setFilmeUpdate(Filme filmeUpdate) {
		this.filmeUpdate = filmeUpdate;
	}

	public String getPesquisaNome() {
		return pesquisaNome;
	}

	public void setPesquisaNome(String pesquisaNome) {
		this.pesquisaNome = pesquisaNome;
	}

	public ArrayList<Filme> preencherTabela() {
		return new FilmeController().buscarTodos();
	}

	public void pesquisar() {
		listaFilmes = pesquisarFilme();
	}

	public ArrayList<Filme> pesquisarFilme() {
		return new FilmeController().buscarNome(pesquisaNome);
	}

	public String salvar() {
		if (alterar) {

			if (validarAlterar()) {
				// procedimentos para salvar utilizando update
				alterar = false;
				new FilmeController().salvar(filmeUpdate);
				telaConsulta();

				JSFUtil.addInfoMessage(Rotulo.INFO.getDescricao(), Mensagem.sucesso, Mensagem.filmeAlteradoComSucesso);

				filmeUpdate = null;
				return "consultarFilme";
			}

		} else {

			if (validarIncluir()) {
				Filme filme = new Filme();

				filme.setNome(nome);
				filme.setDisponivel(disponivel);
				filme.setPromocao(promocao);
				filme.setValor(Double.parseDouble(valor));
				filme.setValorPromocao(Double.parseDouble(valorPromocao));
				filme.setGeneroCodigo(new Genero(Integer.parseInt(genero)));

				FilmeController controller = new FilmeController();
				try {
					controller.salvar(filme);
					limparDados();
					JSFUtil.addInfoMessage(Rotulo.INFO.getDescricao(), Mensagem.sucesso,
							Mensagem.filmeInseridoComSucesso);
					limparDados();
				} catch (Exception e) {
					JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.erro, Mensagem.ErroAoInserrirFilme);
				}

			}
		}
		return "";
	}

	public boolean validarIncluir() {
		if (Valida.verificaVazio(nome)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeNome);
			return false;
		}
		if (Valida.verificaVazio(genero)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeGenero);
			return false;
		}
		if (Valida.verificaVazio(valor)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeValor);
			return false;
		}
		if (Valida.verificaVazio(disponivel)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeDisponivel);
			return false;
		}
		if (Valida.verificaVazio(promocao)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informePromocao);
			return false;
		}
		if (Valida.verificaVazio(valorPromocao)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio,
					Mensagem.informeValorPromocao);
			return false;
		}
		return true;
	}

	public boolean validarAlterar() {

		if (Valida.verificaVazio(filmeUpdate.getValor() + "")) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeValor);
			return false;
		}
		if (Valida.verificaVazio(filmeUpdate.getDisponivel())) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeDisponivel);
			return false;
		}
		if (Valida.verificaVazio(filmeUpdate.getPromocao())) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informePromocao);
			return false;
		}
		if (Valida.verificaVazio(filmeUpdate.getValorPromocao() + "")) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio,
					Mensagem.informeValorPromocao);
			return false;
		}
		return true;
	}

	public void limparDados() {
		nome = null;
		genero = null;
		valor = null;
		disponivel = null;
		promocao = null;
		valorPromocao = null;

	}

	public void init() {
		listaGeneros = new FilmeController().carregarComboGenero();
		listaFilmes = preencherTabela();

	}

	public void sair() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String alterar() {
		alterar = true;
		return "alterarFilme";
	}

	public String excluir() {
		listaFilmes.remove(filmeUpdate);
		new FilmeController().excluir(filmeUpdate);
		new GeneroController().excluir(filmeUpdate.getGeneroCodigo());
		JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio,
				Mensagem.filmeExcluidoComSucesso);
		filmeUpdate = null;

		return "";
	}

	public String telaConsulta() {
		JSFUtil.addInfoMessage("INFO", Mensagem.sucesso, Mensagem.filmeAlteradoComSucesso);
		return "consultarFilme";

	}

	public ArrayList<Genero> carregarComboGenero() {
		ArrayList<Genero> lista = new ArrayList<Genero>();
		try {
			lista = new GeneroDAO().buscarTodos();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return lista;
	}

}
