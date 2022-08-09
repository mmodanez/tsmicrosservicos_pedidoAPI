package com.totalshakes.totalshakesmicroservices.repository;

import com.totalshakes.totalshakesmicroservices.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
