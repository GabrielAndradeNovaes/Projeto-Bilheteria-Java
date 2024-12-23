package br.com.bilheteria.dao;

import br.com.bilheteria.model.AcessoLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AcessoLogDao {
    private Connection con;

    public AcessoLogDao() {
        con = ConnectionFactory.getConnection();
    }

    public void salvar(AcessoLog log) throws SQLException {
        String sql = "INSERT INTO acesso_log (ip, pagina_acessada, id_cliente) VALUES (?, ?, ?)";
        
        PreparedStatement stmt = con.prepareStatement(sql);
        
        //stmt.setString(1, AcessoLog.getIp());
    }
}
