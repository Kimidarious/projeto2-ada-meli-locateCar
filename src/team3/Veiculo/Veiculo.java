package team3.Veiculo;

/**
 * Classe abstrata que representa um veículo genérico no sistema de locação.
 * Contém os atributos e comportamentos comuns a todos os tipos de veículos.
 */
public abstract class Veiculo {
    protected String placa;
    protected String modelo;
    protected String marca;
    protected int ano;
    protected TipoVeiculo tipo;
    protected boolean disponivel;

    public Veiculo(String placa, String modelo, String marca, int ano, TipoVeiculo tipo) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.tipo = tipo;
        this.disponivel = true; // Por padrão, o veículo começa disponível
    }

    // Getters e Setters
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public TipoVeiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVeiculo tipo) {
        this.tipo = tipo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return String.format("Veículo: %s %s %d, Placa: %s, Tipo: %s, %s",
                marca, modelo, ano, placa, tipo, disponivel ? "Disponível" : "Indisponível");
    }
}
