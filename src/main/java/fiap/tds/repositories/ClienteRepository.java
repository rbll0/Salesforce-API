package fiap.tds.repositories;

import fiap.tds.infraestructure.DatabaseConnection;
import fiap.tds.models.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    private Connection connection;

    public ClienteRepository() {
        // Obtem a conexão com o banco de dados
        this.connection = new DatabaseConnection().getConnection();
    }

    // Método para salvar um cliente no banco de dados
    public void salvarCliente(Cliente cliente) {
        // Verifica se o nome do cliente não é nulo antes de salvar
        if (cliente.getNome_cliente() == null || cliente.getNome_cliente().isEmpty()) {
            throw new IllegalArgumentException("O nome do cliente não pode ser nulo ou vazio");
        }

        String sql = "INSERT INTO Cliente (nome_cliente, email_corporativo, endereco, pais_cliente, comentarios) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome_cliente());
            stmt.setString(2, cliente.getEmail_corporativo());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getPais_cliente());
            stmt.setString(5, cliente.getComentarios());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao inserir cliente no banco de dados");
        }
    }


    // Método para buscar um cliente pelo ID
    public Cliente buscarClientePorId(int id) {
        String sql = "SELECT * FROM Cliente WHERE cd_cliente = ?";
        Cliente cliente = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                cliente = new Cliente(
                        rs.getInt("cd_cliente"),
                        rs.getString("nome_cliente"),
                        rs.getString("email_corporativo"),
                        rs.getString("endereco"),
                        rs.getString("pais_cliente"),
                        rs.getString("comentarios")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar cliente no banco de dados");
        }

        return cliente;
    }

    // Método para atualizar um cliente no banco de dados
    public void atualizarCliente(Cliente cliente) {
        String sql = "UPDATE Cliente SET nome_cliente = ?, email_corporativo = ?, endereco = ?, " +
                "pais_cliente = ?, comentarios = ? WHERE cd_cliente = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome_cliente());
            stmt.setString(2, cliente.getEmail_corporativo());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getPais_cliente());
            stmt.setString(5, cliente.getComentarios());
            stmt.setInt(6, cliente.getCd_cliente());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar cliente no banco de dados");
        }
    }

    // Método para deletar um cliente do banco de dados
    public void deletarCliente(int id) {
        String sql = "DELETE FROM Cliente WHERE cd_cliente = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao deletar cliente do banco de dados");
        }
    }

    // Método para listar todos os clientes do banco de dados
    public List<Cliente> listarClientes() {
        String sql = "SELECT * FROM Cliente";
        List<Cliente> clientes = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("cd_cliente"),
                        rs.getString("nome_cliente"),
                        rs.getString("email_corporativo"),
                        rs.getString("endereco"),
                        rs.getString("pais_cliente"),
                        rs.getString("comentarios")
                );
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao listar clientes do banco de dados");
        }

        return clientes;
    }
}
