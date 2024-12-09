package br.com.fiap.DAO;

import br.com.fiap.br.model.Despesa;
import br.com.fiap.factory.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DespesaDAO {

    public void insert(Despesa despesa) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConnectionFactory.getConnection();

            if (!usuarioExists(conn, despesa.getIdUsuarios())) {
                throw new SQLException("Usuário com id " + despesa.getIdUsuarios() + " não encontrado.");
            }

            String sql = "INSERT INTO DESPESAS (id_despesa, id_usuarios, descricao, valor_total, frequencia, data_despesa) VALUES (seq_despesas.nextval, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, despesa.getIdUsuarios());
            pstmt.setString(2, despesa.getDescricao());
            pstmt.setDouble(3, despesa.getValorTotal());
            pstmt.setString(4, despesa.getFrequencia());
            pstmt.setDate(5, Date.valueOf(despesa.getDataDespesa()));

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir despesa: " + e.getMessage());
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

    public List<Despesa> getAll() throws SQLException {
        List<Despesa> despesas = new ArrayList<>();
        String sql = "SELECT * FROM DESPESAS";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Despesa despesa = new Despesa();
                despesa.setIdDespesa(rs.getInt("id_despesa"));
                despesa.setIdUsuarios(rs.getInt("id_usuarios"));
                despesa.setDescricao(rs.getString("descricao"));
                despesa.setValorTotal(rs.getDouble("valor_total"));
                despesa.setFrequencia(rs.getString("frequencia"));
                despesa.setDataDespesa(rs.getDate("data_despesa").toLocalDate());

                despesas.add(despesa);
            }

        } catch (SQLException e) {
            throw new SQLException("Erro ao consultar as despesas", e);
        }

        return despesas;
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
