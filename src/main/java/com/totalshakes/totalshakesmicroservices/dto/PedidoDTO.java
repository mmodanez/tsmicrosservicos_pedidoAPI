package com.totalshakes.totalshakesmicroservices.dto;


import com.totalshakes.totalshakesmicroservices.model.ItemPedido;
import com.totalshakes.totalshakesmicroservices.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {

    private Long id;

    private LocalDateTime dataHora;

    private Status status;

    private List<ItemPedidoDTO> itensDTO;
}
