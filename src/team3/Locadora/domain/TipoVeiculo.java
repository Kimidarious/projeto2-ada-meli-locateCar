package team3.Locadora.domain;

public enum TipoVeiculo {
    PEQUENO,MEDIO,SUV;

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
