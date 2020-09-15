package br.com.foursys.locadora.backingbean;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import br.com.foursys.locadora.bean.Cidade;
import br.com.foursys.locadora.bean.Contato;
import br.com.foursys.locadora.bean.Endereco;
import br.com.foursys.locadora.bean.Estado;
import br.com.foursys.locadora.bean.Funcionario;
import br.com.foursys.locadora.controller.ContatoController;
import br.com.foursys.locadora.controller.EnderecoController;
import br.com.foursys.locadora.controller.FuncionarioController;
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

@ManagedBean(name = "funcionarioBacking")
@SessionScoped
public class FuncionarioBacking implements Serializable {
	private static final long serialVersionUID = 1L;

	private String pesquisaNome = "";
	private String cpf;
	private Date dataNascimento;
	private String idade;
	private String login;
	private String nome;
	private String rg;
	private String senha;
	private String sexo;

	private String celular;
	private String email;
	private String telefone;

	private String bairro;
	private String cep;
	private String complemento;
	private String logradouro;
	private String numero;

	private Funcionario funcionarioUpdate;
	private boolean alterar = false;

	private String cidade;
	private String estado;

	private Funcionario funcionario = new Funcionario();
	private Funcionario funcionarioSelecionado = new Funcionario();
	private List<SelectItem> itensFuncionarios;
	static List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
	private ArrayList<Funcionario> listaFuncionarios;
	private List<Cidade> listaCidades = new ArrayList<Cidade>();
	private List<Estado> listaEstados = new ArrayList<Estado>();

	public Funcionario getFuncionarioUpdate() {
		return funcionarioUpdate;
	}

	public List<Estado> getListaEstados() {
		return listaEstados;
	}

	public void setListaEstados(List<Estado> listaEstados) {
		this.listaEstados = listaEstados;
	}

	public void setFuncionarioUpdate(Funcionario funcionarioUpdate) {
		this.funcionarioUpdate = funcionarioUpdate;
	}

	public String getPesquisaNome() {
		return pesquisaNome;
	}

