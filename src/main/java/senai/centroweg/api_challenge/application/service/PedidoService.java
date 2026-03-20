package senai.centroweg.api_challenge.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import senai.centroweg.api_challenge.application.dto.request.PedidoRequestDto;
import senai.centroweg.api_challenge.application.dto.response.PedidoResponseDto;
import senai.centroweg.api_challenge.application.mapper.PedidoMapper;
import senai.centroweg.api_challenge.domain.model.Pedido;
import senai.centroweg.api_challenge.infrastructure.persistence.repository.PedidoRepository;

import java.util.List;
import java.util.UUID;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final PedidoMapper pedidoMapper;

    public PedidoService(PedidoRepository pedidoRepository,
                         PedidoMapper pedidoMapper) {

        this.pedidoRepository = pedidoRepository;
        this.pedidoMapper = pedidoMapper;
    }

    @Transactional
    public PedidoResponseDto cadastrar(PedidoRequestDto request) {

        Pedido pedido = pedidoMapper.toDomain(request);

        Pedido pedidoSalvo = pedidoRepository.save(pedido);

        return pedidoMapper.toDto(pedidoSalvo);
    }

    @Transactional
    public PedidoResponseDto atualizar(PedidoRequestDto request, UUID idPedido) {

        Pedido pedido = pedidoMapper.toDomain(request);

        Pedido pedidoAtualizado = pedidoRepository.save(pedido);

        return pedidoMapper.toDto(pedidoAtualizado);
    }

    @Transactional
    public void remover(UUID idPedido) {

        Pedido pedidoSalvo = pedidoRepository.findById(idPedido)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não existente."));

        pedidoRepository.deleteById(idPedido);
    }

    public PedidoResponseDto acharPorId(UUID idPedido) {

        Pedido pedidoSalvo = pedidoRepository.findById(idPedido)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não existente."));

        return pedidoMapper.toDto(pedidoSalvo);
    }

    public List<PedidoResponseDto> listarTodos() {

        List<Pedido> pedidos = pedidoRepository.findAll();

        return pedidos.stream()
                .map(pedidoMapper::toDto)
                .toList();
    }
}
