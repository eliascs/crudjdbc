package test;

import dao.UsuarioDao;
import model.Usuario;

import javax.swing.*;
import java.beans.beancontext.BeanContextServiceRevokedEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class teste {
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);


        boolean rodando = true;
        while (rodando) {
            System.out.println("=== Informe a opcao desejada ===\n1- Inserir um usuario no BD \n2- Lista de Usuarios \n3- Alterar um usuario \n4- Excluir um Usuario \n5- Sair ");
            int opcao = scan.nextInt();

            switch (opcao) {
                case 1: {
                    System.out.println("==== CADASTRO =====\nEMAIL: ");
                    String emailt = scan.nextLine();
                    System.out.println("SENHA: ");
                    String senhat = scan.nextLine();


                    UsuarioDao dao = new UsuarioDao();
                    Usuario us = new Usuario();

                    us.setEmail(emailt);
                    us.setSenha(senhat);

                    dao.salvar(us);
                }
                break;

                case 2: {
                    UsuarioDao dao1 = new UsuarioDao();
                    List<Usuario> usl = dao1.listar();
                    System.out.println("==== LISTA DE USUARIOS ====");
                    for (Usuario usuario : usl) {
                        System.out.println(usuario + "\n----------------------");
                    }
                }
                break;

                case 3: {
                    System.out.println("Informe o id referente a sua alteração");
                    Long infoId = scan.nextLong();

                    scan.nextLine(); // limpar o buffer

                    UsuarioDao dao2 = new UsuarioDao();
                    Usuario trocar = dao2.buscar(infoId);

                    //trocar.setId(1L);


                    System.out.println(" NOVO EMAIL: ");
                    String emailbd = scan.nextLine();

                    System.out.println(" NOVA SENHA: ");
                    String senhabd = scan.nextLine();

                    trocar.setId(infoId);
                    trocar.setEmail(emailbd);
                    trocar.setSenha(senhabd);

                    dao2.update(trocar);
                }
                break;

                case 4: {

                    System.out.println("Informe o ID do Usuario que você deseja excluir: ");
                    Long idbd = scan.nextLong();

                    UsuarioDao dao3 = new UsuarioDao();
                    dao3.delete(idbd);
                }
                break;

                case 5: {
                    rodando = false;
                    break;
                }
            }
        }
    }
}







