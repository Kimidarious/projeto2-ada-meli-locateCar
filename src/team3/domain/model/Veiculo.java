package team3.domain.model;

import br.com.adatech.locatecar.domain.enums.TipoVeiculo;

public class Veiculo {
    private String placa; // Identificador único
    private String modelo;
    private String fabricante;
    private boolean disponivel = true;
    private TipoVeiculo tipo;

    // Construtor, Getters e Setters...

    public String getPlaca() {
        return placa;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public TipoVeiculo getTipo() {
        return tipo;
    }
    // ... outros getters e setters
}