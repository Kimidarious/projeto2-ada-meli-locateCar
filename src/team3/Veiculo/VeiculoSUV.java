package team3.Veiculo;

import team3.domain.enums.TipoVeiculo;
import team3.domain.model.Veiculo;

/**
 * Classe que representa um veículo do tipo SUV no sistema de locação.
 */
public class VeiculoSUV extends Veiculo {
    
    public VeiculoSUV(String placa, String modelo, String marca, int ano) {
        super(placa, modelo, marca, ano, TipoVeiculo.SUV);
    }
    
    @Override
    public String toString() {
        return "[SUV] " + super.toString();
    }
}
