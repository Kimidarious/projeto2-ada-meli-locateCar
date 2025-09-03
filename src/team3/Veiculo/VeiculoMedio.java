package team3.Veiculo;

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
