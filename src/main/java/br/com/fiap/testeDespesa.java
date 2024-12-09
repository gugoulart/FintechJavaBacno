package br.com.fiap;

import br.com.fiap.DAO.DespesaDAO;
import br.com.fiap.br.model.Despesa;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class testeDespesa {
    public static void main(String[] args) {
        DespesaDAO despesaDAO = new DespesaDAO();

        Despesa novaDespesa1 = new Despesa(1, "Compra de supermercado", 300.50, "Mensal", LocalDate.now());
        Despesa novaDespesa2 = new Despesa(1, "Combustível", 150.75, "Semanal", LocalDate.now());
        Despesa novaDespesa3 = new Despesa(2, "Aluguel", 1200.00, "Mensal", LocalDate.now());
        Despesa novaDespesa4 = new Despesa(3, "Lazer", 500.00, "Ocasional", LocalDate.now());
        Despesa novaDespesa5 = new Despesa(4, "Energia elétrica", 250.30, "Mensal", LocalDate.now());

        try {
            despesaDAO.insert(novaDespesa1);
            despesaDAO.insert(novaDespesa2);
            despesaDAO.insert(novaDespesa3);
            despesaDAO.insert(novaDespesa4);
            despesaDAO.insert(novaDespesa5);
            System.out.println("Despesas inseridas com sucesso!");

            List<Despesa> despesas = despesaDAO.getAll();
            for (Despesa despesa : despesas) {
                System.out.println("Descrição: " + despesa.getDescricao() +
                        ", Valor: " + despesa.getValorTotal() +
                        ", Frequência: " + despesa.getFrequencia() +
                        ", Data: " + despesa.getDataDespesa());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir despesa: " + e.getMessage());
        }
    }
}
