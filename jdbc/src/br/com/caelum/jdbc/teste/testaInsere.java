package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class testaInsere {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setNome("Murilo");
		contato.setEmail("mu@com.br");
		contato.setEndereco("R. teste 3185 cj57");
		contato.setDataNascimento(Calendar.getInstance());
	
		// grave nessa conexão!!!
		ContatoDAO dao = new ContatoDAO();
		
		// método elegante
		dao.adiciona(contato);
		
		System.out.println("Gravado!");

	}

}
