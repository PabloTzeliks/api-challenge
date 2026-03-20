package senai.centroweg.api_challenge.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

import java.time.Instant;

public record PedidoRequest(

        @JsonProperty("data_pedido")
        @NotBlank
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
        Instant dataPedido
        ) {
}
