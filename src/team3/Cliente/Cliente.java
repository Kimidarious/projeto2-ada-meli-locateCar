package team3.Cliente;

/**
 * Classe abstrata que representa um cliente genérico no sistema de locação.
 * Define os atributos e comportamentos comuns a todos os tipos de clientes.
 */
public abstract class Cliente {
    protected String telefone;
    
    public Cliente(String telefone) {
        this.telefone = telefone;
    }
    
    // Getters e Setters
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    /**
     * Método abstrato para obter o identificador do cliente (CPF ou CNPJ).
     * @return String contendo o identificador do cliente.
     */
    public abstract String getIdentificador();
    
    /**
     * Método abstrato para obter o nome/razão social do cliente.
     * @return String contendo o nome ou razão social do cliente.
     */
    public abstract String getNome();
    
    @Override
    public abstract String toString();
}
