package br.com.fiap.DAO;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.br.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public void insert(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO Usuarios (id_usuarios, nm_usuarios, cpf_usuarios, end_usuarios, dt_nasc_usuarios, email_usuarios, tel_usuarios) " +
                "VALUES (seq_Usuarios.NEXTVAL, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getEndereco());
            stmt.setDate(4, new java.sql.Date(usuario.getDataNasc().getTime()));
            stmt.setString(5, usuario.getEmail());
            stmt.setString(6, usuario.getTelefone());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir usuário no banco de dados", e);
        }
    }

    public List<Usuario> getAll() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuarios";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id_usuarios"));
                usuario.setNome(rs.getString("nm_usuarios"));
                usuario.setCpf(rs.getString("cpf_usuarios"));
                usuario.setEndereco(rs.getString("end_usuarios"));
                usuario.setDataNasc(rs.getDate("dt_nasc_usuarios"));
                usuario.setEmail(rs.getString("email_usuarios"));
                usuario.setTelefone(rs.getString("tel_usuarios"));

                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            throw new SQLException("Erro ao consultar os usuários", e);
        }

        return usuarios;
    }
}