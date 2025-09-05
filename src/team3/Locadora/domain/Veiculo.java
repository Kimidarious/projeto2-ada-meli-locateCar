package team3.Locadora.domain;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.Objects;


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
    private String placa;         // identidade
    private String modelo;              // parte do “nome” que usaremos na busca
    private TipoVeiculo tipo;
    private boolean disponivel;         // true = disponível, false = alugado
    private LocalDateTime criadoEm;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Veiculo)) return false;
        Veiculo veiculo = (Veiculo) o;
        return anoPublicacao == veiculo.anoPublicacao
            && titulo.equalsIgnoreCase(veiculo.titulo)
            && autor.equalsIgnoreCase(veiculo.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo.toLowerCase(), autor.toLowerCase(), anoPublicacao);
    }

    @Override
    public String toString() {
        return "Livro{" +
            "titulo='" + titulo + '\'' +
            ", autor='" + autor + '\'' +
            ", editora='" + editora + '\'' +
            ", anoPublicacao=" + anoPublicacao +
            '}';
    }
}
