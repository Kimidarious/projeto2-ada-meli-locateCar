package team3.Cliente;

public class ClientePJ extends Cliente {

    public ClientePJ(String email, String telefone) {
        super(email, telefone);
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + getId() +
                '}';
    }
}