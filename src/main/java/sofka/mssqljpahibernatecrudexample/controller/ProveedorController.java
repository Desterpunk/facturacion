package sofka.mssqljpahibernatecrudexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sofka.mssqljpahibernatecrudexample.exception.ResourceNotFoundException;
import sofka.mssqljpahibernatecrudexample.model.ProveedorEntidad;
import sofka.mssqljpahibernatecrudexample.repository.ProveedorRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProveedorController {
    @Autowired
    private ProveedorRepository proveedorRepository;

    @GetMapping("/proveedores")
    public List<ProveedorEntidad> getAllProveedores() {
        return proveedorRepository.findAll();
    }

    @GetMapping("/proveedores/{id}")
    public ResponseEntity<ProveedorEntidad> getProveedorById(@PathVariable(value = "id") long id)
            throws ResourceNotFoundException {
        ProveedorEntidad proveedorEntidad = proveedorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor not found for this id :: " + id));
        return ResponseEntity.ok().body(proveedorEntidad);
    }

    @PostMapping("/proveedores")
    public ProveedorEntidad createProveedor(@Validated @RequestBody ProveedorEntidad entidad) {
        return proveedorRepository.save(entidad);
    }

    @PutMapping("/proveedores/{id}")
    public ResponseEntity<ProveedorEntidad> updateProveedor(@PathVariable(value = "id") long id, @Validated @RequestBody ProveedorEntidad entidadDetails) throws ResourceNotFoundException {
        ProveedorEntidad entidad = proveedorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Proveedor not found for this id :: " + id));

        entidad.setNombre(entidadDetails.getNombre());
        entidad.setDireccion(entidadDetails.getDireccion());
        entidad.setTelefono(entidadDetails.getTelefono());
        final ProveedorEntidad updatedEntidad = proveedorRepository.save(entidad);
        return ResponseEntity.ok(updatedEntidad);
    }

    @DeleteMapping("/proveedores/{id}")
    public Map<String, Boolean> deleteProveedor(@PathVariable(value = "id") long id)
            throws ResourceNotFoundException {
        ProveedorEntidad entidad = proveedorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor not found for this id :: " + id));

        proveedorRepository.delete(entidad);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
