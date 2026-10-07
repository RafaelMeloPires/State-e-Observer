public interface EstadoPedido {
    boolean iniciarPreparo(Pedido p);
    boolean entregar(Pedido p);
    String getNome();
}