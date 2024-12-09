package br.com.fiap;

import br.com.fiap.DAO.ContasDAO;
import br.com.fiap.br.model.Conta;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class testeConta {
    public static void main(String[] args) {
        ContasDAO contasDAO = new ContasDAO();

        try {
            contasDAO.insert(new Conta(1, "Corrente", 1500.0, LocalDate.now()));
            contasDAO.insert(new Conta(2, "Poupança", 3000.0, LocalDate.now()));
            contasDAO.insert(new Conta(3, "Corrente", 2500.0, LocalDate.now()));
            contasDAO.insert(new Conta(4, "Poupança", 1200.0, LocalDate.now()));
            contasDAO.insert(new Conta(5, "Corrente", 5000.0, LocalDate.now()));

            List<Conta> contas = contasDAO.getAll();
            for (Conta conta : contas) {
                System.out.println("ID Conta: " + conta.getId() +
                        " - ID Usuário: " + conta.getIdUsuarios() +
                        " - Tipo de Conta: " + conta.getTpContaUsuarios() +
                        " - Saldo: " + conta.getSaldoConta() +
                        " - Data de Abertura: " + conta.getDtAbertura());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir ou recuperar contas: " + e.getMessage());
        }
    }
}