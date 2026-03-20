package senai.centroweg.api_challenge.infrastructure.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import senai.centroweg.api_challenge.application.dto.request.ItemPedidoRequestDto;
import senai.centroweg.api_challenge.application.dto.response.ItemPedidoResponseDto;
import senai.centroweg.api_challenge.application.service.ItemPedidoService;

@RestController
@RequestMapping("/itens")
public class ItemPedidoController {

    private final ItemPedidoService itemPedidoService;

    public ItemPedidoController(ItemPedidoService itemPedidoService) {
        this.itemPedidoService = itemPedidoService;
    }

    public ResponseEntity<ItemPedidoResponseDto> cadastrarItemPedido(ItemPedidoRequestDto request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(itemPedidoService.cadastrar(request));
    }
}
