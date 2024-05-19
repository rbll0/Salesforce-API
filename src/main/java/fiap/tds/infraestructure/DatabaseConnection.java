package fiap.tds.infraestructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static final String URL_CONNECTION = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    public static final String USER = "rm553326";
    public static final String PASSWORD = "091003";

    private Connection connection;

    public DatabaseConnection() {
        try {
            // Inicializa a conexão com o banco de dados Oracle
            this.connection = DriverManager.getConnection(URL_CONNECTION, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao conectar ao banco de dados");
        }
    }

    /**
     * Obtém a conexão com o banco de dados.
     *
     * @return A conexão ativa com o banco de dados.
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Fecha a conexão com o banco de dados.
     * Lança uma exceção em caso de erro ao fechar a conexão.
     */
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao fechar conexão com o banco de dados");
        }
    }
}
