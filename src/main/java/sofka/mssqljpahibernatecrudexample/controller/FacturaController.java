package sofka.mssqljpahibernatecrudexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sofka.mssqljpahibernatecrudexample.exception.ResourceNotFoundException;
import sofka.mssqljpahibernatecrudexample.model.FacturaEntidad;
import sofka.mssqljpahibernatecrudexample.repository.FacturaRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class FacturaController {

    @Autowired
    private FacturaRepository facturaRepository;

    @GetMapping("/facturas")
    public List<FacturaEntidad> getAllFacturas() {
        return facturaRepository.findAll();
    }

    @GetMapping("/facturas/{id}")
    public ResponseEntity<FacturaEntidad> getFacturaById(@PathVariable(value = "id") long facturaId)
            throws ResourceNotFoundException {
        FacturaEntidad facturaEntidad = facturaRepository.findById(facturaId)
                .orElseThrow(() -> new ResourceNotFoundException("Factura not found for this id :: " + facturaId));
        return ResponseEntity.ok().body(facturaEntidad);
    }

    @PostMapping("/facturas")
    public FacturaEntidad createFactura(@Validated @RequestBody FacturaEntidad facturaEntidad) {
        return facturaRepository.save(facturaEntidad);
    }

    @PutMapping("/facturas/{id}")
    public ResponseEntity<FacturaEntidad> updateFactura(@PathVariable(value = "id") long facturaId, @Validated @RequestBody FacturaEntidad facturaEntidadDetails) throws ResourceNotFoundException {
        FacturaEntidad facturaEntidad = facturaRepository.findById(facturaId).orElseThrow(() -> new ResourceNotFoundException("Factura not found for this id :: " + facturaId));

        facturaEntidad.setFecha(facturaEntidadDetails.getFecha());
        facturaEntidad.setId_cliente(facturaEntidadDetails.getId_cliente());
        final FacturaEntidad updatedFacturaEntidad = facturaRepository.save(facturaEntidad);
        return ResponseEntity.ok(updatedFacturaEntidad);
    }

    @DeleteMapping("/facturas/{id}")
    public Map<String, Boolean> deleteFactura(@PathVariable(value = "id") long facturaId)
            throws ResourceNotFoundException {
        FacturaEntidad facturaEntidad = facturaRepository.findById(facturaId)
                .orElseThrow(() -> new ResourceNotFoundException("Factura not found for this id :: " + facturaId));

        facturaRepository.delete(facturaEntidad);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
