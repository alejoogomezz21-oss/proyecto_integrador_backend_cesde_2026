package co.edu.cesde.ga.aplicacion.controller;

import co.edu.cesde.ga.aplicacion.models.Programs;
import co.edu.cesde.ga.aplicacion.service.ProgramService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programs")
@CrossOrigin(origins = "*")
public class ProgramsController {

    private final ProgramService programService;

    public ProgramsController(ProgramService programService) {
        this.programService = programService;
    }

    // GET /api/programs -> lista todos los programas académicos
    @GetMapping
    public ResponseEntity<List<Programs>> findAll() {
        return ResponseEntity.ok(programService.getAllPrograms());
    }

    // GET /api/programs/{id} -> busca un programa por su id
    @GetMapping("/{id}")
    public ResponseEntity<Programs> findById(@PathVariable Long id) {
        Programs program = programService.findById(id);
        if (program == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(program);
    }

    // POST /api/programs -> crea un nuevo programa académico
    @PostMapping
    public ResponseEntity<Programs> save(@RequestBody Programs program) {
        Programs created = programService.createProgram(program);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // PUT /api/programs/{id} -> actualiza un programa existente
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Programs program) {
        program.setId(id); // Cambia setId por el nombre de tu setter si es diferente (ej. setProgramId)
        boolean updated = programService.update(program);
        return updated ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    // DELETE /api/programs/{id} -> elimina un programa por su id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        boolean deleted = programService.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
