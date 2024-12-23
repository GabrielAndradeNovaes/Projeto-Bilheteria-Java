package br.com.bilheteria.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.bilheteria.dao.EventoDao;
import br.com.bilheteria.model.Evento;

/**
 * Servlet implementation class EventoAdd
 */
public class EventoAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventoAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String categoria = request.getParameter("categoria");
        float valor = Float.parseFloat(request.getParameter("valor"));
        int capacidade = Integer.parseInt(request.getParameter("capacidade"));
        String local = request.getParameter("local");
        String endereco = request.getParameter("endereco");
        LocalDateTime dataInicio = null;

        try {
            String dataInicioStr = request.getParameter("dataInicio"); // Deve estar no formato "yyyy-MM-ddTHH:mm"
            if (dataInicioStr != null && !dataInicioStr.isEmpty()) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
                dataInicio = LocalDateTime.parse(dataInicioStr, formatter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Evento evento = new Evento();
        evento.setNome(nome);
        evento.setDescricao(descricao);
        evento.setCategoria(categoria);
        evento.setValor(valor);
        evento.setCapacidade(capacidade);
        evento.setLocal(local);
        evento.setEndereco(endereco);
        evento.setDataInicio(dataInicio);
        evento.setQuantidadeIngressosVendidos(0);

        EventoDao eveDao = new EventoDao();
        try {
            eveDao.inserir(evento);
            request.setAttribute("mensagem", "voce inseriu o evento com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("mensagem", "Erro ao inserir o evento. Tente novamente.");
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("resultado_evento.jsp");
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
