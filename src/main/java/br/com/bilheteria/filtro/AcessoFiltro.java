package br.com.bilheteria.filtro;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

import br.com.bilheteria.dao.ConnectionFactory;

@WebFilter("/*") // Aplica o filtro a todas as páginas
public class AcessoFiltro implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Inicialização, se necessário
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        // Obtendo dados do cliente
        String ipCliente = request.getRemoteAddr();
        String paginaAcessada = httpRequest.getRequestURI();
        LocalDateTime dataHora = LocalDateTime.now();

        // Obtendo o ID do cliente da sessão, se existir
        HttpSession session = httpRequest.getSession(false); // Evitar criar uma nova sessão
        Integer idCliente = (session != null) ? (Integer) session.getAttribute("id_cliente") : null;

        // Registrar no log
        registrarAcesso(ipCliente, paginaAcessada, dataHora, idCliente);

        // Continuar com a execução normal da aplicação
        chain.doFilter(request, response);
    }

    private void registrarAcesso(String ipCliente, String paginaAcessada, LocalDateTime dataHora, Integer idCliente) {
        String query = "INSERT INTO acesso_log (ip, data_hora, pagina_acessada, id_cliente) VALUES (?, ?, ?, ?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, ipCliente);
            statement.setObject(2, dataHora); // Para compatibilidade com o `TIMESTAMP`
            statement.setString(3, paginaAcessada);
            statement.setObject(4, idCliente); // Insere NULL se o cliente não estiver logado

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // Log de erro no console
        }
    }

    @Override
    public void destroy() {
        // Cleanup, se necessário
    }
}
