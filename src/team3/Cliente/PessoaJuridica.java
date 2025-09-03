package team3.Cliente;

public class PessoaJuridica extends Cliente {
    private String cnpj;
    private String razaoSocial;

    public PessoaJuridica(String cnpj, String razaoSocial, String telefone) {
        super(telefone);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }

    // Getters e Setters
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    @Override
    public String getIdentificador() {
        return cnpj;
    }

    @Override
    public String getNome() {
        return razaoSocial;
    }

    @Override
    public String toString() {
        return String.format("Pessoa Jurídica - Razão Social: %s, CNPJ: %s, Telefone: %s", 
                razaoSocial, cnpj, getTelefone());
    }
}
