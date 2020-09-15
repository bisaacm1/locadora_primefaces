package br.com.foursys.locadora.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.caelum.stella.validation.CPFValidator;

/**
 * @author imaciel
 * @since 23/04/2020
 * @version 0.1
 */
public class Valida {
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);

	public static boolean verificaVazio(String aux) {
		aux = aux.replace(".", " ");
		aux = aux.replace("-", " ");
		aux = aux.replace("/", " ");
		aux = aux.replace("(", " ");
		aux = aux.replace(")", " ");
		if (aux.trim().equals("") || aux == null) {
			return true;
		}
		return false;
	}

	public static boolean verificaIndex(String string) {

		return string.equals(0);
	}

	public static boolean validaCpf(String cpf) {
		CPFValidator cpfValidator = new CPFValidator();
		try {
			cpfValidator.assertValid(cpf);
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	public static boolean validaNumero(String numero) {
		try {
			int i = Integer.parseInt(numero);

		} catch (NumberFormatException e) {
			return true;

		}
		return false;
	}

	public static boolean validarRg(String rg) {
		return rg.equals("00.000.000-0");
	}

	public static boolean validaRg(String rg) {
		String a, b, c, d, e, f, g, h, i;
		int resultado;
		String rgaux = rg.replace(".", "").replace("-", "");

		a = rgaux.charAt(0) + "";
		b = rgaux.charAt(1) + "";
		c = rgaux.charAt(2) + "";
		d = rgaux.charAt(3) + "";
		e = rgaux.charAt(4) + "";
		f = rgaux.charAt(5) + "";
		g = rgaux.charAt(6) + "";
		h = rgaux.charAt(7) + "";
		i = rgaux.charAt(8) + "";
		int digito;
		if (i.equals("x") || i.equals("X")) {
			digito = 10;
		} else {
			digito = Integer.parseInt(i);
		}
		resultado = (9 * Integer.parseInt(a)) + (8 * Integer.parseInt(b)) + (7 * Integer.parseInt(c))
				+ (6 * Integer.parseInt(d)) + (5 * Integer.parseInt(e)) + (4 * Integer.parseInt(f))
				+ (3 * Integer.parseInt(g)) + (2 * Integer.parseInt(h));
		resultado = resultado % 11;
		if (resultado == digito) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean validarData(String data) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");// Formata a data
			sdf.setLenient(false);// Seta para que não seja estranha ex:31/02/2019
			sdf.parse(data);// Tenta colocar a string data num objeto date
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dataVerificada = LocalDate.parse(data, dtf);// Tenta colocar a string data formatada num objeto
																	// datetime
			LocalDate hoje = LocalDate.now();// Verifica se a data é menor que a data atual
			return dataVerificada.compareTo(hoje) <= 0;
		} catch (ParseException ex) {
			return false;
		}
	}

	public static boolean validaNome(String nome) {
		Pattern p = Pattern.compile("^(([a-zA-Z ]|[êéáãíõôóà])*)$");
		Matcher m = p.matcher(nome);
		if (m.find()) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean validaCep(String cep) {
		if (cep.equals("00.000-000")) {
			return false;
		}
		return true;
	}

	public static boolean validarEmail(String email) {

		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public static boolean endereco(String endereco) {
		return endereco.matches(Mensagem.validaEndereco);
	}

	public static boolean validaListaVazia(List<String> lista) {
		return lista.isEmpty();
	}

	public static boolean verificaVazio12(Date dataDevolucao) {
		if (dataDevolucao.equals(null)) {
			return false;
		}
		return true;
	}

}