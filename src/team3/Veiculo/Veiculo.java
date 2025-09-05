package team3.Veiculo;

import java.time.LocalDateTime;
import java.time.Year;


/**
 * Entidade de domínio: imutável na identidade (placa), mutável em atributos.
 * RN1: placa é o identificador único.
 * RN2: tipo ∈ {PEQUENO, MEDIO, SUV}
 * RN5: controle de disponibilidade (alugado ou não).
 */
/**
 * Entidade Livro: dados bibliográficos básicos e identidade por (título, autor, ano).
 */
public class Veiculo {
    private String placa;         // identidade única
    private String modelo;
    private TipoVeiculo tipo;
    private boolean disponivel;
    private final LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    /**
     * Cria um livro válido.
     * @throws IllegalArgumentException se algum campo textual for vazio ou o ano estiver fora da faixa [1450, anoAtual]
     */
    public Veiculo(String titulo, String autor, String editora, int anoPublicacao) {
        if (isBlank(titulo)) throw new IllegalArgumentException("Título não pode ser vazio.");
        if (isBlank(autor)) throw new IllegalArgumentException("Autor não pode ser vazio.");
        if (isBlank(editora)) throw new IllegalArgumentException("Editora não pode ser vazia.");

        int anoAtual = Year.now().getValue();
        if (anoPublicacao < 1450 || anoPublicacao > anoAtual) {
            throw new IllegalArgumentException("Ano de publicação inválido: " + anoPublicacao);
        }

        this.placa = placa.toUpperCase().trim();
        this.modelo = modelo.trim();
        this.tipo = tipo;
        this.disponivel = true;
        this.criadoEm = LocalDateTime.now();
        this.atualizadoEm = LocalDateTime.now();
    }

    private static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }


    public String getPlaca() { return placa; }
    public String getModelo() { return modelo; }
    public TipoVeiculo getTipo() { return tipo; }
    public boolean isDisponivel() { return disponivel; }
    public LocalDateTime getCriadoEm() { return criadoEm; }
    public LocalDateTime getAtualizadoEm() { return atualizadoEm; }

    public void alterarModelo(String novoModelo) {
        if (novoModelo == null || novoModelo.isBlank()) throw new IllegalArgumentException("Modelo inválido");
        this.modelo = novoModelo.trim();
        touch();
    }

    public void alterarTipo(TipoVeiculo novoTipo) {
        if (novoTipo == null) throw new IllegalArgumentException("Tipo inválido");
        this.tipo = novoTipo;
        touch();
    }

    public void marcarAlugado() {
        this.disponivel = false;
        touch();
    }

    public void marcarDisponivel() {
        this.disponivel = true;
        touch();
    }

    private void touch() {
        this.atualizadoEm = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("Veiculo{placa='%s', modelo='%s', tipo=%s, disponivel=%s}",
                placa, modelo, tipo, disponivel);
    }

}
