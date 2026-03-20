package senai.centroweg.api_challenge.application.service;

import org.springframework.stereotype.Service;
import senai.centroweg.api_challenge.application.dto.request.ItemPedidoRequestDto;
import senai.centroweg.api_challenge.application.dto.response.ItemPedidoResponseDto;
import senai.centroweg.api_challenge.application.mapper.ItemPedidoMapper;
import senai.centroweg.api_challenge.domain.model.ItemPedido;
import senai.centroweg.api_challenge.domain.model.Pedido;
import senai.centroweg.api_challenge.infrastructure.persistence.repository.ItemPedidoRepository;
import senai.centroweg.api_challenge.infrastructure.persistence.repository.PedidoRepository;

@Service
public class ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;
    private final PedidoRepository pedidoRepository;
    private final ItemPedidoMapper mapper;

    public ItemPedidoService(ItemPedidoRepository itemPedidoRepository,
                             PedidoRepository pedidoRepository,
                             ItemPedidoMapper mapper) {

        this.itemPedidoRepository = itemPedidoRepository;
        this.pedidoRepository = pedidoRepository;
        this.mapper = mapper;
    }

    public ItemPedidoResponseDto cadastrar(ItemPedidoRequestDto request) {

        Pedido pedido = pedidoRepository.findById(request.idPedido())
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));

        ItemPedido itemPedido = mapper.toDomain(request, pedido);

        ItemPedido itemPedidoSalvo = itemPedidoRepository.save(itemPedido);

        return mapper.toDto(itemPedidoSalvo);
    }


}
