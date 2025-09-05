package team3.Veiculo;

import team3.Cliente.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Locadora {
    private final Map<String, Veiculo> acervo = new HashMap<>();
    private final Map<Integer, Cliente> usuarios = new HashMap<>();
    private final List<Aluguel> aluguels = new ArrayList<>();

    // --- ACERVO ---

    public void cadastrarVeiculo(Scanner scanner) {
        System.out.print("Placa: ");
        String placa = scanner.nextLine().trim();

        System.out.print("Modelo: ");
        String modelo = scanner.nextLine().trim();

        System.out.print("Tipo (PEQUENO, MEDIO, SUV): ");
        TipoVeiculo tipo;
        try {
            tipo = TipoVeiculo.valueOf(scanner.nextLine().trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo inválido.");
            return;
        }

        if (acervo.containsKey(placa)) {
            System.out.println("Veículo já cadastrado.");
            return;
        }

        Veiculo veiculo = new Veiculo(placa, modelo, tipo);
        acervo.put(placa, veiculo);
        System.out.println("Veículo cadastrado com sucesso: " + veiculo);
    }


    // Opcional: busca por modelo ou parte do modelo
    public Veiculo pesquisarVeiculoPorNome(String nome) {
        return acervo.values().stream()
                .filter(v -> v.getModelo().toLowerCase().contains(nome.toLowerCase()))
                .findFirst()
                .orElse(null);
    }

    public Veiculo pesquisarVeiculoPorModelo(String modelo) {
        return acervo.values().stream()
                .filter(v -> v.getModelo().equalsIgnoreCase(modelo))
                .findFirst()
                .orElse(null);
    }

    public void listarVeiculos() {
        if (acervo.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }
        acervo.values().forEach(System.out::println);
    }
    public Veiculo pesquisarVeiculoPorPlaca(String placa) {
        return acervo.get(placa);
    }

    public boolean removerVeiculo(String placa) {
        Veiculo v = acervo.remove(placa);
        if (v != null) {
            System.out.println("Veículo removido: " + v);
            return true;
        }
        System.out.println("Veículo não encontrado.");
        return false;
    }

}
