public class Cliente implements Observador {
    private String ultimaMensagem = "";

    public void atualizar(Pedido pedido, EstadoPedido anterior, EstadoPedido novo) {
        ultimaMensagem = "Seu pedido #" + pedido.getId() + " agora está: " + novo.getNome();
    }

    public String getUltimaMensagem() {
        return ultimaMensagem;
    }
}