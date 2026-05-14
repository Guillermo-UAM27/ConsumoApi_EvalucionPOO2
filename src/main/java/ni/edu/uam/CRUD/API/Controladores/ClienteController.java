package ni.edu.uam.CRUD.API.Controladores;

import ni.edu.uam.CRUD.API.Models.Cliente;
import ni.edu.uam.CRUD.API.Servicios.ClienteService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Lista todos los clientes.
    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    // Obtiene un cliente por id.
    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Long id) {
        return clienteService.getClienteById(id);
    }

    // Crea un nuevo cliente.
    @PostMapping
    public Cliente saveCliente(@RequestBody Cliente cliente) {
        return clienteService.saveCliente(cliente);
    }

    // Actualiza un cliente existente.
    @PutMapping("/{id}")
    public Cliente updateCliente(@PathVariable long id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        return clienteService.saveCliente(cliente);
    }

    // Elimina un cliente por id.
    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable long id) {
        clienteService.deleteCliente(id);
    }
}
