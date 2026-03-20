package senai.centroweg.api_challenge.domain.model;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "data_pedido", nullable = false, unique = false)
    private Instant dataPedido;

    public Pedido(Instant dataPedido) {
        this.id = UUID.randomUUID();
        this.dataPedido = dataPedido;
    }

    public Pedido(UUID id, Instant dataPedido) {
        this.id = id;
        this.dataPedido = dataPedido;
    }

    // Construtos para o JPA
    public Pedido() { }

    public UUID getId() {
        return id;
    }

    public Instant getDataPedido() {
        return dataPedido;
    }
}
