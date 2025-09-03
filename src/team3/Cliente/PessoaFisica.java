package team3.Cliente;

public class PessoaFisica extends Cliente {
    private String cpf;
    private String nome;

    public PessoaFisica(String cpf, String nome, String telefone) {
        super(telefone);
        this.cpf = cpf;
        this.nome = nome;
    }

    // Getters e Setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getIdentificador() {
        return cpf;
    }

    @Override
    public String toString() {
        return String.format("Pessoa Física - Nome: %s, CPF: %s, Telefone: %s", 
                nome, cpf, getTelefone());
    }
}
