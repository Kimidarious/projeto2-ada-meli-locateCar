package team3.Veiculo;

<<<<<<< HEAD
public enum TipoVeiculo {
    PEQUENO(100.00),
    MEDIO(150.00),
    SUV(200.00);

    private final double dailyRate;

    TipoVeiculo(double dailyRate) {  // Corrigido o nome do construtor
        this.dailyRate = dailyRate;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public static boolean isValid(String valor){
        if(valor == null) return false;
        try{
            TipoVeiculo.valueOf(valor.toUpperCase());
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
=======
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
>>>>>>> develop
