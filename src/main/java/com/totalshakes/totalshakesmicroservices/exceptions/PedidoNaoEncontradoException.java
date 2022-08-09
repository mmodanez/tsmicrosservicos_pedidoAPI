package com.totalshakes.totalshakesmicroservices.exceptions;

public class PedidoNaoEncontradoException extends Exception{
    @Override
    public String getMessage() {
        return "Pedido nao encontrado.";
    }
}
