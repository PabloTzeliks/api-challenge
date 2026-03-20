package senai.centroweg.api_challenge.application.mapper;

import org.springframework.stereotype.Component;
import senai.centroweg.api_challenge.application.dto.request.PedidoRequestDto;
import senai.centroweg.api_challenge.application.dto.response.PedidoResponseDto;
import senai.centroweg.api_challenge.domain.model.Pedido;

@Component
public class PedidoMapper {

    public Pedido toDomain(PedidoRequestDto request) {

        return new Pedido(
                request.dataPedido()
        );
    }

    public PedidoResponseDto toDto(Pedido domain) {

        return new PedidoResponseDto(
                domain.getId(),
                domain.getDataPedido()
        );
    }
}
