package br.com.bilheteria.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import br.com.bilheteria.dao.CompraDao;

/**
 * Servlet implementation class AlterarStatusCompra
 */
public class AlterarStatusCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarStatusCompra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int compraId = Integer.parseInt(request.getParameter("compra_id"));
        String novoStatus = request.getParameter("novo_status");

        CompraDao compraDao = new CompraDao();

        try {
            compraDao.atualizarStatus(compraId, novoStatus);
            request.setAttribute("message", "Status da compra atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", "Erro ao atualizar o status da compra: " + e.getMessage());
        }
        RequestDispatcher rd = request.getRequestDispatcher("resultado_status.jsp");
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