	public void setPesquisaNome(String pesquisaNome) {
		this.pesquisaNome = pesquisaNome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}

	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}

	public List<SelectItem> getItensFuncionarios() {
		return itensFuncionarios;
	}

	public void setItensFuncionarios(List<SelectItem> itensFuncionarios) {
		this.itensFuncionarios = itensFuncionarios;
	}

	public static List<Funcionario> getListaFuncionario() {
		return listaFuncionario;
	}

	public static void setListaFuncionario(List<Funcionario> listaFuncionario) {
		FuncionarioBacking.listaFuncionario = listaFuncionario;
	}

	public ArrayList<Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}

	public void setListaFuncionarios(ArrayList<Funcionario> listaFuncionarios) {
		this.listaFuncionarios = listaFuncionarios;
	}

	public List<Cidade> getListaCidades() {
		return listaCidades;
	}

	public void setListaCidades(List<Cidade> listaCidades) {
		this.listaCidades = listaCidades;
	}

	public void limparDados() {

	}

	public String salvar() {
		if (alterar) {

			if (validarAlterar()) {
				// procedimentos para salvar utilizando update
				alterar = false;
				new EnderecoController().salvar(funcionarioUpdate.getEnderecoCodigo());
				new ContatoController().salvar(funcionarioUpdate.getContatoCodigo());
				new FuncionarioController().salvar(funcionarioUpdate);
				JSFUtil.addInfoMessage(Rotulo.INFO.getDescricao(), Mensagem.sucesso,
						Mensagem.funcionarioAlteradoComSucesso);

				funcionarioUpdate = null;
				return "consultarFuncionario";
			}

		} else {

			if (validarCampos()) {
				Funcionario funcionario = new Funcionario();

				funcionario.setCpf(cpf);
				funcionario.setDataNascimento(Data.formataData(dataNascimento));
				funcionario.setIdade(Integer.parseInt(idade));
				funcionario.setRg(rg);
				funcionario.setSexo(sexo);
				funcionario.setNome(nome);
				funcionario.setSenha(senha);
				funcionario.setLogin(login);

				Contato contato = new Contato();
				contato.setCelular(celular);
				contato.setTelefone(telefone);
				contato.setEmail(email);
				funcionario.setContatoCodigo(contato);

				Endereco endereco = new Endereco();
				endereco.setLogradouro(logradouro);
				endereco.setBairro(bairro);
				endereco.setNumero(Integer.parseInt(numero));
				endereco.setComplemento(complemento);
				endereco.setCep(cep);
				endereco.setCidadeCodigo(new Cidade(Integer.parseInt(cidade)));
				funcionario.setEnderecoCodigo(endereco);

				// salva o estado
				Cidade cidade = new Cidade();
				cidade.setEstadoCodigo(new Estado(Integer.parseInt(estado)));

				try {
					new EnderecoController().salvar(endereco);
					new ContatoController().salvar(contato);
					new FuncionarioController().salvar(funcionario);

					JSFUtil.addInfoMessage(Rotulo.INFO.getDescricao(), Mensagem.funcionarioSalvoComSucesso,
							Mensagem.funcionarioSalvoComSucesso);
					limparDados();
				} catch (Exception e) {
					JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.erro,
							Mensagem.erroAoInserirFuncionario);

				}
			}
		}
		return "";
	}

	public boolean validarAlterar() {

		return true;
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

		if (Valida.verificaVazio(nome)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeNome);
			return false;
		}

		if (Valida.validaNome(nome)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeNomeValido);
			return false;
		}
		if (Valida.verificaVazio(rg)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeRg);
			return false;
		}
		if (Valida.validarRg(rg)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeRgInvalido);
			return false;
		}
		if (!Valida.validaRg(rg)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeRgInvalido);
			return false;
		}
		if (Valida.verificaVazio(cpf)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeCpf);
			return false;
		}
		if (!Valida.validaCpf(cpf)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeCpfInvalido);
			return false;
		}

		if (Valida.verificaVazio(formataData(dataNascimento))) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio,
					Mensagem.informeDataNascimento);
			return false;
		}

		if (Valida.verificaVazio(idade)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeIdade);
			return false;
		}

		if (Valida.validaNumero(idade)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeIdadeValida);
			return false;
		}
		if (Valida.verificaVazio(sexo)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeSexo);
			return false;
		}

		if (Valida.verificaVazio(cidade)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeCidade);
			return false;
		}
		if (Valida.verificaVazio(estado)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeEstado);
			return false;
		}

		if (Valida.verificaVazio(cep)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeCep);
			return false;
		}
		if (!Valida.validaCep(cep)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeCepInvalido);
			return false;
		}

		if (Valida.verificaVazio(bairro)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeBairro);
			return false;
		}
		if (Valida.verificaVazio(logradouro)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeLogradouro);
			return false;
		}

		if (Valida.verificaVazio(numero)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeNumero);
			return false;
		}
		if (Valida.validaNumero(numero)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio,
					Mensagem.informeNumeroInvalido);
			return false;
		}

		if (Valida.verificaVazio(telefone)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeTelefone);
			return false;
		}
		if (Valida.verificaVazio(celular)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeCelular);
			return false;
		}
		if (Valida.verificaVazio(email)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeEmail);
			return false;
		}

		if (Valida.verificaVazio(login)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeLogin);
			return false;
		}

		if (Valida.verificaVazio(senha)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeSenha);
			return false;
		}

		return true;
	}

	public void pesquisar() {
		listaFuncionarios = pesquisarFuncionario();
	}

	public ArrayList<Funcionario> pesquisarFuncionario() {

		return new FuncionarioController().buscarNome(pesquisaNome);
	}

	public String telaConsulta() {
		JSFUtil.addInfoMessage("INFO", Mensagem.sucesso, Mensagem.funcionarioAlteradoComSucesso);
		return "consultarFuncioanrio";

	}

	public String alterar() {
		alterar = true;
		return "alterarFuncionario.xhtml";
	}

	public void init() {
		listaCidades = new FuncionarioController().carregarComboCidade();
		listaEstados = new FuncionarioController().carregarComboEstado();
	}

	public String excluir() {
		listaFuncionario.remove(funcionarioUpdate);
		new FuncionarioController().excluir(funcionarioUpdate);
		new ContatoController().excluir(funcionarioUpdate.getContatoCodigo());
		new EnderecoController().excluir(funcionarioUpdate.getEnderecoCodigo());

		JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio,
				Mensagem.funcionarioExcluidoComSucesso);
		funcionarioUpdate = null;

		return "";
	}
}
