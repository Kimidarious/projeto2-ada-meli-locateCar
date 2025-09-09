package team3.Veiculo;

import java.time.LocalDateTime;
import java.util.Objects;

public class Veiculo {
    private String placa;         // identidade única
    private String modelo;
    private TipoVeiculo tipo;
    private boolean disponivel;
    private final LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    public Veiculo(String placa, String modelo, TipoVeiculo tipo) {
        if (placa == null || placa.isBlank()) throw new IllegalArgumentException("Placa inválida");
        if (modelo == null || modelo.isBlank()) throw new IllegalArgumentException("Modelo inválido");
        if (tipo == null) throw new IllegalArgumentException("Tipo inválido");

        this.placa = placa.toUpperCase().trim();
        this.modelo = modelo.trim();
        this.tipo = tipo;
        this.disponivel = true;
        this.criadoEm = LocalDateTime.now();
        this.atualizadoEm = LocalDateTime.now();
    }

    public String getPlaca() { return placa; }
    public String getModelo() { return modelo; }
    public TipoVeiculo getTipo() { return tipo; }
    public boolean isDisponivel() { return disponivel; }

    public void marcarAlugado() { disponivel = false; touch(); }
    public void marcarDisponivel() { disponivel = true; touch(); }

    private void touch() { atualizadoEm = LocalDateTime.now(); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Veiculo veiculo)) return false;
        return placa.equals(veiculo.placa);
    }

    @Override
    public int hashCode() { return Objects.hash(placa); }

    @Override
    public String toString() {
        return "Veiculo{" +
                "placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", tipo=" + tipo +
                ", disponivel=" + disponivel +
                '}';

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
