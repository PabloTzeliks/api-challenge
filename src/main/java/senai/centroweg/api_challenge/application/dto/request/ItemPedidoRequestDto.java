package senai.centroweg.api_challenge.application.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record ItemPedidoRequestDto(

        @JsonProperty("nome_produto")
        @NotBlank
        String nomeProduto,

        @JsonProperty("quantidade")
        @NotNull
        Integer quantidade,

        @JsonProperty("preco_unitario")
        @NotNull
        BigDecimal precoUnitario,

        @JsonProperty("id_pedido")
        @NotNull
        UUID idPedido
) { }
