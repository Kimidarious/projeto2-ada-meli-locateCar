package team3.Locadora;

import team3.Veiculo.TipoVeiculo;
import team3.Veiculo.Veiculo;
import team3.Cliente.Cliente;

import java.util.*;
import java.util.stream.Collectors;
import java.util.Scanner;

public class Locadora {
    private final Map<String, Veiculo> acervo = new HashMap<>();
    private final Map<String, Cliente> clientes = new HashMap<>();

    public boolean cadastroVeiculo(String placa, String modelo, TipoVeiculo tipo) {
        if (placa == null || placa.isBlank()) return false;

        String key = placa.toUpperCase();
        if (acervo.containsKey(key)) return false;

        Veiculo veiculo = new Veiculo(key, modelo, tipo);
        acervo.put(key, veiculo);
        return true;
    }

    public void cadastrarVeiculo(Scanner scanner) {
        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();

        System.out.print("Digite o modelo do veículo: ");
        String modelo = scanner.nextLine();

        System.out.println("Tipos disponíveis: ");
        for (TipoVeiculo tipo : TipoVeiculo.values()) {
            System.out.println("- " + tipo);
        }

        System.out.print("Digite o tipo do veículo: ");
        String tipoStr = scanner.nextLine().toUpperCase();

        try {
<<<<<<< HEAD
            TipoVeiculo tipo = TipoVeiculo.valueOf(tipoStr);
            if (cadastroVeiculo(placa, modelo, tipo)) {
                System.out.println("Veículo cadastrado com sucesso!");
=======
            Cliente cliente = null;
            switch (tipo) {
                case 1 -> {
                    System.out.print("Curso: ");
                    String curso = scanner.nextLine().trim();
                    System.out.print("Período (Manhã/Tarde/Noite): ");
                    String periodo = scanner.nextLine().trim();
                    cliente = new ClientePF(email, telefone);
                }
                case 3 -> {
                    System.out.print("Departamento: ");
                    String departamento = scanner.nextLine().trim();
                    cliente = new ClientePJ(email, telefone);
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
            System.out.println("Usuário cadastrado: "  + " (id=" + cliente.getId() + ")");
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
            System.out.println("Email: " + u.getEmail());

            if (u instanceof ClientePF clientePF) {
                System.out.println("Tipo: " + "Aluno");
            } else if (u instanceof ClientePJ clientePJ) {
                System.out.println("Tipo: " + "Professor");
>>>>>>> develop
            } else {
                System.out.println("Erro: Veículo já existe ou placa inválida.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de veículo inválido!");
        }
    }

    public void cadastrarCliente(Scanner scanner) {
        System.out.println("Cadastro de cliente - implementar");
    }

<<<<<<< HEAD
    public Veiculo pesquisarVeiculoPorPlaca(String placa) {
        if (placa == null) return null;
        return acervo.get(placa.toUpperCase());
    }

    public List<Veiculo> pesquisarVeiculoPorModelo(String modelo) {
        if (modelo == null) return Collections.emptyList();
        String m = modelo.toLowerCase();
        return acervo.values().stream()
                .filter(v -> v.getModelo().toLowerCase().contains(m))
                .collect(Collectors.toList());
    }

    public boolean removerVeiculo(String placa) {
        if (placa == null) return false;
        return acervo.remove(placa.toUpperCase()) != null;
    }

    public List<Veiculo> listarVeiculos() {
        return new ArrayList<>(acervo.values());
    }

    public void listarVeiculosDisponiveis() {
        System.out.println("=== VEÍCULOS DISPONÍVEIS ===");
        acervo.values().stream()
                .filter(Veiculo::isDisponivel)
                .forEach(System.out::println);
    }

    public void adicionarCliente(String id, Cliente cliente) {
        clientes.put(id, cliente);
    }

    public void listarClientes() {
        System.out.println("=== CLIENTES CADASTRADOS ===");
        clientes.values().forEach(System.out::println);
    }

    // Métodos que precisam ser implementados:
    public void realizarLocacao(Scanner scanner) {
        System.out.println("Locação - implementar");
    }

    public void registrarDevolucao(Scanner scanner) {
        System.out.println("Devolução - implementar");
    }

    public void listarLocacoesAtivas() {
        System.out.println("Locações ativas - implementar");
    }

    public void listarLocacoesAtrasadas() {
        System.out.println("Locações atrasadas - implementar");
    }

    public void editarCliente(Scanner scanner) {
        System.out.println("Editar cliente - implementar");
    }

    public void removerCliente(Scanner scanner) {
        System.out.println("Remover cliente - implementar");
    }
=======
    // --- EMPRÉSTIMOS ---

    public void realizarEmprestimo(Scanner scanner) {
        listarUsuarios();
        System.out.print("Informe o ID do usuário: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine();
        Cliente cliente = usuarios.get(idUsuario);

        if (cliente == null){ // || !cliente.podePegarEmprestimo()) {
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
        Aluguel emp = new Aluguel(cliente, veiculo, hoje, 10);
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
                    System.out.println("Multa: R$ " );//+ e.valorMulta());
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
>>>>>>> develop
}