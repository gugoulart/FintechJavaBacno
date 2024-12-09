package br.com.fiap.DAO;

import br.com.fiap.br.model.Conta;
import br.com.fiap.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContasDAO {

    public void insert(Conta conta) throws SQLException {
        String sql = "INSERT INTO Contas (id_conta, id_usuarios, tp_conta_usuarios, saldo_conta, dt_abertura) " +
                "VALUES (seq_Contas.NEXTVAL, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, conta.getIdUsuarios());
            stmt.setString(2, conta.getTpContaUsuarios());
            stmt.setDouble(3, conta.getSaldoConta());
            stmt.setDate(4, Date.valueOf(conta.getDtAbertura()));  // Usando java.sql.Date

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir conta no banco de dados", e);
        }
    }

    public List<Conta> getAll() throws SQLException {
        List<Conta> contas = new ArrayList<>();
        String sql = "SELECT * FROM Contas";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Conta conta = new Conta();
                conta.setId(rs.getInt("id_conta"));
                conta.setIdUsuarios(rs.getInt("id_usuarios"));
                conta.setTpContaUsuarios(rs.getString("tp_conta_usuarios"));
                conta.setSaldoConta(rs.getDouble("saldo_conta"));
                conta.setDtAbertura(rs.getDate("dt_abertura").toLocalDate()); // Convertendo para LocalDate

                contas.add(conta);
            }

        } catch (SQLException e) {
            throw new SQLException("Erro ao consultar as contas", e);
        }

        return contas;
    }
}
