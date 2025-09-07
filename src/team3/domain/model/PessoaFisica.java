package team3.domain.model;

import team3.domain.model.Cliente;

public class PessoaFisica extends Cliente {
    private final String cpf; // Identificador único

    public PessoaFisica(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String getDocumento() {
        return this.cpf;
    }
}
