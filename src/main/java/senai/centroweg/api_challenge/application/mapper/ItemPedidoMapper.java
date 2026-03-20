package senai.centroweg.api_challenge.application.mapper;

import org.springframework.stereotype.Component;
import senai.centroweg.api_challenge.application.dto.request.ItemPedidoRequestDto;
import senai.centroweg.api_challenge.application.dto.response.ItemPedidoResponseDto;
import senai.centroweg.api_challenge.domain.model.ItemPedido;
import senai.centroweg.api_challenge.domain.model.Pedido;

@Component
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
                domain.getPrecoUnitario(),
                domain.getPedido().getId()
        );
    }
}
