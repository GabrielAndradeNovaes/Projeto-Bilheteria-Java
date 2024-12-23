package br.com.bilheteria.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bilheteria.model.Cliente;
import br.com.bilheteria.model.UsuarioService;

public class ClienteDao {
	
	private Connection con;
	
	public ClienteDao() {
		con = ConnectionFactory.getConnection();
	}
	
	public void inserir(Cliente cliente) throws SQLException{
	    String sql = "INSERT INTO cliente (nome, cpf, email, telefone, endereco, numero, complemento, bairro, cidade, uf, cep, dataNascimento, login, senha) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    PreparedStatement stmt = con.prepareStatement(sql);
	    
	    stmt.setString(1, cliente.getNome());
	    stmt.setString(2, cliente.getCpf());
	    stmt.setString(3, cliente.getEmail());
	    stmt.setString(4, cliente.getTelefone());
	    stmt.setString(5, cliente.getEndereco());
	    stmt.setString(6, cliente.getNumero());
	    stmt.setString(7, cliente.getComplemento());
	    stmt.setString(8, cliente.getBairro());
	    stmt.setString(9, cliente.getCidade());
	    stmt.setString(10, cliente.getUf());
	    stmt.setString(11, cliente.getCep());
	    
	    if (cliente.getDataNascimento() != null) {
	        stmt.setDate(12, java.sql.Date.valueOf(cliente.getDataNascimento()));
	    } else {
	        stmt.setDate(12, null);
	    }

	    stmt.setString(13, cliente.getLogin());
	    stmt.setString(14, cliente.getSenha());

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
	
	public Cliente listarUm(int id) throws SQLException {
	    String sql = "SELECT id, nome, cpf, email, telefone, endereco, numero, complemento, bairro, cidade, uf, cep, dataNascimento, login, senha " +
	                 "FROM cliente WHERE id = ?";
	    PreparedStatement stmt = con.prepareStatement(sql);
	    stmt.setInt(1, id);
	    ResultSet rs = stmt.executeQuery();

	    Cliente cliente = null;
	    if (rs.next()) {
	        cliente = new Cliente();
	        cliente.setId(rs.getInt("id"));
	        cliente.setNome(rs.getString("nome"));
	        cliente.setCpf(rs.getString("cpf"));
	        cliente.setEmail(rs.getString("email"));
	        cliente.setTelefone(rs.getString("telefone"));
	        cliente.setEndereco(rs.getString("endereco"));
	        cliente.setNumero(rs.getString("numero"));
	        cliente.setComplemento(rs.getString("complemento"));
	        cliente.setBairro(rs.getString("bairro"));
	        cliente.setCidade(rs.getString("cidade"));
	        cliente.setUf(rs.getString("uf"));
	        cliente.setCep(rs.getString("cep"));

	        java.sql.Date sqlDate = rs.getDate("dataNascimento");
	        if (sqlDate != null) {
	            cliente.setDataNascimento(sqlDate.toLocalDate());
	        }

	        cliente.setLogin(rs.getString("login"));
	        cliente.setSenha(rs.getString("senha"));
	    }

	    rs.close();
	    stmt.close();
	    con.close();
	    return cliente; 
	}

	public List<Cliente> listarTodos() throws SQLException {
	    String sql = "SELECT id, nome, cpf, email, telefone, endereco, numero, complemento, bairro, cidade, uf, cep, dataNascimento, login, senha FROM cliente";
	    PreparedStatement stmt = con.prepareStatement(sql);
	    ResultSet rs = stmt.executeQuery();

	    List<Cliente> clientes = new ArrayList<>();
	    while (rs.next()) {
	        Cliente cliente = new Cliente();
	        cliente.setId(rs.getInt("id"));
	        cliente.setNome(rs.getString("nome"));
	        cliente.setCpf(rs.getString("cpf"));
	        cliente.setEmail(rs.getString("email"));
	        cliente.setTelefone(rs.getString("telefone"));
	        cliente.setEndereco(rs.getString("endereco"));
	        cliente.setNumero(rs.getString("numero"));
	        cliente.setComplemento(rs.getString("complemento"));
	        cliente.setBairro(rs.getString("bairro"));
	        cliente.setCidade(rs.getString("cidade"));
	        cliente.setUf(rs.getString("uf"));
	        cliente.setCep(rs.getString("cep"));

	        java.sql.Date sqlDate = rs.getDate("dataNascimento");
	        if (sqlDate != null) {
	            cliente.setDataNascimento(sqlDate.toLocalDate());
	        }

	        cliente.setLogin(rs.getString("login"));
	        cliente.setSenha(rs.getString("senha"));

	        clientes.add(cliente);
	    }

	    rs.close();
	    stmt.close();
	    con.close();
	    return clientes;
	}

	public void alterar(Cliente cliente) throws SQLException {
	    String sql = "UPDATE cliente SET nome = ?, cpf = ?, email = ?, telefone = ?, endereco = ?, numero = ?, " +
	                 "complemento = ?, bairro = ?, cidade = ?, uf = ?, cep = ?, dataNascimento = ?, login = ?, senha = ? " +
	                 "WHERE id = ?";
	    PreparedStatement stmt = con.prepareStatement(sql);

	    stmt.setString(1, cliente.getNome());
	    stmt.setString(2, cliente.getCpf());
	    stmt.setString(3, cliente.getEmail());
	    stmt.setString(4, cliente.getTelefone());
	    stmt.setString(5, cliente.getEndereco());
	    stmt.setString(6, cliente.getNumero());
	    stmt.setString(7, cliente.getComplemento());
	    stmt.setString(8, cliente.getBairro());
	    stmt.setString(9, cliente.getCidade());
	    stmt.setString(10, cliente.getUf());
	    stmt.setString(11, cliente.getCep());

	    if (cliente.getDataNascimento() != null) {
	        stmt.setDate(12, java.sql.Date.valueOf(cliente.getDataNascimento()));
	    } else {
	        stmt.setNull(12, java.sql.Types.DATE);
	    }

	    stmt.setString(13, cliente.getLogin());
	    stmt.setString(14, cliente.getSenha());
	    stmt.setInt(15, cliente.getId());

	    stmt.executeUpdate();
	    stmt.close();
	    con.close();
	}
	
	public Cliente logar(String login, String senha) throws SQLException {
	    String sql = "SELECT id, nome, cpf, email, telefone, endereco, numero, complemento, bairro, cidade, uf, cep, dataNascimento, login, senha " +
	                 "FROM cliente WHERE login = ?";
	    
	    PreparedStatement stmt = con.prepareStatement(sql);
	    stmt.setString(1, login);
	    
	    ResultSet rs = stmt.executeQuery();
	    Cliente cliente = null;
	    
	    
	    if (rs.next()) {
	        String senhaHashBanco = rs.getString("senha");

	        UsuarioService usuarioService = new UsuarioService();
	        if (usuarioService.verificarSenha(senha, senhaHashBanco)) {
	            cliente = new Cliente();
	            cliente.setId(rs.getInt("id"));
	            cliente.setNome(rs.getString("nome"));
	            cliente.setCpf(rs.getString("cpf"));
	            cliente.setEmail(rs.getString("email"));
	            cliente.setTelefone(rs.getString("telefone"));
	            cliente.setEndereco(rs.getString("endereco"));
	            cliente.setNumero(rs.getString("numero"));
	            cliente.setComplemento(rs.getString("complemento"));
	            cliente.setBairro(rs.getString("bairro"));
	            cliente.setCidade(rs.getString("cidade"));
	            cliente.setUf(rs.getString("uf"));
	            cliente.setCep(rs.getString("cep"));

	            Date dataSql = rs.getDate("dataNascimento");
	            if (dataSql != null) {
	                cliente.setDataNascimento(dataSql.toLocalDate());
	            }

	            cliente.setLogin(rs.getString("login"));
	        } else {
	            cliente = null;
	        }
	    }
	    
	    rs.close();
	    stmt.close();
	    con.close();
	    return cliente;
	}

}
