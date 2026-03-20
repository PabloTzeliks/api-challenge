package senai.centroweg.api_challenge.infrastructure.web.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senai.centroweg.api_challenge.application.dto.PedidoRequest;
import senai.centroweg.api_challenge.application.dto.PedidoResponse;
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
    public ResponseEntity<PedidoResponse> cadastrarPedido(@RequestBody @Valid PedidoRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(pedidoService.cadastrar(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoResponse> atualizarPedido(@RequestBody @Valid PedidoRequest request, @RequestParam UUID id) {

        return ResponseEntity.ok(pedidoService.atualizar(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@RequestParam UUID id) {

        pedidoService.remover(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponse> buscarPedido(@PathVariable UUID id) {

        return ResponseEntity.ok(pedidoService.acharPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponse>> buscarPedidos() {

        return ResponseEntity.ok(pedidoService.listarTodos());
    }
}
