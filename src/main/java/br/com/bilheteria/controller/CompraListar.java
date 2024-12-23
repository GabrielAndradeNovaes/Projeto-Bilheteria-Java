package br.com.bilheteria.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import br.com.bilheteria.dao.CompraDao;
import br.com.bilheteria.model.Cliente;
import br.com.bilheteria.model.Compra;

/**
 * Servlet implementation class CompraListar
 */
public class CompraListar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompraListar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String next = request.getParameter("next");
		
		
		HttpSession session = request.getSession();
	    Cliente cliente = (Cliente) session.getAttribute("cliente");
	    
	    if (cliente == null) {
	        response.sendRedirect("/sisbilheteria/index.jsp");
	        return;
	    }
	    
	    CompraDao comDao = new CompraDao();
		List<Compra> compras = null;
		
		try {
			compras = comDao.listarTodos(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("compras", compras);
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
