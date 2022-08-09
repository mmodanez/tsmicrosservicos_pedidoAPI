package com.totalshakes.totalshakesmicroservices.service;

import com.totalshakes.totalshakesmicroservices.common.CommonExtensions;
import com.totalshakes.totalshakesmicroservices.dto.PedidoDTO;
import com.totalshakes.totalshakesmicroservices.exceptions.NaoExistemPedidosException;
import com.totalshakes.totalshakesmicroservices.exceptions.PedidoJaCadastradoException;
import com.totalshakes.totalshakesmicroservices.exceptions.PedidoNaoEncontradoException;
import com.totalshakes.totalshakesmicroservices.model.Pedido;
import com.totalshakes.totalshakesmicroservices.model.Status;
import com.totalshakes.totalshakesmicroservices.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoServiceImplementation extends CommonExtensions implements PedidoService {

    private PedidoRepository pedidoRepository;

    public PedidoServiceImplementation(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public void savePedido(PedidoDTO pedidoDTO) throws PedidoJaCadastradoException {
        if (pedidoRepository.findById(pedidoDTO.getId()).isPresent())
            throw new PedidoJaCadastradoException();

        pedidoDTO.setDataHora(LocalDateTime.now());
        pedidoDTO.setStatus(Status.REALIZADO);

        Pedido pedido = super.convertToModel(pedidoDTO, Pedido.class);
        pedidoRepository.save(pedido);
    }

    @Override
    public PedidoDTO findPedidoById(long id) throws PedidoNaoEncontradoException {
        if (pedidoRepository.findById(id).isEmpty())
            throw new PedidoNaoEncontradoException();


        Pedido pedidoEncontrado = pedidoRepository.findById(id).get();
        PedidoDTO pedidoDTO = super.convertToDTO(pedidoEncontrado, PedidoDTO.class);

        return pedidoDTO;
    }

    @Override
    public List<Pedido> findAllPedidos() throws NaoExistemPedidosException {
        if (pedidoRepository.findAll().isEmpty())
            throw new NaoExistemPedidosException();

        List<Pedido> listaPedidos = pedidoRepository.findAll();
        listaPedidos.stream().map(pedido -> (super.convertToDTO(pedido, PedidoDTO.class)));
        return listaPedidos;
    }


    @Override
    public void updatePedido(long id, PedidoDTO pedidoDTO) throws PedidoNaoEncontradoException {
        if (pedidoRepository.findById(id).isEmpty())
            throw new PedidoNaoEncontradoException();

        Pedido pedidoEncontrado = pedidoRepository.findById(id).get();

        pedidoEncontrado.setStatus(pedidoDTO.getStatus());
        pedidoEncontrado.setDataHora(LocalDateTime.now());

        pedidoRepository.save(pedidoEncontrado);
    }

    @Override
    public void deletePedidoById(long id) throws PedidoNaoEncontradoException {
        if (pedidoRepository.findById(id).isEmpty())
            throw new PedidoNaoEncontradoException();

        pedidoRepository.deleteById(id);
    }

}
