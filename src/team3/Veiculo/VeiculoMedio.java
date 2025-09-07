package team3.Veiculo;

import team3.domain.enums.TipoVeiculo;
import team3.domain.model.Veiculo;

/**
 * Classe que representa um veículo do tipo MÉDIO no sistema de locação.
 */
public class VeiculoMedio extends Veiculo {
    
    public VeiculoMedio(String placa, String modelo, String marca, int ano) {
        super(placa, modelo, marca, ano, TipoVeiculo.MEDIO);
    }
    
    @Override
    public String toString() {
        return "[MÉDIO] " + super.toString();
    }
}
