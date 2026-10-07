import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    @Test
    void pedidoComecaRecebido() {
        Pedido p = new Pedido(12);
        assertEquals("Recebido", p.getEstado().getNome());
    }

    @Test
    void iniciarPreparoMudaParaEmPreparo() {
        Pedido p = new Pedido(12);
        assertTrue(p.iniciarPreparo());
        assertEquals("Em Preparo", p.getEstado().getNome());
    }

    @Test
    void entregarEmRecebidoEhRecusado() {
        Pedido p = new Pedido(12);
        assertFalse(p.entregar());
        assertEquals("Recebido", p.getEstado().getNome());
    }

    @Test
    void iniciarPreparoDuasVezesEhRecusado() {
        Pedido p = new Pedido(12);
        p.iniciarPreparo();
        assertFalse(p.iniciarPreparo());
        assertEquals("Em Preparo", p.getEstado().getNome());
    }

    @Test
    void fluxoCompletoTerminaEntregue() {
        Pedido p = new Pedido(12);
        assertTrue(p.iniciarPreparo());
        assertTrue(p.entregar());
        assertEquals("Entregue", p.getEstado().getNome());
    }

    @Test
    void estadoFinalRecusaTudo() {
        Pedido p = new Pedido(12);
        p.iniciarPreparo();
        p.entregar();
        assertFalse(p.iniciarPreparo());
        assertFalse(p.entregar());
        assertEquals("Entregue", p.getEstado().getNome());
    }

    @Test
    void clienteRecebeMensagemAoMudarEstado() {
        Pedido p = new Pedido(12);
        Cliente c = new Cliente();
        p.adicionarObservador(c);
        p.iniciarPreparo();
        assertEquals("Seu pedido #12 agora está: Em Preparo", c.getUltimaMensagem());
    }

    @Test
    void operacaoInvalidaNaoNotifica() {
        Pedido p = new Pedido(12);
        Cliente c = new Cliente();
        p.adicionarObservador(c);
        p.entregar();
        assertEquals("", c.getUltimaMensagem());
    }

    @Test
    void observadorRemovidoNaoRecebe() {
        Pedido p = new Pedido(12);
        Cliente c = new Cliente();
        p.adicionarObservador(c);
        p.iniciarPreparo();
        p.removerObservador(c);
        p.entregar();
        assertEquals("Seu pedido #12 agora está: Em Preparo", c.getUltimaMensagem());
    }

    @Test
    void doisObservadoresSaoNotificados() {
        Pedido p = new Pedido(12);
        Cliente c1 = new Cliente();
        Cliente c2 = new Cliente();
        p.adicionarObservador(c1);
        p.adicionarObservador(c2);
        p.iniciarPreparo();
        assertEquals("Seu pedido #12 agora está: Em Preparo", c1.getUltimaMensagem());
        assertEquals("Seu pedido #12 agora está: Em Preparo", c2.getUltimaMensagem());
    }
}