public class Pedido {
    private int id;
    private EstadoPedido estado = new Recebido();
    private Observador obs1;
    private Observador obs2;

    public Pedido(int id) { this.id = id; }

    public int getId() { return id; }
    public EstadoPedido getEstado() { return estado; }

    public boolean iniciarPreparo() { return estado.iniciarPreparo(this); }
    public boolean entregar() { return estado.entregar(this); }


    public void setEstado(EstadoPedido novo) {
        EstadoPedido anterior = estado;
        estado = novo;
        if (obs1 != null) obs1.atualizar(this, anterior, novo);
        if (obs2 != null) obs2.atualizar(this, anterior, novo);
    }

    public void adicionarObservador(Observador o) {
        if (obs1 == null) obs1 = o;
        else if (obs2 == null) obs2 = o;
    }

    public void removerObservador(Observador o) {
        if (obs1 == o) obs1 = null;
        else if (obs2 == o) obs2 = null;
    }
}