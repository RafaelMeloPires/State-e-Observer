public class Entregue implements EstadoPedido {
    public boolean iniciarPreparo(Pedido p) {
        return false;
    }
    public boolean entregar(Pedido p) {
        return false;
    }
    public String getNome() {
        return "Entregue";
    }
}