package senai.centroweg.api_challenge.application.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.UUID;

public record PedidoResponseDto(

        @JsonProperty("id")
        UUID id,

        @JsonProperty("data_pedido")
        Instant dataPedido
) { }
