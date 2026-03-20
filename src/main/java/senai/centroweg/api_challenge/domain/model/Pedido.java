package senai.centroweg.api_challenge.domain.model;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "data_pedido", nullable = false, unique = false)
    private Instant dataPedido;

    public Pedido(Instant dataPedido) {
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
