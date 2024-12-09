package br.com.fiap.DAO;

import br.com.fiap.br.model.Ganho;
import br.com.fiap.factory.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GanhoDAO {

    public void insert(Ganho ganho) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConnectionFactory.getConnection();

            if (!usuarioExists(conn, ganho.getIdUsuarios())) {
                throw new SQLException("Usuário com id " + ganho.getIdUsuarios() + " não encontrado.");
            }

            String sql = "INSERT INTO GANHOS (id_ganho, id_usuarios, descricao, valor_ganho, data_ganho) " +
                    "VALUES (seq_ganhos.nextval, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ganho.getIdUsuarios());
            pstmt.setString(2, ganho.getDescricao());
            pstmt.setDouble(3, ganho.getValorGanho());
            pstmt.setDate(4, Date.valueOf(ganho.getDataGanho()));

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir ganho: " + e.getMessage());
            throw e;
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public List<Ganho> getAll() throws SQLException {
        List<Ganho> ganhos = new ArrayList<>();
        String sql = "SELECT * FROM GANHOS";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Ganho ganho = new Ganho();
                ganho.setIdGanho(rs.getInt("id_ganho"));
                ganho.setIdUsuarios(rs.getInt("id_usuarios"));
                ganho.setDescricao(rs.getString("descricao"));
                ganho.setValorGanho(rs.getDouble("valor_ganho"));
                ganho.setDataGanho(rs.getDate("data_ganho").toLocalDate());

                ganhos.add(ganho);
            }

        } catch (SQLException e) {
            throw new SQLException("Erro ao consultar os ganhos", e);
        }

        return ganhos;
    }

    private boolean usuarioExists(Connection conn, int idUsuario) throws SQLException {
        String sql = "SELECT COUNT(*) FROM USUARIOS WHERE id_usuarios = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idUsuario);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }
}
