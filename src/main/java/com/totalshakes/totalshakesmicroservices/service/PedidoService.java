package com.totalshakes.totalshakesmicroservices.service;

import com.totalshakes.totalshakesmicroservices.dto.PedidoDTO;
import com.totalshakes.totalshakesmicroservices.exceptions.NaoExistemPedidosException;
import com.totalshakes.totalshakesmicroservices.exceptions.PedidoJaCadastradoException;
import com.totalshakes.totalshakesmicroservices.exceptions.PedidoNaoEncontradoException;
import com.totalshakes.totalshakesmicroservices.model.Pedido;

import java.util.List;

public interface PedidoService {
    void savePedido(PedidoDTO pedidoDTO) throws PedidoJaCadastradoException;

    PedidoDTO findPedidoById(long id) throws PedidoNaoEncontradoException;

    List<Pedido> findAllPedidos() throws NaoExistemPedidosException;

    void updatePedido(long id, PedidoDTO pedidoDTO) throws PedidoNaoEncontradoException;

    void deletePedidoById(long id) throws PedidoNaoEncontradoException;
}
