package senai.centroweg.api_challenge.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import senai.centroweg.api_challenge.domain.model.ItemPedido;

import java.util.UUID;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, UUID> {
}
