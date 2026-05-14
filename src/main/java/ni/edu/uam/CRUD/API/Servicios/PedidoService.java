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

    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    public List<Pedido> getPedidosByClienteId(Long clienteId) {
        return pedidoRepository.findByClienteId(clienteId);
    }

    public Pedido getPedidoById(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public Pedido savePedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public void deletePedido(long id) {
        pedidoRepository.deleteById(id);
    }
}
