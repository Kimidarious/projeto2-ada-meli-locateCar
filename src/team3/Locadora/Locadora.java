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
            TipoVeiculo tipo = TipoVeiculo.valueOf(tipoStr);
            if (cadastroVeiculo(placa, modelo, tipo)) {
                System.out.println("Veículo cadastrado com sucesso!");
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
}