package ni.edu.uam.CRUD.API.Repository;

import ni.edu.uam.CRUD.API.Models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByClienteId(Long clienteId);
}
