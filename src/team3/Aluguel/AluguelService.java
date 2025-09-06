package team3.Aluguel;

import team3.Cliente.Cliente;
import team3.Veiculo.Veiculo;
import team3.Veiculo.VeiculoRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AluguelService {
    private final VeiculoRepository veiculoRepo;

    public AluguelService(VeiculoRepository veiculoRepo) {
        this.veiculoRepo = veiculoRepo;
    }

    private final List<Aluguel> alugueis = new ArrayList<>();

    public void realizarLocacao(Cliente cliente, Veiculo veiculo, int dias) {
        if (!veiculo.isDisponivel()) throw new IllegalStateException("Veículo não disponível.");
        Aluguel aluguel = new Aluguel(cliente, veiculo, LocalDate.now(), dias);
        veiculo.marcarAlugado();
        alugueis.add(aluguel);
    }

    public void registrarDevolucao(Aluguel aluguel) {
        aluguel.registrarDevolucao(LocalDate.now());
        aluguel.getLivro().marcarDisponivel();
    }

    public List<Aluguel> listarAlugueisAtivos() {
        return alugueis.stream().filter(a -> !a.isDevolvido()).toList();
    }

    public List<Aluguel> listarAlugueisAtrasados() {
        return alugueis.stream().filter(Aluguel::isAtrasado).toList();
    }
}

