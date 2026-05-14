package ni.edu.uam.CRUD.API.Controladores;

import ni.edu.uam.CRUD.API.Models.Cliente;
import ni.edu.uam.CRUD.API.Models.Pedido;
import ni.edu.uam.CRUD.API.Servicios.ClienteService;
import ni.edu.uam.CRUD.API.Servicios.PedidoService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;
    private final ClienteService clienteService;

    public PedidoController(PedidoService pedidoService, ClienteService clienteService) {
        this.pedidoService = pedidoService;
        this.clienteService = clienteService;
    }

    // Lista pedidos; opcionalmente filtra por clienteId.
    @GetMapping
    public List<Pedido> getAllPedidos(@RequestParam(name = "clienteId", required = false) Long clienteId) {
        if (clienteId == null) {
            return pedidoService.getAllPedidos();
        }
        return pedidoService.getPedidosByClienteId(clienteId);
    }

    // Obtiene un pedido por id.
    @GetMapping("/{id}")
    public Pedido getPedidoById(@PathVariable Long id) {
        return pedidoService.getPedidoById(id);
    }

    // Crea un pedido vinculado a un cliente.
    @PostMapping
    public Pedido savePedido(@RequestBody Pedido pedido) {
        Cliente cliente = clienteService.getClienteById(pedido.getCliente().getId());
        if (cliente == null) {
            return null;
        }
        if (pedido.getFecha() == null) {
            pedido.setFecha(LocalDate.now());
        }
        pedido.setCliente(cliente);
        return pedidoService.savePedido(pedido);
    }

    // Actualiza un pedido existente.
    @PutMapping("/{id}")
    public Pedido updatePedido(@PathVariable long id, @RequestBody Pedido pedido) {
        Cliente cliente = clienteService.getClienteById(pedido.getCliente().getId());
        if (cliente == null) {
            return null;
        }
        pedido.setId(id);
        pedido.setCliente(cliente);
        return pedidoService.savePedido(pedido);
    }

    // Elimina un pedido por id.
    @DeleteMapping("/{id}")
    public void deletePedido(@PathVariable long id) {
        pedidoService.deletePedido(id);
    }
}
