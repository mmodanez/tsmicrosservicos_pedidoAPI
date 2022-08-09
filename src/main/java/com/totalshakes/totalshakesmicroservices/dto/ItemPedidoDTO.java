package com.totalshakes.totalshakesmicroservices.dto;

import com.totalshakes.totalshakesmicroservices.model.Pedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoDTO {

    private Long id;

    private Integer quantidade;

    private String descricao;

    private PedidoDTO pedidoDTO;
}
