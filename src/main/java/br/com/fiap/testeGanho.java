package br.com.fiap;

import br.com.fiap.DAO.GanhoDAO;
import br.com.fiap.br.model.Ganho;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class testeGanho {
    public static void main(String[] args) {
        GanhoDAO ganhoDAO = new GanhoDAO();

        Ganho novoGanho1 = new Ganho(1, "Venda de produto", 7676.00, LocalDate.now());
        Ganho novoGanho2 = new Ganho(2, "Recebimento de aluguel", 2000.00, LocalDate.now());
        Ganho novoGanho3 = new Ganho(3, "Comissão de vendas", 1500.00, LocalDate.now());

        try {
            ganhoDAO.insert(novoGanho1);
            ganhoDAO.insert(novoGanho2);
            ganhoDAO.insert(novoGanho3);
            System.out.println("Ganhos inseridos com sucesso!");

            List<Ganho> ganhos = ganhoDAO.getAll();
            for (Ganho ganho : ganhos) {
                System.out.println("Descrição: " + ganho.getDescricao() +
                        ", Valor ganho: " + ganho.getValorGanho() +
                        ", Data do ganho: " + ganho.getDataGanho());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir ganho: " + e.getMessage());
        }
    }
}
