package com.deliverytech.delivery_api.controller;

import com.deliverytech.delivery_api.model.ItemPedido;
import com.deliverytech.delivery_api.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/item-pedidos")
public class ItemPedidoController {

    private final ItemPedidoService service;

    public ItemPedidoController(ItemPedidoService service) {
        this.service = service;
    }


    @GetMapping("/pedido/{pedidoId}")
    public List<ItemPedido> listarPorPedido(@PathVariable Long pedidoId){
        return service.listarPorPedido(pedidoId);
    }
}