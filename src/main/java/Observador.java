public interface Observador {
    void atualizar(Pedido pedido, EstadoPedido anterior, EstadoPedido novo);
}