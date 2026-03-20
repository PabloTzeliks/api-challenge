package senai.centroweg.api_challenge.application.mapper;

import org.springframework.stereotype.Component;
import senai.centroweg.api_challenge.application.dto.PedidoRequest;
import senai.centroweg.api_challenge.application.dto.PedidoResponse;
import senai.centroweg.api_challenge.domain.model.Pedido;

@Component
public class PedidoMapper {

    public Pedido toDomain(PedidoRequest request) {

        return new Pedido(
                request.dataPedido()
        );
    }

    public PedidoResponse toDto(Pedido domain) {

        return new PedidoResponse(
                domain.getId(),
                domain.getDataPedido()
        );
    }
}
