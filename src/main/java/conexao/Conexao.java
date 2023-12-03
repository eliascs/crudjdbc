package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private String url = "jdbc:postgresql://localhost:5435/jdbcjava";
    private String user = "postgres";
    private String password = "admin";

    public Connection getConnection() throws SQLException {
        Connection conexao = DriverManager.getConnection(url,user,password);
        return conexao;
    }
}

