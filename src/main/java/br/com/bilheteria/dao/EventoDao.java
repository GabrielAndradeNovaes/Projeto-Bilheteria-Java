package br.com.bilheteria.dao;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bilheteria.model.Evento;

public class EventoDao {
	
	private Connection con;
	
	public EventoDao() {
		con = ConnectionFactory.getConnection();
	}
	
	public void inserir(Evento evento) throws SQLException {
	    String sql = "INSERT INTO evento (nome, descricao, categoria, valor, capacidade, local, endereco, data_inicio) " +
	                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	    PreparedStatement stmt = con.prepareStatement(sql);

	    stmt.setString(1, evento.getNome());
	    stmt.setString(2, evento.getDescricao());
	    stmt.setString(3, evento.getCategoria());
	    stmt.setFloat(4, evento.getValor());
	    stmt.setInt(5, evento.getCapacidade());
	    stmt.setString(6, evento.getLocal());
	    stmt.setString(7, evento.getEndereco());

	    if (evento.getDataInicio() != null) {
	        stmt.setTimestamp(8, java.sql.Timestamp.valueOf(evento.getDataInicio()));
	    } else {
	        stmt.setNull(8, java.sql.Types.TIMESTAMP);
	    }


	    stmt.executeUpdate();
	    stmt.close();
	    con.close();
	}
	
	
	public void apagar(int id) throws SQLException {
		String sql = "DELETE FROM cliente WHERE id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.executeUpdate();
		stmt.close();
		con.close();
	}

	
	public Evento listarUm(int id) throws SQLException {
	    String sql = "SELECT id, nome, descricao, categoria, valor, capacidade, local, endereco, data_inicio " +
	                 "FROM evento WHERE id = ?";
	    PreparedStatement stmt = con.prepareStatement(sql);
	    stmt.setInt(1, id);
	    ResultSet rs = stmt.executeQuery();

	    Evento evento = null;
	    if (rs.next()) {
	        evento = new Evento();
	        evento.setId(rs.getInt("id"));
	        evento.setNome(rs.getString("nome"));
	        evento.setDescricao(rs.getString("descricao"));
	        evento.setCategoria(rs.getString("categoria"));
	        evento.setValor(rs.getFloat("valor"));
	        evento.setCapacidade(rs.getInt("capacidade"));
	        evento.setLocal(rs.getString("local"));
	        evento.setEndereco(rs.getString("endereco"));

	        java.sql.Timestamp timestamp = rs.getTimestamp("data_inicio");
	        if (timestamp != null) {
	            evento.setDataInicio(timestamp.toLocalDateTime());
	        }
	    }

	    rs.close();
	    stmt.close();
	    con.close();

	    return evento;
	}
	
	
	public List<Evento> listarTodos() throws SQLException {
	    String sql = "SELECT id, nome, descricao, categoria, valor, capacidade, local, endereco, data_inicio FROM evento";
	    PreparedStatement stmt = con.prepareStatement(sql);

	    ResultSet rs = stmt.executeQuery();

	    List<Evento> eventos = new ArrayList<>();

	    while (rs.next()) {
	        Evento evento = new Evento();
	        evento.setId(rs.getInt("id"));
	        evento.setNome(rs.getString("nome"));
	        evento.setDescricao(rs.getString("descricao"));
	        evento.setCategoria(rs.getString("categoria"));
	        evento.setValor(rs.getFloat("valor"));
	        evento.setCapacidade(rs.getInt("capacidade"));
	        evento.setLocal(rs.getString("local"));
	        evento.setEndereco(rs.getString("endereco"));

	        java.sql.Timestamp timestamp = rs.getTimestamp("data_inicio");
	        if (timestamp != null) {
	            evento.setDataInicio(timestamp.toLocalDateTime());
	        }


	        eventos.add(evento);
	    }

	    rs.close();
	    stmt.close();
	    con.close();

	    return eventos;
	}

	public void alterar(Evento evento) throws SQLException {
	    String sql = "UPDATE evento SET nome = ?, descricao = ?, categoria = ?, valor = ?, capacidade = ?, " +
	                 "local = ?, endereco = ?, data_inicio = ? WHERE id = ?";
	    PreparedStatement stmt = con.prepareStatement(sql);

	    stmt.setString(1, evento.getNome());
	    stmt.setString(2, evento.getDescricao());
	    stmt.setString(3, evento.getCategoria());
	    stmt.setFloat(4, evento.getValor());
	    stmt.setInt(5, evento.getCapacidade());
	    stmt.setString(6, evento.getLocal());
	    stmt.setString(7, evento.getEndereco());

	    if (evento.getDataInicio() != null) {
	        stmt.setTimestamp(8, java.sql.Timestamp.valueOf(evento.getDataInicio()));
	    } else {
	        stmt.setNull(8, java.sql.Types.TIMESTAMP);
	    }

	    stmt.setInt(9, evento.getId());

	    stmt.executeUpdate();
	    stmt.close();
	    con.close();
	}

}
