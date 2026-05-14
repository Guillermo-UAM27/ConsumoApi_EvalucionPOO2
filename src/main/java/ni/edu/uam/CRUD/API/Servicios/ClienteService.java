package ni.edu.uam.CRUD.API.Servicios;

import ni.edu.uam.CRUD.API.Models.Cliente;
import ni.edu.uam.CRUD.API.Repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Retorna todos los clientes.
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    // Retorna un cliente por id.
    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    // Guarda o actualiza un cliente.
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Elimina un cliente por id.
    public void deleteCliente(long id) {
        clienteRepository.deleteById(id);
    }
}
