package br.com.fiap;

import br.com.fiap.DAO.UsuarioDAO;
import br.com.fiap.br.model.Usuario;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class testeUsuario {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        try {
            usuarioDAO.insert(new Usuario(1, "Carlos Daniel Chen", "12345678901", "Rua A, 100", Date.valueOf("1990-01-01"), "joao@gmail.com", "11999999999"));
            usuarioDAO.insert(new Usuario(2, "Maria Souza", "23456789012", "Rua B, 200", Date.valueOf("1992-07-15"), "maria@gmail.com", "11988888888"));
            usuarioDAO.insert(new Usuario(3, "Carlos Andrade", "34567890123", "Rua C, 300", Date.valueOf("1985-02-23"), "carlos@gmail.com", "11977777777"));
            usuarioDAO.insert(new Usuario(4, "Ana Beatriz", "45678901234", "Rua D, 400", Date.valueOf("1995-05-10"), "ana@gmail.com", "11966666666"));
            usuarioDAO.insert(new Usuario(5, "Pedro Costa", "56789012345", "Rua E, 500", Date.valueOf("1987-08-29"), "pedro@gmail.com", "11955555555"));

            List<Usuario> usuarios = usuarioDAO.getAll();
            for (Usuario usuario : usuarios) {
                System.out.println("Nome: " + usuario.getNome() + " - CPF: " + usuario.getCpf() + "id: " + usuario.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}