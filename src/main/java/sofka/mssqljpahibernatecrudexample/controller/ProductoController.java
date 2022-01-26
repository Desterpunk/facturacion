package sofka.mssqljpahibernatecrudexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sofka.mssqljpahibernatecrudexample.exception.ResourceNotFoundException;
import sofka.mssqljpahibernatecrudexample.model.ProductoEntidad;
import sofka.mssqljpahibernatecrudexample.repository.ProductoRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/productos")
    public List<ProductoEntidad> getAllProductos() {
        return productoRepository.findAll();
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<ProductoEntidad> getProductoById(@PathVariable(value = "id") long id)
            throws ResourceNotFoundException {
        ProductoEntidad productoEntidad = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto not found for this id :: " + id));
        return ResponseEntity.ok().body(productoEntidad);
    }

    @PostMapping("/productos")
    public ProductoEntidad createProducto(@Validated @RequestBody ProductoEntidad entidad) {
        return productoRepository.save(entidad);
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<ProductoEntidad> updateProducto(@PathVariable(value = "id") long id, @Validated @RequestBody ProductoEntidad entidadDetails) throws ResourceNotFoundException {
        ProductoEntidad entidad = productoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Producto not found for this id :: " + id));

        entidad.setDescripcion(entidadDetails.getDescripcion());
        entidad.setPrecio(entidadDetails.getPrecio());
        entidad.setId_categoria(entidadDetails.getId_categoria());
        entidad.setId_proveedor(entidadDetails.getId_proveedor());
        final ProductoEntidad updatedEntidad = productoRepository.save(entidad);
        return ResponseEntity.ok(updatedEntidad);
    }

    @DeleteMapping("/productos/{id}")
    public Map<String, Boolean> deleteProducto(@PathVariable(value = "id") long id)
            throws ResourceNotFoundException {
        ProductoEntidad entidad = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto not found for this id :: " + id));

        productoRepository.delete(entidad);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
