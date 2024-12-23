package br.com.bilheteria.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import br.com.bilheteria.dao.ClienteDao;
import br.com.bilheteria.dao.CompraDao;
import br.com.bilheteria.dao.EventoDao;
import br.com.bilheteria.model.Cliente;
import br.com.bilheteria.model.Compra;
import br.com.bilheteria.model.Evento;

/**
 * Servlet implementation class CompraRealizar
 */
public class CompraRealizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompraRealizar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int clienteId = Integer.parseInt(request.getParameter("cliente_id"));
		    int eventoId = Integer.parseInt(request.getParameter("evento_id"));
		    int quantidade = Integer.parseInt(request.getParameter("quantidade"));
		    float valor = Float.parseFloat(request.getParameter("valor"));
		    String formaPagamento = request.getParameter("forma_pagamento");

		    ClienteDao clienteDao = new ClienteDao();
		    EventoDao eventoDao = new EventoDao();
		    CompraDao compraDao = new CompraDao();
		    
		    

		    try {
		        Cliente cliente = clienteDao.listarUm(clienteId);
		        Evento evento = eventoDao.listarUm(eventoId);
		        

		        Compra compra = new Compra();
		        compra.setCliente(cliente);
		        compra.setEvento(evento);
		        compra.setQuantidade(quantidade);
		        compra.setValor(valor);
		        compra.setFormaPagamento(formaPagamento);
		        
		        
		        float valorTotal = compra.calcularValorTotal();
		        compra.setValor(valorTotal);

		        compraDao.inserir(compra);

		        request.setAttribute("message", "Compra realizada com sucesso!");
		        request.setAttribute("evento", evento);
	            request.setAttribute("valor", valor);
		    } catch (SQLException e) {
		        e.printStackTrace();
		        request.setAttribute("message", "Erro ao realizar a compra.");
		    }

		    RequestDispatcher rd = request.getRequestDispatcher("resultado_compra.jsp");
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
