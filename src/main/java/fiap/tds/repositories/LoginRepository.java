package fiap.tds.repositories;

import fiap.tds.infraestructure.DatabaseConnection;
import fiap.tds.models.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginRepository {

    private Connection connection;

    public LoginRepository() {
        // Obtem a conexão com o banco de dados
        this.connection = new DatabaseConnection().getConnection();
    }

    // Método para buscar um login pelo email
    public Login buscarLoginPorEmail(String email) {
        String sql = "SELECT * FROM Login WHERE email_log = ?";
        Login login = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                login = new Login(
                        rs.getString("email_log"),
                        rs.getString("senha_log"),
                        rs.getInt("fk_Cliente_cd_cliente")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar login no banco de dados");
        }

        return login;
    }

    // Outros métodos para CRUD de login podem ser adicionados conforme necessário
}
