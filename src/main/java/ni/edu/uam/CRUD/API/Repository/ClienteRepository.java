package ni.edu.uam.CRUD.API.Repository;

import ni.edu.uam.CRUD.API.Models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
