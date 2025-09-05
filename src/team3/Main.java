package team3;

import java.util.InputMismatchException;
import java.util.Scanner;
import team3.Veiculo.Locadora;
import team3.Locadora.domain.Veiculo;
import team3.Cliente.PessoaFisica;
import team3.Cliente.PessoaJuridica;
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
        // Usuarios
        // 3 Professores
        Cliente professor1 = new PessoaJuridica("Professor Xavier", "xavier@xmen.com", "11 99999-9999", "Informática");
        locadora.adicionarUsuario(professor1.getId(), professor1);

        Cliente professor2 = new PessoaJuridica("Magneto", "magneto@xmen.com", "11 99999-9999", "Física");
        locadora.adicionarUsuario(professor2.getId(), professor2);

        Cliente professor3 = new PessoaJuridica("Girafales", "professorgirafales@chaves.com", "11 99999-9999", "Letras");
        locadora.adicionarUsuario(professor3.getId(), professor3);

// 3 Alunos
        Cliente aluno1 = new PessoaFisica("Chaves", "chaves@vila.com", "11 99999-9999", "História", "Manhã");
        locadora.adicionarUsuario(aluno1.getId(), aluno1);

        Cliente aluno2 = new PessoaFisica("Quico", "quico@vila.com", "11 99999-9999", "Matemática", "Tarde");
        locadora.adicionarUsuario(aluno2.getId(), aluno2);

        Cliente aluno3 = new PessoaFisica("Cebolinha", "cebolinha@bairro.com", "11 99999-9999", "Informática", "Noite");
        locadora.adicionarUsuario(aluno3.getId(), aluno3);

        // ACERVO
        // Matemática
        locadora.adicionarAcervo(
                new Veiculo("A Matéria dos Números", "Marcus du Sautoy", "Zahar", 2018), 3);
        locadora.adicionarAcervo(
                new Veiculo("O Último Teorema de Fermat", "Simon Singh", "Record", 1997), 3);
        locadora.adicionarAcervo(
                new Veiculo("O Homem que Calculava", "Malba Tahan", "Record", 1938), 3);
        locadora.adicionarAcervo(
                new Veiculo("História da Matemática", "Carl B. Boyer", "Blucher", 1968), 3);
        locadora.adicionarAcervo(
                new Veiculo("Matemática Divertida e Curiosa", "Malba Tahan", "Record", 1940), 3);

        // Informática
        locadora.adicionarAcervo(
                new Veiculo("Clean Code", "Robert C. Martin", "Prentice Hall", 2008), 3);
        locadora.adicionarAcervo(
                new Veiculo("Código Limpo para Java", "Robert C. Martin", "Alta Books", 2011), 3);
        locadora.adicionarAcervo(
                new Veiculo("Engenharia de Software", "Ian Sommerville", "Pearson", 2016), 3);
        locadora.adicionarAcervo(
                new Veiculo("Design Patterns", "Erich Gamma", "Addison-Wesley", 1994), 3);
        locadora.adicionarAcervo(
                new Veiculo("Algoritmos: Teoria e Prática", "Thomas H. Cormen", "MIT Press", 2009), 3);

        // Letras
        locadora.adicionarAcervo(new Veiculo("Dom Casmurro", "Machado de Assis", "Garnier", 1899),
                3);
        locadora.adicionarAcervo(
                new Veiculo("Memórias Póstumas de Brás Cubas", "Machado de Assis", "Garnier", 1881), 3);
        locadora.adicionarAcervo(
                new Veiculo("Grande Sertao: Veredas", "João Guimarães Rosa", "José Olympio", 1956), 3);
        locadora.adicionarAcervo(
                new Veiculo("O Cortiço", "Aluísio Azevedo", "Domínio Público", 1890), 3);
        locadora.adicionarAcervo(
                new Veiculo("Capitães da Areia", "Jorge Amado", "José Olympio", 1937), 3);

        // Física
        locadora.adicionarAcervo(
                new Veiculo("Uma Breve História do Tempo", "Stephen Hawking", "Bantam Books", 1988), 3);
        locadora.adicionarAcervo(
                new Veiculo("O Universo numa Casca de Noz", "Stephen Hawking", "Bantam Books", 2001), 3);
        locadora.adicionarAcervo(new Veiculo("Cosmos", "Carl Sagan", "Random House", 1980), 3);
        locadora.adicionarAcervo(new Veiculo("O Tecido do Cosmos", "Brian Greene", "Vintage", 2004),
                3);
        locadora.adicionarAcervo(new Veiculo("A Ordem do Tempo", "Carlo Rovelli", "Objetiva", 2017),
                3);

        // História
        locadora.adicionarAcervo(
                new Veiculo("Sapiens: Uma Breve História da Humanidade", "Yuval Noah Harari",
                        "Harvill Secker", 2011), 3);
        locadora.adicionarAcervo(
                new Veiculo("Homo Deus: Uma Breve História do Amanhã", "Yuval Noah Harari",
                        "Harvill Secker", 2015), 3);
        locadora.adicionarAcervo(
                new Veiculo("A História do Mundo para Quem Tem Pressa", "Emma Marriott", "Valentina",
                        2014), 3);
        locadora.adicionarAcervo(new Veiculo("História do Brasil", "Boris Fausto", "Edusp", 1995),
                3);
        locadora.adicionarAcervo(
                new Veiculo("As Veias Abertas da América Latina", "Eduardo Galeano", "Siglo XXI", 1971),
                3);

        // Medicina
        locadora.adicionarAcervo(
                new Veiculo("O Imperador de Todos os Males", "Siddhartha Mukherjee", "Scribner", 2010),
                3);
        locadora.adicionarAcervo(
                new Veiculo("O Gene: Uma História Íntima", "Siddhartha Mukherjee", "Scribner", 2016), 3);
        locadora.adicionarAcervo(
                new Veiculo("A História da Medicina", "Paul Strathern", "Zahar", 2016), 3);
        locadora.adicionarAcervo(new Veiculo("O Corpo Fala", "Pierre Weil", "Vozes", 1974), 3);
        locadora.adicionarAcervo(
                new Veiculo("Medicina Interna de Harrison", "J. Larry Jameson", "AMGH", 2018), 3);

    }
}
