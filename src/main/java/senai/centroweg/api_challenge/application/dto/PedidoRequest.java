package senai.centroweg.api_challenge.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public record PedidoRequest(

        @JsonProperty("data_pedido")
        @NotNull(message = "A data do pedido não pode ser nula")
        Instant dataPedido
        ) {
}
