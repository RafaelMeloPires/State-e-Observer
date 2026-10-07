public class EmPreparo implements EstadoPedido {
    public boolean iniciarPreparo(Pedido p) {
        return false;
    }
    public boolean entregar(Pedido p) {
        p.setEstado(new Entregue());
        return true;
    }
    public String getNome() {
        return "Em Preparo";
    }
}