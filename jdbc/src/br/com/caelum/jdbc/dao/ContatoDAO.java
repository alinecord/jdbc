package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDAO {

	private Connection connection;
	
	public ContatoDAO(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato) {
		String sql = "insert into contatos (nome,email,endereco,dataNascimento) values (?,?,?,?)";
		
		try {
		
		// prepared statement para inserção
		java.sql.PreparedStatement stmt = connection.prepareStatement(sql);
		
		// seta os valores
		stmt.setString(1,contato.getNome());
		stmt.setString(2,contato.getEmail());
		stmt.setString(3,contato.getEndereco());
		stmt.setDate(4, new Date( contato.getDataNascimento().getTimeInMillis() ));
		
		// executa
		stmt.execute();
		stmt.close();
		} catch (SQLException e) {
		throw new RuntimeException(e);
		}
		}

}
