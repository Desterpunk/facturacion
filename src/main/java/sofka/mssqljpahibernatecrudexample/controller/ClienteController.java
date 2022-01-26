package sofka.mssqljpahibernatecrudexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sofka.mssqljpahibernatecrudexample.exception.ResourceNotFoundException;
import sofka.mssqljpahibernatecrudexample.model.ClienteEntidad;
import sofka.mssqljpahibernatecrudexample.repository.ClienteRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public List<ClienteEntidad> getAllClientes() {
        return clienteRepository.findAll();
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<ClienteEntidad> getClienteById(@PathVariable(value = "id") long clienteId)
            throws ResourceNotFoundException {
        ClienteEntidad clienteEntidad = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + clienteId));
        return ResponseEntity.ok().body(clienteEntidad);
    }

    @PostMapping("/clientes")
    public ClienteEntidad createCliente(@Validated @RequestBody ClienteEntidad clienteEntidad) {
        return clienteRepository.save(clienteEntidad);
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<ClienteEntidad> updateCliente(@PathVariable(value = "id") long clienteId, @Validated @RequestBody ClienteEntidad clienteEntidadDetails) throws ResourceNotFoundException {
        ClienteEntidad clienteEntidad = clienteRepository.findById(clienteId).orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + clienteId));

        clienteEntidad.setNombre(clienteEntidadDetails.getNombre());
        clienteEntidad.setDireccion(clienteEntidadDetails.getDireccion());
        clienteEntidad.setTelefono(clienteEntidadDetails.getTelefono());
        final ClienteEntidad updatedClienteEntidad = clienteRepository.save(clienteEntidad);
        return ResponseEntity.ok(updatedClienteEntidad);
    }

    @DeleteMapping("/clientes/{id}")
    public Map<String, Boolean> deleteCliente(@PathVariable(value = "id") long clienteId)
            throws ResourceNotFoundException {
        ClienteEntidad clienteEntidad = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + clienteId));

        clienteRepository.delete(clienteEntidad);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
