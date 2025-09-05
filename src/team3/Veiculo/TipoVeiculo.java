package team3.Veiculo;

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