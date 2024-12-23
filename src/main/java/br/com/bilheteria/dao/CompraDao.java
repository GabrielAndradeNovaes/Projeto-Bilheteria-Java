package br.com.bilheteria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import br.com.bilheteria.model.Cliente;
import br.com.bilheteria.model.Compra;
import br.com.bilheteria.model.Evento;

public class CompraDao {
	
	private Connection con;
	
	public CompraDao() {
		con = ConnectionFactory.getConnection();
	}
	
	public void inserir(Compra compra) throws SQLException {
	    String sqlCompra = "INSERT INTO compra (cliente_id, evento_id, quantidade, valor, forma_pagamento) VALUES (?, ?, ?, ?, ?)";
	    String sqlEvento = "UPDATE evento SET quantidade_ingressos_vendidos = quantidade_ingressos_vendidos + ? WHERE id = ?";
	    
	    PreparedStatement stmtCompra = null;
	    PreparedStatement stmtEvento = null;

	    try {
	    	
	    	con.setAutoCommit(false);
	    	
	    	stmtCompra = con.prepareStatement(sqlCompra);
	    	
	    	stmtCompra.setInt(1, compra.getCliente().getId());
		    stmtCompra.setInt(2, compra.getEvento().getId());
		    stmtCompra.setInt(3, compra.getQuantidade());
		    stmtCompra.setFloat(4, compra.getValor());
		    stmtCompra.setString(5, compra.getFormaPagamento());
		    stmtCompra.executeUpdate();
		    
		    Evento evento = compra.getEvento();
	        evento.incrementarIngressosVendidos(compra.getQuantidade());

	        stmtEvento = con.prepareStatement(sqlEvento);
	        stmtEvento.setInt(1, compra.getQuantidade());
	        stmtEvento.setInt(2, compra.getEvento().getId());
	        stmtEvento.executeUpdate();

	        con.commit();
		    
		    
		} catch (Exception e) {
			con.rollback();
	        throw e;
		} finally {
	        if (stmtCompra != null) stmtCompra.close();
	        if (stmtEvento != null) stmtEvento.close();
	        con.setAutoCommit(true);
	    }
	    

	}

	public List<Compra> listarTodos(Cliente cliente) throws SQLException {
	    String sql = "SELECT c.id, cl.nome as cliente_nome, e.nome as evento_nome, c.quantidade, c.valor, c.forma_pagamento, c.data " +
	                 "FROM compra c " +
	                 "JOIN cliente cl ON c.cliente_id = cl.id " +
	                 "JOIN evento e ON c.evento_id = e.id " +
	                 "WHERE c.cliente_id = ?";
	    
	    PreparedStatement stmt = con.prepareStatement(sql);
	    stmt.setInt(1, cliente.getId());
	    ResultSet rs = stmt.executeQuery();
	    List<Compra> compras = new ArrayList<>();

	    while (rs.next()) {
	        Compra compra = new Compra();
	        Cliente cliente1 = new Cliente();
	        cliente1.setNome(rs.getString("cliente_nome"));
	        
	        Evento evento = new Evento();
	        evento.setNome(rs.getString("evento_nome"));
	        
	        compra.setCliente(cliente1);
	        compra.setEvento(evento);
	        compra.setQuantidade(rs.getInt("quantidade"));
	        compra.setValor(rs.getFloat("valor"));
	        compra.setFormaPagamento(rs.getString("forma_Pagamento"));
	        
	        compra.setData(rs.getObject("data", LocalDate.class));

	        compras.add(compra);
	    }
	    
	    rs.close();
	    stmt.close();
	    con.close();
	    return compras;
	}
	
	public void deletar(int id) throws SQLException{
		String sql = "DELETE FROM compra WHERE id = ?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.executeUpdate();
		stmt.close();
		con.close();
	}
	
	public void atualizarStatus(int id, String novoStatus) throws SQLException {
	    String sql = "UPDATE compra SET status = ? WHERE id = ?";
	    PreparedStatement stmt = null;

	    try {
	        stmt = con.prepareStatement(sql);
	        stmt.setString(1, novoStatus);
	        stmt.setInt(2, id);
	        stmt.executeUpdate();
	    } finally {
	        if (stmt != null) stmt.close();
	    }
	}
	
	


}
