package team3.Veiculo;

import java.util.List;

public interface VeiculoRepository {
    void adicionarVeiculo(Veiculo v);
    Veiculo buscarPorPlaca(String placa);
    List<Veiculo> listarTodos();
    boolean removerVeiculo(String placa);
}
interface Alugavel {
    void alugar();
    void devolver();
}


