package team3.domain.model;

public class PessoaJuridica extends Cliente {
    private final String cnpj; // Identificador único

    public PessoaJuridica(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String getDocumento() {
        return this.cnpj;
    }
}
