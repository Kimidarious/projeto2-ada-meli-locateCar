package team3.Cliente;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

public abstract class Cliente implements ICliente {
    private static final AtomicInteger PROX_ID = new AtomicInteger(1);
    private static final Pattern TEL_BR = Pattern.compile("^\\(?\\d{2}\\)?\\s?9?\\d{4}-?\\d{4}$");
    private static final Pattern EMAIL = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");

    private final int id;
    private String email;
    private String telefone;

    public Cliente(String email, String telefone) {
        if (!validarEmail(email)) throw new IllegalArgumentException("Email inválido.");
        if (!validarTelefone(telefone)) throw new IllegalArgumentException("Telefone inválido.");

        this.id = PROX_ID.getAndIncrement();
        this.email = email.trim();
        this.telefone = normalizarTelefone(telefone);
    }

    protected static boolean validarTelefone(String telefone) {
        return telefone != null && TEL_BR.matcher(telefone.trim()).matches();
    }

    protected static String normalizarTelefone(String telefone) {
        return telefone.replaceAll("\\D", "");
    }

    protected static boolean validarEmail(String email) {
        return email != null && EMAIL.matcher(email.trim()).matches();
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void incluir() {

    }

    public void alterar() {

    }

    public void listar() {

    }

    public void excluir() {

    }

    public void alterarEmail(String novoEmail) {
        if (!validarEmail(novoEmail)) throw new IllegalArgumentException("Email inválido.");
        this.email = novoEmail.trim();
    }

    @Override
    public String toString() {
        return "%s (id=%d)".formatted(email, id);
    }
}
