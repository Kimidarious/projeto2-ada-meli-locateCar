package team3;

import java.util.InputMismatchException;
import java.util.Scanner;

import team3.Locadora.Locadora;
import team3.Locadora.Veiculo;
import team3.Cliente.ClientePF;
import team3.Cliente.ClientePJ;
import team3.Cliente.Cliente;

public class Main {
    public static void main(String[] args) {
        Locadora locadora = new Locadora();
        seedDados(locadora);

        try (Scanner scanner = new Scanner(System.in)) {
            int opcao;
            do {
                mostrarMenu();
                try {
                    System.out.print("Escolha uma opção: ");
                    opcao = scanner.nextInt();
                    scanner.nextLine(); // consome quebra de linha

                    switch (opcao) {
                        case 1 -> locadora.cadastrarUsuario(scanner);
                        case 2 -> locadora.cadastrarLivro(scanner);
                        case 3 -> locadora.realizarEmprestimo(scanner);
                        case 4 -> locadora.registrarDevolucao(scanner);
                        case 5 -> locadora.listarAcervo();
                        case 6 -> locadora.listarUsuarios();
                        case 7 -> locadora.listarEmprestimosAtivos();
                        case 8 -> locadora.listarEmprestimosAtrasados();
                        case 9 -> locadora.editarUsuario(scanner);
                        case 10 -> locadora.removerUsuario(scanner);
                        case 0 -> System.out.println("Encerrando o sistema...");
                        default -> System.out.println("Opção inválida. Tente novamente.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Digite um número.");
                    opcao = -1;
                    scanner.nextLine(); // limpa buffer
                }
            } while (opcao != 0);
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n===== SISTEMA BIBLIOTECA =====");
        System.out.println("1. Cadastrar cliente");
        System.out.println("2. Cadastrar veiculo");
        System.out.println("3. Realizar locação");
        System.out.println("4. Registrar devolução");
        System.out.println("5. Listar veiculos disponíveis");
        System.out.println("6. Listar clientes");
        System.out.println("7. Listar locações ativas");
        System.out.println("8. Listar locações atrasadas");
        System.out.println("9. Editar cliente");
        System.out.println("10. Remover cliente");
        System.out.println("0. Sair");
    }

    private static void seedDados(Locadora locadora) {
    }
}
