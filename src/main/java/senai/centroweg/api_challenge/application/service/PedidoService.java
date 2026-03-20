package senai.centroweg.api_challenge.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import senai.centroweg.api_challenge.application.dto.PedidoRequest;
import senai.centroweg.api_challenge.application.dto.PedidoResponse;
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
    public PedidoResponse cadastrar(PedidoRequest request) {

        Pedido pedido = pedidoMapper.toDomain(request);

        Pedido pedidoSalvo = pedidoRepository.save(pedido);

        return pedidoMapper.toDto(pedidoSalvo);
    }

    @Transactional
    public PedidoResponse atualizar(PedidoRequest request, UUID idPedido) {

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

    public PedidoResponse acharPorId(UUID idPedido) {

        Pedido pedidoSalvo = pedidoRepository.findById(idPedido)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não existente."));

        return pedidoMapper.toDto(pedidoSalvo);
    }

    public List<PedidoResponse> listarTodos() {

        List<Pedido> pedidos = pedidoRepository.findAll();

        return pedidos.stream()
                .map(pedidoMapper::toDto)
                .toList();
    }
}
