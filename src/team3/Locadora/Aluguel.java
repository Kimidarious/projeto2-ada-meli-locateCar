package team3.Locadora;

import team3.Cliente.Cliente;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/**
 * Representa um empréstimo de um livro por um usuário, com datas e cálculo de atraso/multa.
 */
public class Aluguel {
    private final Cliente cliente;
    private final Veiculo veiculo;
    private final LocalDate dataEmprestimo;
    private final int quantidadeDeDias; // regra do usuário no momento da criação
    private LocalDate dataDevolucao;

    /**
     * Cria um empréstimo válido.
     * Regras:
     * - usuario e livro não podem ser nulos.
     * - usuario deve poder pegar emprestimo no momento da criação.
     * - dataEmprestimo não pode ser futura.
     * - quantidadeDeDias > 0 e, preferencialmente, <= getDiasEmprestimo() do usuario.
     */
    public Aluguel(Cliente cliente, Veiculo veiculo, LocalDate dataEmprestimo, int quantidadeDeDias) {
        if (cliente == null) throw new IllegalArgumentException("Usuário inválido.");
        if (veiculo == null) throw new IllegalArgumentException("Livro inválido.");
        if (dataEmprestimo == null) throw new IllegalArgumentException("Data de empréstimo inválida.");
        if (dataEmprestimo.isAfter(LocalDate.now())) throw new IllegalArgumentException("Data de empréstimo no futuro.");
        if (quantidadeDeDias <= 0) throw new IllegalArgumentException("Quantidade de dias deve ser positiva.");
        if (!cliente.podePegarEmprestimo()) throw new IllegalArgumentException("Usuário não está apto a emprestar.");
        // Opcional: restringir ao prazo padrão do usuário
        if (quantidadeDeDias > cliente.getDiasEmprestimo()) {
            throw new IllegalArgumentException("Prazo solicitado excede o permitido para o usuário.");
        }

        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataEmprestimo = dataEmprestimo;
        this.quantidadeDeDias = quantidadeDeDias;
    }

    public Cliente getUsuario() { return cliente; }
    public Veiculo getLivro() { return veiculo; }
    public LocalDate getDataEmprestimo() { return dataEmprestimo; }
    public int getQuantidadeDeDias() { return quantidadeDeDias; }
    public LocalDate getDataDevolucao() { return dataDevolucao; }

    public LocalDate getDataPrevistaDevolucao() {
        return dataEmprestimo.plusDays(quantidadeDeDias);
    }

    public boolean isDevolvido() {
        return dataDevolucao != null;
    }

    public boolean isAtrasado() {
        LocalDate ref = isDevolvido() ? dataDevolucao : LocalDate.now();
        return ref.isAfter(getDataPrevistaDevolucao());
    }

    public int diasDeAtraso() {
        LocalDate ref = isDevolvido() ? dataDevolucao : LocalDate.now();
        long diff = ChronoUnit.DAYS.between(getDataPrevistaDevolucao(), ref);
        return (int) Math.max(0, diff);
    }

    /**
     * Registra devolução na data informada.
     * @throws IllegalStateException se já tiver sido devolvido.
     */
    public void registrarDevolucao(LocalDate dataDevolucao) {
        if (dataDevolucao == null) throw new IllegalArgumentException("Data de devolução inválida.");
        if (isDevolvido()) throw new IllegalStateException("Empréstimo já devolvido.");
        if (dataDevolucao.isBefore(dataEmprestimo)) throw new IllegalArgumentException("Devolução antes do empréstimo.");
        this.dataDevolucao = dataDevolucao;
    }

    /**
     * Calcula o valor da multa com base no tipo de usuário (polimorfismo).
     */
    public double valorMulta() {
        int atraso = diasDeAtraso();
        return atraso <= 0 ? 0.0 : cliente.calcularMulta(atraso);
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
            "usuario='" + cliente.getNome() + '\'' +
            ", livro='" + veiculo.getTitulo() + '\'' +
            ", dataEmprestimo=" + dataEmprestimo +
            ", dataPrevistaDevolucao=" + getDataPrevistaDevolucao() +
            ", dataDevolucao=" + (dataDevolucao != null ? dataDevolucao : "—") +
            ", diasAtraso=" + diasDeAtraso() +
            ", valorMulta=" + valorMulta() +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluguel)) return false;
        Aluguel that = (Aluguel) o;
        return Objects.equals(cliente.getId(), that.cliente.getId())
            && Objects.equals(veiculo, that.veiculo)
            && Objects.equals(dataEmprestimo, that.dataEmprestimo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliente.getId(), veiculo, dataEmprestimo);
    }
}
