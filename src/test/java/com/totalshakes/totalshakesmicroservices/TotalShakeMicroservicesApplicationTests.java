package com.totalshakes.totalshakesmicroservices;

import com.totalshakes.totalshakesmicroservices.controller.PedidoController;
import com.totalshakes.totalshakesmicroservices.dto.ItemPedidoDTO;
import com.totalshakes.totalshakesmicroservices.dto.PedidoDTO;
import com.totalshakes.totalshakesmicroservices.exceptions.PedidoJaCadastradoException;
import com.totalshakes.totalshakesmicroservices.model.Status;
import com.totalshakes.totalshakesmicroservices.service.PedidoServiceImplementation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TotalShakeMicroservicesApplicationTests {

    @Autowired
    PedidoController pedidoController;

    @Test
    void contextLoads() {
    }

    @Test
    void testSavePedidoProperly() throws PedidoJaCadastradoException {
        PedidoDTO pedidoDTO = new PedidoDTO();
        List<ItemPedidoDTO> itens = new ArrayList<>();

        pedidoDTO.setId(1L);
        pedidoDTO.setItensDTO(itens);

        ResponseEntity pedidoSalvo = pedidoController.savePedido(pedidoDTO);

        assertEquals(HttpStatus.CREATED, pedidoSalvo.getStatusCode());
    }

}
