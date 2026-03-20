package senai.centroweg.api_challenge.application.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.UUID;

public record ItemPedidoResponseDto(

        @JsonProperty("id")
        UUID id,

        @JsonProperty("nome_produto")
        String nomeProduto,

        @JsonProperty("quantidade")
        Integer quantidade,

        @JsonProperty("preco_unitario")
        BigDecimal precoUnitario,

        @JsonProperty("id_pedido")
        UUID idPedido
) { }
