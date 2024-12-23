package br.com.bilheteria.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.List;

import br.com.bilheteria.dao.ClienteDao;
import br.com.bilheteria.dao.EventoDao;
import br.com.bilheteria.model.Cliente;
import br.com.bilheteria.model.Evento;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		System.out.println("Login: " + login + ", Senha: " + senha);
		Cliente cliente = null;
		ClienteDao cDao = new ClienteDao();

		try {
			cliente = cDao.logar(login, senha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (cliente == null) {
	        request.setAttribute("erro", "Login ou senha inválidos!");
	        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
	        rd.forward(request, response);
	        return;
	    }

		HttpSession session = request.getSession();
		session.setAttribute("cliente", cliente);
		
		
		EventoDao eventoDao = new EventoDao();
	    List<Evento> eventos = null;
	    try {
	        eventos = eventoDao.listarTodos();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    request.setAttribute("eventos", eventos);
		
		// Implementando o cookie
		//Cookie nome = new Cookie("nome", cliente.getNome());
		//nome.setMaxAge(60*60*24*31*12);
		//response.addCookie(nome);
		
		String nomeCodificado = URLEncoder.encode(cliente.getNome(), "UTF-8");
		Cookie nome = new Cookie("nome", nomeCodificado);
		nome.setMaxAge(60 * 60 * 24 * 31 * 12);
		response.addCookie(nome);
		
		String next = "/home.jsp";

		RequestDispatcher rd = request.getRequestDispatcher(next);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
