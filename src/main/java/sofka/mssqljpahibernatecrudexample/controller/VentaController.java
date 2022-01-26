package sofka.mssqljpahibernatecrudexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sofka.mssqljpahibernatecrudexample.exception.ResourceNotFoundException;
import sofka.mssqljpahibernatecrudexample.model.VentasEntidad;
import sofka.mssqljpahibernatecrudexample.repository.VentaRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class VentaController {

    @Autowired
    private VentaRepository ventaRepository;

    @GetMapping("/ventas")
    public List<VentasEntidad> getAllVentas() {
        return ventaRepository.findAll();
    }

    @GetMapping("/ventas/{id}")
    public ResponseEntity<VentasEntidad> getVentaById(@PathVariable(value = "id") long ventaId)
            throws ResourceNotFoundException {
        VentasEntidad ventasEntidad = ventaRepository.findById(ventaId)
                .orElseThrow(() -> new ResourceNotFoundException("Venta not found for this id :: " + ventaId));
        return ResponseEntity.ok().body(ventasEntidad);
    }

    @PostMapping("/ventas")
    public VentasEntidad createVenta(@Validated @RequestBody VentasEntidad ventasEntidad) {
        return ventaRepository.save(ventasEntidad);
    }

    @PutMapping("/ventas/{id}")
    public ResponseEntity<VentasEntidad> updateVenta(@PathVariable(value = "id") long ventaId, @Validated @RequestBody VentasEntidad ventasEntidadDetails) throws ResourceNotFoundException {
        VentasEntidad ventasEntidad = ventaRepository.findById(ventaId).orElseThrow(() -> new ResourceNotFoundException("Venta not found for this id :: " + ventaId));

        ventasEntidad.setId_factura(ventasEntidadDetails.getId_factura());
        ventasEntidad.setId_producto(ventasEntidadDetails.getId_producto());
        ventasEntidad.setCantidad(ventasEntidadDetails.getCantidad());
        final VentasEntidad updatedVentaEntidad = ventaRepository.save(ventasEntidad);
        return ResponseEntity.ok(updatedVentaEntidad);
    }

    @DeleteMapping("/ventas/{id}")
    public Map<String, Boolean> deleteVenta(@PathVariable(value = "id") long ventaId)
            throws ResourceNotFoundException {
        VentasEntidad ventasEntidad = ventaRepository.findById(ventaId)
                .orElseThrow(() -> new ResourceNotFoundException("Venta not found for this id :: " + ventaId));

        ventaRepository.delete(ventasEntidad);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
