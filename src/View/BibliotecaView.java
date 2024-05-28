package View;

import java.util.Scanner;
import Controller.LivroController;
import Interface.LivroDAO;
import Interface.LivroDAOImpl;
import Model.Livro;

public class BibliotecaView {
    private LivroController livroController;

    public BibliotecaView(LivroController livroController) {
        this.livroController = livroController;
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        
        do {
            System.out.println("===== Sistema de Gerenciamento de Biblioteca =====");
            System.out.println("1. Adicionar um livro");
            System.out.println("2. Remover um livro");
            System.out.println("3. Buscar um livro");
            System.out.println("4. Listar todos os livros");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarLivro(scanner);
                    break;
                case 2:
                    removerLivro(scanner);
                    break;
                case 3:
                    buscarLivro(scanner);
                    break;
                case 4:
                    listarLivros();
                    break;
                case 5:
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        } while (opcao != 5);
        
        scanner.close();
    }

    private void adicionarLivro(Scanner scanner) {
        System.out.print("Digite o titulo do livro: ");
        String titulo = scanner.nextLine();

        System.out.print("Digite o autor do livro: ");
        String autor = scanner.nextLine();

        Livro livro = new Livro(titulo, autor);
        livroController.adicionarLivro(livro);
    }

    private void removerLivro(Scanner scanner) {
        System.out.print("Digite o ID do livro a ser removido: ");
        int id = scanner.nextInt();
        livroController.removerLivro(id);
    }

    private void buscarLivro(Scanner scanner) {
        System.out.print("Digite o ID do livro a ser buscado: ");
        int id = scanner.nextInt();
        livroController.buscarLivro(id);
    }

    private void listarLivros() {
        livroController.listarLivros();
    }
    
    public static void main(String[] args) {
        LivroDAO livroDAO = new LivroDAOImpl();
        LivroController livroController = new LivroController(livroDAO);
        BibliotecaView view = new BibliotecaView(livroController);
        view.exibirMenu();
    }
}

