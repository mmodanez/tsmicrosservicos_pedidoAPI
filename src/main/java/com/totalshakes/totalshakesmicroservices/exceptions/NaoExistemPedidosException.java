package com.totalshakes.totalshakesmicroservices.exceptions;

public class NaoExistemPedidosException extends Exception{
    @Override
    public String getMessage() {
        return "Nao existem pedidos cadastrados";
    }
}
