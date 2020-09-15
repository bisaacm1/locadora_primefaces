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
import br.com.foursys.locadora.bean.Cliente;
import br.com.foursys.locadora.bean.Contato;
import br.com.foursys.locadora.bean.Endereco;
import br.com.foursys.locadora.bean.Estado;
import br.com.foursys.locadora.controller.ClienteController;
import br.com.foursys.locadora.controller.ContatoController;
import br.com.foursys.locadora.controller.EnderecoController;
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

@ManagedBean(name = "clienteBacking")
@SessionScoped
public class ClienteBacking implements Serializable {
	private static final long serialVersionUID = 1L;

	private String pesquisaNome = "";
	private String codigo;
	private String bairro;
	private String celular;
	private String cep;
	private String cidade;
	private String estado;
	private String complemento;
	private String cpf;
	private Date dataNascimento;
	private String email;
	private String idade;
	private String logradouro;
	private String nome;
	private String numero;
	private String rg;
	private String sexo;
	private String telefone;

	private Cliente cliente = new Cliente();
	private Cliente clienteSelecionado = new Cliente();
	private List<SelectItem> itensClientes;
	static List<Cliente> listaCliente = new ArrayList<Cliente>();
	private ArrayList<Cliente> listaClientes;
	private List<Cidade> listaCidades = new ArrayList<Cidade>();
	private List<Estado> listaEstados = new ArrayList<Estado>();

	private Cliente clienteUpdate;
	private boolean alterar = false;

	public List<Estado> getListaEstados() {
		return listaEstados;
	}

	public void setListaEstados(List<Estado> listaEstados) {
		this.listaEstados = listaEstados;
	}

	public Cliente getClienteUpdate() {
		return clienteUpdate;
	}

	public void setClienteUpdate(Cliente clienteUpdate) {
		this.clienteUpdate = clienteUpdate;
	}

	public boolean isAlterar() {
		return alterar;
	}

	public void setAlterar(boolean alterar) {
		this.alterar = alterar;
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

	public String getBairro() {
		return bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Cidade> getListaCidades() {
		return listaCidades;
	}

	public void setListaCidades(ArrayList<Cidade> listaCidades) {
		this.listaCidades = listaCidades;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
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

	public void setListaCidades(List<Cidade> listaCidades) {
		this.listaCidades = listaCidades;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public List<SelectItem> getItensClientes() {
		return itensClientes;
	}

	public void setItensClientes(List<SelectItem> itensClientes) {
		this.itensClientes = itensClientes;
	}

	public static List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public static void setListaCliente(List<Cliente> listaCliente) {
		ClienteBacking.listaCliente = listaCliente;
	}

	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public void limparDados() {
		bairro = null;
		celular = null;
		cep = null;
		cidade = null;
		complemento = null;
		cpf = null;
		dataNascimento = null;
		email = null;
		logradouro = null;
		nome = null;
		numero = null;
		rg = null;
		sexo = null;
		telefone = null;
		idade = null;
		estado = null;
	}

	public String salvar() {
		if (alterar) {

			if (validarAlterar()) {
				// procedimentos para salvar utilizando update
				alterar = false;
				new EnderecoController().salvar(clienteUpdate.getEnderecoCodigo());
				new ContatoController().salvar(clienteUpdate.getContatoCodigo());
				new ClienteController().salvar(clienteUpdate);
				JSFUtil.addInfoMessage(Rotulo.INFO.getDescricao(), Mensagem.sucesso,
						Mensagem.clienteAlteradoComSucesso);

				clienteUpdate = null;
				return "consultarCliente";
			}

		} else {

			if (validarCampos()) {
				Cliente cliente = new Cliente();

				// salva oque esta no banco de dados do cliente
				cliente.setCpf(cpf);
				cliente.setDataNascimento(Data.formataData(dataNascimento));
				cliente.setIdade(Integer.parseInt(idade));
				cliente.setRg(rg);
				cliente.setSexo(sexo);
				cliente.setNome(nome);

				// salva oq esta no banco de dados do contato
				Contato contato = new Contato();
				contato.setCelular(celular);
				contato.setTelefone(telefone);
				contato.setEmail(email);
				cliente.setContatoCodigo(contato);

				// salva oq esta no banco de dados de estado
				Endereco endereco = new Endereco();
				endereco.setLogradouro(logradouro);
				endereco.setBairro(bairro);
				endereco.setNumero(Integer.parseInt(numero));
				endereco.setComplemento(complemento);
				endereco.setCep(cep);
				endereco.setCidadeCodigo(new Cidade(Integer.parseInt(cidade)));
				cliente.setEnderecoCodigo(endereco);

				// salva o estado
				Cidade cidade = new Cidade();
				cidade.setEstadoCodigo(new Estado(Integer.parseInt(estado)));

				try {
					new EnderecoController().salvar(endereco);
					new ContatoController().salvar(contato);
					new ClienteController().salvar(cliente);

					JSFUtil.addInfoMessage(Rotulo.INFO.getDescricao(), Mensagem.clienteInseridoComSucesso,
							Mensagem.clienteInseridoComSucesso);
					limparDados();
				} catch (Exception e) {
					JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.erro, Mensagem.erroAoInserrirCliente);

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
		if (!Valida.validarEmail(email)) {
			JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio, Mensagem.informeEmailValido);
			return false;
		}
		return true;
	}

	public void pesquisar() {
		listaClientes = pesquisarCliente();
	}

	public ArrayList<Cliente> pesquisarCliente() {
		return new ClienteController().buscarNome(pesquisaNome);
	}

	public String alterar() {
		alterar = true;
		return "alterarCliente";
	}

	public String excluir() {
		listaClientes.remove(clienteUpdate);
		new ClienteController().excluir(clienteUpdate);
		new ContatoController().excluir(clienteUpdate.getContatoCodigo());
		new EnderecoController().excluir(clienteUpdate.getEnderecoCodigo());

		for (Cliente cliente : listaClientes) {
			if (cliente.getCodigo().equals(clienteUpdate.getCodigo())) {

				JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio,
						Mensagem.erroAoInserrirCliente);
			}
		}

		JSFUtil.addInfoMessage(Rotulo.ERROR.getDescricao(), Mensagem.campoObrigatorio,
				Mensagem.clienteExcluidoComSucesso);
		clienteUpdate = null;

		return "";
	}

	public void init() {
		listaCidades = new ClienteController().carregarComboCidade();
		listaEstados = new ClienteController().carregarComboEstado();
	}
}
