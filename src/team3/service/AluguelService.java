package team3.service;

import team3.domain.model.*;
import team3.repository.IRepository;
import java.time.Duration;
import java.time.LocalDateTime;

public class AluguelService {
    // Depende da ABSTRAÇÃO (Interface), não da implementação concreta
    private final IRepository<Veiculo, String> veiculoRepository;
    private final IRepository<Cliente, String> clienteRepository;

    public AluguelService(IRepository<Veiculo, String> veiculoRepository, IRepository<Cliente, String> clienteRepository) {
        this.veiculoRepository = veiculoRepository;
        this.clienteRepository = clienteRepository;
    }

    public Aluguel alugarVeiculo(String placa, String documentoCliente, String local) {
        // Lógica para alugar, verificando disponibilidade (RN5)
        // ...
        return new Aluguel(/* ... */);
    }

    public void devolverVeiculo(Aluguel aluguel) {
        LocalDateTime dataDevolucao = LocalDateTime.now();
        aluguel.setDataDevolucao(dataDevolucao);

        long diarias = calcularDiarias(aluguel.getDataAluguel(), dataDevolucao); // RN4
        double valorBase = diarias * aluguel.getVeiculo().getTipo().getValorDiaria();
        double desconto = calcularDesconto(aluguel.getCliente(), diarias); // RN7
        double valorFinal = valorBase * (1 - desconto);

        System.out.println("Valor a pagar: R$ " + valorFinal);

        // Atualiza a disponibilidade do veículo (RN5)
        Veiculo veiculo = aluguel.getVeiculo();
        veiculo.setDisponivel(true);
        veiculoRepository.alterar(veiculo);
    }

    private long calcularDiarias(LocalDateTime inicio, LocalDateTime fim) {
        // RN4: Horas quebradas contam como diária completa
        Duration duracao = Duration.between(inicio, fim);
        long horas = duracao.toHours();
        return (horas / 24) + (horas % 24 > 0 ? 1 : 0);
    }

    private double calcularDesconto(Cliente cliente, long diarias) {
        // RN7: Regras de desconto (Polimorfismo implícito)
        if (cliente instanceof PessoaFisica && diarias > 5) {
            return 0.05; // 5% de desconto
        }
        if (cliente instanceof PessoaJuridica && diarias > 3) {
            return 0.10; // 10% de desconto
        }
        return 0.0;
    }
}
