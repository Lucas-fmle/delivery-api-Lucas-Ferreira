package com.deliverytech.delivery_api.service;

import com.deliverytech.delivery_api.model.ItemPedido;
import com.deliverytech.delivery_api.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public List<ItemPedido> listarItensPorPedido(Long pedidoId) {
        return itemPedidoRepository.findByPedidoId(pedidoId);
    }

    public List<ItemPedido> listarTodos() {
        return itemPedidoRepository.findAll();
    }

    public Optional<ItemPedido> buscarPorId(Long id) {
        return itemPedidoRepository.findById(id);
    }

    public ItemPedido salvar(ItemPedido itemPedido) {
        if (itemPedido.getQuantidade() != null && itemPedido.getPrecoUnitario() != null) {
            BigDecimal subtotal = itemPedido.getPrecoUnitario()
                    .multiply(BigDecimal.valueOf(itemPedido.getQuantidade()));
            itemPedido.setSubtotal(subtotal);
        }
        return itemPedidoRepository.save(itemPedido);
    }
}