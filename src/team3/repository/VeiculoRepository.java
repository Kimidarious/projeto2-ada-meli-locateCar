package team3.repository;

import team3.domain.model.Veiculo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VeiculoRepository implements IRepository<Veiculo, String> {

    private final List<Veiculo> veiculos = new ArrayList<>();

    @Override
    public void cadastrar(Veiculo veiculo) {
        // RN1: Veículos não podem ser repetidos
        if (buscarPorId(veiculo.getPlaca()).isEmpty()) {
            veiculos.add(veiculo);
        } else {
            System.out.println("Erro: Veículo com a placa " + veiculo.getPlaca() + " já existe.");
        }
    }

    @Override
    public Optional<Veiculo> buscarPorId(String placa) {
        return veiculos.stream()
                .filter(v -> v.getPlaca().equalsIgnoreCase(placa))
                .findFirst();
    }
}
