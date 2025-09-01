package team3.Locadora;

import team3.Cliente.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Locadora {
    private final Map<Veiculo, Integer> acervo = new HashMap<>();
    private final Map<Integer, Cliente> usuarios = new HashMap<>();
    private final List<Aluguel> aluguels = new ArrayList<>();

    // --- ACERVO ---

    public void cadastrarLivro(Scanner scanner) {
        System.out.print("Título: ");
        String titulo = scanner.nextLine().trim();
        System.out.print("Autor: ");
        String autor = scanner.nextLine().trim();
        System.out.print("Editora: ");
        String editora = scanner.nextLine().trim();

        System.out.print("Ano de publicação: ");
        int ano = scanner.nextInt();

        Veiculo veiculo;
        try {
            veiculo = new Veiculo(titulo, autor, editora, ano);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar livro: " + e.getMessage());
            return;
        }

        System.out.print("Quantidade total: ");
        int quantidade = scanner.nextInt();
        if (adicionarAcervo(veiculo, quantidade)) {
            System.out.println(quantidade + " exemplar(es) de '" + veiculo.getTitulo() + "' adicionado(s) com sucesso.");
        }
    }

    public Veiculo pesquisarLivroPorTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) return null;
        for (Veiculo veiculo : acervo.keySet()) {
            if (veiculo.getTitulo().equalsIgnoreCase(titulo.trim())) {
                return veiculo;
            }
        }
        return null;
    }

    public boolean adicionarAcervo(Veiculo veiculo, int quantidade) {
        if (veiculo == null) {
            System.out.println("Livro inválido.");
            return false;
        }
        if (quantidade <= 0) {
            System.out.println("A quantidade deve ser maior que zero.");
            return false;
        }
        acervo.put(veiculo, acervo.getOrDefault(veiculo, 0) + quantidade);
        return true;
    }

    public boolean removerLivro(Veiculo veiculo, int quantidade) {
        if (veiculo == null) {
            System.out.println("Livro não encontrado.");
            return false;
        }
        if (quantidade <= 0) {
            System.out.println("Quantidade deve ser maior que zero.");
            return false;
        }
        Integer atual = acervo.get(veiculo);
        if (atual == null) {
            System.out.println("O livro '" + veiculo.getTitulo() + "' não foi encontrado no acervo.");
            return false;
        }
        if (atual > quantidade) {
            acervo.put(veiculo, atual - quantidade);
            System.out.println(quantidade + " exemplar(es) de '" + veiculo.getTitulo() + "' removido(s).");
            return true;
        } else if (atual == quantidade) {
            acervo.remove(veiculo);
            System.out.println("Todos os exemplares de '" + veiculo.getTitulo() + "' foram removidos.");
            return true;
        } else {
            System.out.println("Não há exemplares suficientes de '" + veiculo.getTitulo() + "'. Apenas " + atual + " em estoque.");
            return false;
        }
    }

    public void listarAcervo() {
        if (acervo.isEmpty()) {
            System.out.println("A biblioteca está vazia.");
            return;
        }
        System.out.println("Acervo da Biblioteca:");
        for (Map.Entry<Veiculo, Integer> e : acervo.entrySet()) {
            System.out.println("  " + e.getKey().getTitulo() + " - Quantidade: " + e.getValue());
        }
    }

    // --- USUÁRIOS ---

    public void cadastrarUsuario(Scanner scanner) {
        System.out.println("Informe o tipo de usuário (1- Aluno, 2- Aluno Bolsista, 3- Professor, 4- Professor Estagiário): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // consumir quebra

        System.out.print("Nome: ");
        String nome = scanner.nextLine().trim();
        System.out.print("Email: ");
        String email = scanner.nextLine().trim();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine().trim();

        try {
            Cliente cliente = null;
            switch (tipo) {
                case 1 -> {
                    System.out.print("Curso: ");
                    String curso = scanner.nextLine().trim();
                    System.out.print("Período (Manhã/Tarde/Noite): ");
                    String periodo = scanner.nextLine().trim();
                    cliente = new PessoaFisica(nome, email, telefone, curso, periodo);
                }
                case 3 -> {
                    System.out.print("Departamento: ");
                    String departamento = scanner.nextLine().trim();
                    cliente = new PessoaJuridica(nome, email, telefone, departamento);
                }
                default -> {
                    System.out.println("Tipo inválido!");
                    return;
                }
            }
            if (usuarios.containsKey(cliente.getId())) {
                System.out.println("Já existe usuário com esse ID.");
                return;
            }
            adicionarUsuario(cliente.getId(), cliente);
            System.out.println("Usuário cadastrado: " + cliente.getNome() + " (id=" + cliente.getId() + ")");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }

    public void adicionarUsuario(int idUsuario, Cliente cliente) {
        usuarios.put(idUsuario, cliente);
    }

    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }
        for (Cliente u : usuarios.values()) {
            System.out.println("ID: " + u.getId());
            System.out.println("Nome: " + u.getNome());
            System.out.println("Email: " + u.getEmail());

            if (u instanceof PessoaFisica pessoaFisica) {
                System.out.println("Tipo: " + "Aluno");
                System.out.println("Curso: " + pessoaFisica.getCurso());
                System.out.println("Período: " + pessoaFisica.getPeriodo());
            } else if (u instanceof PessoaJuridica pessoaJuridica) {
                System.out.println("Tipo: " + "Professor");
                System.out.println("Departamento: " + pessoaJuridica.getDepartamento());
            } else {
                System.out.println("Tipo: Usuário desconhecido.");
            }
            System.out.println("--------------------------------");
        }
    }

    public void editarUsuario(Scanner scanner) {
        System.out.print("Informe o ID do usuário a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Cliente cliente = usuarios.get(id);
        if (cliente == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }
        System.out.print("Novo email: ");
        String novoEmail = scanner.nextLine().trim();
        try {
            cliente.alterarEmail(novoEmail);
            System.out.println("Email atualizado com sucesso.");
        } catch (IllegalArgumentException e) {
            System.out.println("Email inválido: " + e.getMessage());
        }
    }

    public void removerUsuario(Scanner scanner) {
        System.out.print("Informe o ID do usuário a remover: ");
        int id = scanner.nextInt();
        if (usuarios.remove(id) != null) {
            System.out.println("Usuário removido com sucesso.");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    // --- EMPRÉSTIMOS ---

    public void realizarEmprestimo(Scanner scanner) {
        listarUsuarios();
        System.out.print("Informe o ID do usuário: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine();
        Cliente cliente = usuarios.get(idUsuario);

        if (cliente == null || !cliente.podePegarEmprestimo()) {
            System.out.println("Usuário inválido ou não pode pegar empréstimo.");
            return;
        }

        listarAcervo();
        System.out.print("Informe o título do livro: ");
        String titulo = scanner.nextLine();
        Veiculo veiculo = pesquisarLivroPorTitulo(titulo);
        if (veiculo == null) {
            System.out.println("Livro não encontrado.");
            return;
        }
        if (!removerLivro(veiculo, 1)) return;

        LocalDate hoje = LocalDate.now();
        Aluguel emp = new Aluguel(cliente, veiculo, hoje, cliente.getDiasEmprestimo());
        aluguels.add(emp);
        System.out.println("Empréstimo registrado com sucesso.");
    }

    public void listarEmprestimosAtivos() {
        aluguels.stream()
            .filter(e -> !e.isDevolvido())
            .forEach(System.out::println);
    }

    public void listarEmprestimosAtrasados() {
        aluguels.stream()
            .filter(Aluguel::isAtrasado)
            .forEach(e -> {
                System.out.println(e);
                System.out.println("Dias de atraso: " + e.diasDeAtraso());
                System.out.println("Multa: R$ " + e.valorMulta());
            });
    }

    public void registrarDevolucao(Scanner scanner) {
        listarUsuarios();
        System.out.print("Informe o ID do usuário: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        List<Aluguel> ativosDoUsuario = aluguels.stream()
            .filter(e -> e.getUsuario().getId() == id && !e.isDevolvido())
            .collect(Collectors.toList());

        if (ativosDoUsuario.isEmpty()) {
            System.out.println("Nenhum empréstimo ativo encontrad0.");
            return;
        }

        for (int i = 0; i < ativosDoUsuario.size(); i++) {
            System.out.println(i + ". " + ativosDoUsuario.get(i));
        }

        System.out.print("Escolha o número do empréstimo a devolver: ");
        int index = scanner.nextInt();
        if (index < 0 || index >= ativosDoUsuario.size()) {
            System.out.println("Opção inválida.");
            return;
        }

        Aluguel emp = ativosDoUsuario.get(index);
        if (adicionarAcervo(emp.getLivro(), 1)) {
            try {
                emp.registrarDevolucao(LocalDate.now());
                System.out.println("Devolução registrada com sucesso.");
            } catch (IllegalStateException | IllegalArgumentException ex) {
                System.out.println("Erro ao registrar devolução: " + ex.getMessage());
            }
        } else {
            System.out.println("Falha ao devolver: livro não pertence ao acervo.");
        }
    }
}
