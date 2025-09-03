package team3.Veiculo;

/**
 * Enum que representa os tipos de veículos disponíveis para locação,
 * juntamente com seus respectivos valores de diária.
 */
public enum TipoVeiculo {
    PEQUENO(100.00),  // R$ 100,00 por dia
    MEDIO(150.00),    // R$ 150,00 por dia
    SUV(200.00);      // R$ 200,00 por dia

    private final double valorDiaria;

    TipoVeiculo(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }
}
