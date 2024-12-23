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
 * Servlet implementation class DeletarCompra
 */
public class DeletarCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletarCompra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int compraId = Integer.parseInt(request.getParameter("compra_id"));
		
		CompraDao compraDao = new CompraDao();

        try {
            compraDao.deletar(compraId);
            request.setAttribute("message", "compra deletada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", "Erro ao deletar compra: " + e.getMessage());
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
