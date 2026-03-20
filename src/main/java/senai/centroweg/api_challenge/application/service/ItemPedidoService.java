package senai.centroweg.api_challenge.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import senai.centroweg.api_challenge.application.dto.request.ItemPedidoRequestDto;
import senai.centroweg.api_challenge.application.dto.response.ItemPedidoResponseDto;
import senai.centroweg.api_challenge.application.mapper.ItemPedidoMapper;
import senai.centroweg.api_challenge.domain.model.ItemPedido;
import senai.centroweg.api_challenge.domain.model.Pedido;
import senai.centroweg.api_challenge.infrastructure.persistence.repository.ItemPedidoRepository;
import senai.centroweg.api_challenge.infrastructure.persistence.repository.PedidoRepository;

import java.util.List;
import java.util.UUID;

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

    @Transactional
    public ItemPedidoResponseDto cadastrar(ItemPedidoRequestDto request) {

        Pedido pedido = pedidoRepository.findById(request.idPedido())
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));

        ItemPedido itemPedido = mapper.toDomain(request, pedido);

        ItemPedido itemPedidoSalvo = itemPedidoRepository.save(itemPedido);

        return mapper.toDto(itemPedidoSalvo);
    }

    @Transactional
    public ItemPedidoResponseDto atualizar(ItemPedidoRequestDto request, UUID idItemPedido) {

        Pedido pedido = pedidoRepository.findById(request.idPedido())
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));

        ItemPedido itemPedido = mapper.toDomain(request, pedido);

        ItemPedido pedidoAtualizado = itemPedidoRepository.save(itemPedido);

        return mapper.toDto(pedidoAtualizado);
    }

    @Transactional
    public void remover(UUID idItemPedido) {

        ItemPedido itemPedidoSalvo = itemPedidoRepository.findById(idItemPedido)
                .orElseThrow(() -> new IllegalArgumentException("Item não existente."));

        pedidoRepository.deleteById(idItemPedido);
    }

    public ItemPedidoResponseDto acharPorId(UUID idItemPedido) {

        ItemPedido itemPedidoSalvo = itemPedidoRepository.findById(idItemPedido)
                .orElseThrow(() -> new IllegalArgumentException("Item não existente."));

        return mapper.toDto(itemPedidoSalvo);
    }

    public List<ItemPedidoResponseDto> listarTodos() {

        List<ItemPedido> pedidos = itemPedidoRepository.findAll();

        return pedidos.stream()
                .map(mapper::toDto)
                .toList();
    }
}
