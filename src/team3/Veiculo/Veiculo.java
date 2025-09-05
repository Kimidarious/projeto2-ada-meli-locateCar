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
    }
}
