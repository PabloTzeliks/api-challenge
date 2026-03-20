package senai.centroweg.api_challenge.application.mapper;

import senai.centroweg.api_challenge.application.dto.request.ItemPedidoRequestDto;
import senai.centroweg.api_challenge.application.dto.response.ItemPedidoResponseDto;
import senai.centroweg.api_challenge.domain.model.ItemPedido;
import senai.centroweg.api_challenge.domain.model.Pedido;

public class ItemPedidoMapper {

    public ItemPedido toDomain(ItemPedidoRequestDto request, Pedido pedido) {

        return new ItemPedido(
                request.nomeProduto(),
                request.quantidade(),
                request.precoUnitario(),
                pedido
        );
    }

    public ItemPedidoResponseDto toDto(ItemPedido domain) {

        return new ItemPedidoResponseDto(
                domain.getId(),
                domain.getNomeProduto(),
                domain.getQuantidade(),
                domain.getPedido().getId()
        );
    }
}
