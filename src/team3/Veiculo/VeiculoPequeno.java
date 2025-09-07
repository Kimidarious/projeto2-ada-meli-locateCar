package team3.Veiculo;

import team3.domain.enums.TipoVeiculo;
import team3.domain.model.Veiculo;

/**
 * Classe que representa um veículo do tipo PEQUENO no sistema de locação.
 */
public class VeiculoPequeno extends Veiculo {
    
    public VeiculoPequeno(String placa, String modelo, String marca, int ano) {
        super(placa, modelo, marca, ano, TipoVeiculo.PEQUENO);
    }
    
    @Override
    public String toString() {
        return "[PEQUENO] " + super.toString();
    }
}
