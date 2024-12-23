package br.com.bilheteria.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class TemaServlet
 */
public class TemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TemaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tema = request.getParameter("tema");

        // Valida o tema recebido
        if (tema != null && (tema.equals("claro") || tema.equals("escuro"))) {
            // Cria ou atualiza o cookie
            Cookie temaCookie = new Cookie("tema", tema);
            temaCookie.setMaxAge(7 * 24 * 60 * 60); // 7 dias
            temaCookie.setPath("/"); // Disponível para toda a aplicação
            response.addCookie(temaCookie);
        }

        // Redireciona para a página inicial ou outra página
        String referer = request.getHeader("Referer");
        if (referer != null) {
            response.sendRedirect(referer); // Redireciona para a página anterior
        } else {
            response.sendRedirect(request.getContextPath() + "/home.jsp"); // Redireciona para uma página padrão, como home.jsp
        }
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
