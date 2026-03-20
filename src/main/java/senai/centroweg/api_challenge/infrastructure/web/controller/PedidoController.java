package senai.centroweg.api_challenge.infrastructure.web.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senai.centroweg.api_challenge.application.dto.request.PedidoRequestDto;
import senai.centroweg.api_challenge.application.dto.response.PedidoResponseDto;
import senai.centroweg.api_challenge.application.service.PedidoService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<PedidoResponseDto> cadastrarPedido(@RequestBody @Valid PedidoRequestDto request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(pedidoService.cadastrar(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoResponseDto> atualizarPedido(@RequestBody @Valid PedidoRequestDto request, @PathVariable UUID id) {

        return ResponseEntity.ok(pedidoService.atualizar(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable UUID id) {

        pedidoService.remover(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDto> buscarPedido(@PathVariable UUID id) {

        return ResponseEntity.ok(pedidoService.acharPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponseDto>> buscarPedidos() {

        return ResponseEntity.ok(pedidoService.listarTodos());
    }
}
