package br.com.fiap.locatech.locatech.controllers;

import br.com.fiap.locatech.locatech.dtos.AluguelRequestDTO;
import br.com.fiap.locatech.locatech.entities.Aluguel;
import br.com.fiap.locatech.locatech.services.AluguelService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v2/alugueis")
public class AluguelControllerV2 {
    public static final Logger logger = LoggerFactory.getLogger(AluguelControllerV2.class);

    private final AluguelService aluguelService;

    public AluguelControllerV2(AluguelService aluguelService) {
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

    @PostMapping(produces = "application/vnd.locatech.v2+jason")
    public ResponseEntity<Void> save(@Valid @RequestBody AluguelRequestDTO aluguel) {
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
