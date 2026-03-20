package senai.centroweg.api_challenge.application.dto;

import java.time.Instant;
import java.util.UUID;

public record PedidoResponse(

        UUID id,
        Instant dataPedido
) { }
