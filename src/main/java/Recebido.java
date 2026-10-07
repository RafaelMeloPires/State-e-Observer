public class Recebido implements EstadoPedido {
    public boolean iniciarPreparo(Pedido p) {
        p.setEstado(new EmPreparo());
        return true;
    }
    public boolean entregar(Pedido p) {
        return false;
    }
    public String getNome() {
        return "Recebido";
    }
}