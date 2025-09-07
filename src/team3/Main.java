package team3;

import team3.domain.model.Cliente;
import team3.domain.model.Veiculo;
import team3.repository.*;
import team3.service.*;
// ... outras importações

public class Main {
    public static void main(String[] args) {
        // Injeção de Dependências manual
        IRepository<Veiculo, String> veiculoRepository = new VeiculoRepository();
        IRepository<Cliente, String> clienteRepository = new ClienteRepository();

        VeiculoService veiculoService = new VeiculoService(veiculoRepository);
        ClienteService clienteService = new ClienteService(clienteRepository);
        AluguelService aluguelService = new AluguelService(veiculoRepository, clienteRepository);

        // Aqui começa o seu menu interativo com Scanner
        // Ex:
        // 1 - Cadastrar Veículo
        // 2 - Cadastrar Cliente
        // 3 - Alugar Veículo
        // ...
    }
}