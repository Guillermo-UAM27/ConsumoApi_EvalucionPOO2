package ni.edu.uam.CRUD.API.Repository;

import ni.edu.uam.CRUD.API.Models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Repositorio JPA para CRUD de pedidos.
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    // Busca pedidos asociados a un cliente.
    List<Pedido> findByClienteId(Long clienteId);
}
