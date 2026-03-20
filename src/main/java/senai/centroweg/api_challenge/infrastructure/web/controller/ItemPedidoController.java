package senai.centroweg.api_challenge.infrastructure.web.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senai.centroweg.api_challenge.application.dto.request.ItemPedidoRequestDto;
import senai.centroweg.api_challenge.application.dto.request.PedidoRequestDto;
import senai.centroweg.api_challenge.application.dto.response.ItemPedidoResponseDto;
import senai.centroweg.api_challenge.application.dto.response.PedidoResponseDto;
import senai.centroweg.api_challenge.application.service.ItemPedidoService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/itens")
public class ItemPedidoController {

    private final ItemPedidoService itemPedidoService;

    public ItemPedidoController(ItemPedidoService itemPedidoService) {
        this.itemPedidoService = itemPedidoService;
    }

    @PostMapping
    public ResponseEntity<ItemPedidoResponseDto> cadastrarItemPedido(@RequestBody @Valid ItemPedidoRequestDto request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(itemPedidoService.cadastrar(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemPedidoResponseDto> atualizarItemPedido(@RequestBody @Valid ItemPedidoRequestDto request, @PathVariable UUID id) {

        return ResponseEntity.ok(itemPedidoService.atualizar(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable UUID id) {

        itemPedidoService.remover(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedidoResponseDto> buscarPedido(@PathVariable UUID id) {

        return ResponseEntity.ok(itemPedidoService.acharPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<ItemPedidoResponseDto>> buscarPedidos() {

        return ResponseEntity.ok(itemPedidoService.listarTodos());
    }
}
