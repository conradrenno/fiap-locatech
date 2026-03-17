package br.com.fiap.locatech.locatech.controllers;

import br.com.fiap.locatech.locatech.entities.Aluguel;
import br.com.fiap.locatech.locatech.services.AluguelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {
    public static final Logger logger = LoggerFactory.getLogger(AluguelController.class);

    private final AluguelService aluguelService;

    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    @GetMapping
    public ResponseEntity<List<Aluguel>> findAll(
            @RequestParam int page,
            @RequestParam int size
    ) {
        logger.info("Endpoint pessoas(/pessoas acessado");
        var aluguel = this.aluguelService.findAll(page, size);
        return ResponseEntity.ok(aluguel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Aluguel>> findById(@PathVariable Long id) {
        logger.info("Endpoint alugueis(/alugueis/{id} acessado");
        var aluguel = this.aluguelService.findById(id);
        return ResponseEntity.ok(aluguel);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Aluguel aluguel) {
        logger.info("Endpoint POST aluguel(/alugueis");
        this.aluguelService.save(aluguel);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Aluguel aluguel, @PathVariable Long id) {
        logger.info("Endpoint PUT alugueis(/alugueis/{id}");
        this.aluguelService.update(aluguel, id);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        logger.info("Endpoint DELETE aluguel(/alugueis/{id}");
        this.aluguelService.delete(id);
        return ResponseEntity.ok().build();
    }
}
