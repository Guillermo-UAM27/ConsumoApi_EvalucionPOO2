package ni.edu.uam.CRUD.API.Servicios;

import ni.edu.uam.CRUD.API.Models.Pedido;
import ni.edu.uam.CRUD.API.Repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    // Retorna todos los pedidos.
    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    // Retorna pedidos por cliente.
    public List<Pedido> getPedidosByClienteId(Long clienteId) {
        return pedidoRepository.findByClienteId(clienteId);
    }

    // Retorna un pedido por id.
    public Pedido getPedidoById(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    // Guarda o actualiza un pedido.
    public Pedido savePedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    // Elimina un pedido por id.
    public void deletePedido(long id) {
        pedidoRepository.deleteById(id);
    }
}
