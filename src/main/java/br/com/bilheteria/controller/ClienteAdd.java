package br.com.bilheteria.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;


import br.com.bilheteria.dao.ClienteDao;
import br.com.bilheteria.model.Cliente;
import br.com.bilheteria.model.UsuarioService;

/**
 * Servlet implementation class ClienteAdd
 */
public class ClienteAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String endereco = request.getParameter("endereco");
        String numero = request.getParameter("numero");
        String complemento = request.getParameter("complemento");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String uf = request.getParameter("uf");
        String cep = request.getParameter("cep");
        String dataNascimentoStr = request.getParameter("dataNascimento");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        UsuarioService usuarioService = new UsuarioService();
        String senhaHash = usuarioService.gerarHashSenha(senha);


        LocalDate dataNascimento = null;
        try {
            dataNascimento = LocalDate.parse(dataNascimentoStr);
        } catch (Exception e) {
            request.setAttribute("mensagemErro", "Data de nascimento inválida.");
            request.getRequestDispatcher("formulario.jsp").forward(request, response);
            return;
        }
   
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        cliente.setEndereco(endereco);
        cliente.setNumero(numero);
        cliente.setComplemento(complemento);
        cliente.setBairro(bairro);
        cliente.setCidade(cidade);
        cliente.setUf(uf);
        cliente.setCep(cep);
        cliente.setDataNascimento(dataNascimento);
        cliente.setLogin(login);
        cliente.setSenha(senhaHash);

        ClienteDao clienteDao = new ClienteDao();

        try {
            clienteDao.inserir(cliente);
            response.sendRedirect("index.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("mensagemErro", "Erro ao inserir o cliente. Tente novamente.");
            request.getRequestDispatcher("formulario.jsp").forward(request, response);
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
