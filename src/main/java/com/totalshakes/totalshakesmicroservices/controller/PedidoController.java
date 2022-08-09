package com.totalshakes.totalshakesmicroservices.controller;

import com.totalshakes.totalshakesmicroservices.dto.PedidoDTO;
import com.totalshakes.totalshakesmicroservices.exceptions.NaoExistemPedidosException;
import com.totalshakes.totalshakesmicroservices.exceptions.PedidoJaCadastradoException;
import com.totalshakes.totalshakesmicroservices.exceptions.PedidoNaoEncontradoException;
import com.totalshakes.totalshakesmicroservices.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//TODO - retorna o body
@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<HttpStatus> savePedido(@RequestBody PedidoDTO pedidoDTO) throws PedidoJaCadastradoException {
        pedidoService.savePedido(pedidoDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HttpStatus> findPedidoById(@RequestBody @PathVariable long id) throws PedidoNaoEncontradoException {
        pedidoService.findPedidoById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<HttpStatus> findAllPedidos() throws NaoExistemPedidosException {
        pedidoService.findAllPedidos();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updatePedido(@RequestBody PedidoDTO pedidoDTO, @PathVariable long id) throws PedidoNaoEncontradoException {
        pedidoService.updatePedido(id, pedidoDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePedido(@RequestBody @PathVariable long id) throws PedidoNaoEncontradoException {
        pedidoService.deletePedidoById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
