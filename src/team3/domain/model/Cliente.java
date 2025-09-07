package team3.domain.model;

public abstract class Cliente {
    private String nome;
    private String email;
    // ... outros atributos comuns

    public abstract String getDocumento(); // Método abstrato, cada filho implementa o seu

    // Getters e Setters...
}