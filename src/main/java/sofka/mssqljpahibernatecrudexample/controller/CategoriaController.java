package sofka.mssqljpahibernatecrudexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sofka.mssqljpahibernatecrudexample.exception.ResourceNotFoundException;
import sofka.mssqljpahibernatecrudexample.model.CategoriaEntidad;
import sofka.mssqljpahibernatecrudexample.repository.CategoriaRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/categorias")
    public List<CategoriaEntidad> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    @GetMapping("/categorias/{id}")
    public ResponseEntity<CategoriaEntidad> getCategoriaById(@PathVariable(value = "id") long id)
            throws ResourceNotFoundException {
        CategoriaEntidad categoriaEntidad = categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria not found for this id :: " + id));
        return ResponseEntity.ok().body(categoriaEntidad);
    }

    @PostMapping("/categorias")
    public CategoriaEntidad createCategoria(@Validated @RequestBody CategoriaEntidad entidad) {
        return categoriaRepository.save(entidad);
    }

    @PutMapping("/categorias/{id}")
    public ResponseEntity<CategoriaEntidad> updateCategoria(@PathVariable(value = "id") long id, @Validated @RequestBody CategoriaEntidad entidadDetails) throws ResourceNotFoundException {
        CategoriaEntidad entidad = categoriaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Categoria not found for this id :: " + id));

        entidad.setDescripcion(entidadDetails.getDescripcion());
        final CategoriaEntidad updatedEntidad = categoriaRepository.save(entidad);
        return ResponseEntity.ok(updatedEntidad);
    }

    @DeleteMapping("/categorias/{id}")
    public Map<String, Boolean> deleteCategoria(@PathVariable(value = "id") long id)
            throws ResourceNotFoundException {
        CategoriaEntidad entidad = categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria not found for this id :: " + id));

        categoriaRepository.delete(entidad);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
