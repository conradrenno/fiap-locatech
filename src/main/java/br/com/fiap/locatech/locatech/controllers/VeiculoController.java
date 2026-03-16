package br.com.fiap.locatech.locatech.controllers;

import br.com.fiap.locatech.locatech.entities.Veiculo;
import br.com.fiap.locatech.locatech.services.VeiculoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    public static final Logger logger = LoggerFactory.getLogger(VeiculoController.class);

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> findAllveliculos(
            @RequestParam int page,
            @RequestParam int size
    ) {
        logger.info("Endpoint veiculos(/veiculos acessado");
        var veiculos = this.veiculoService.findAll(page, size);
        return ResponseEntity.ok(veiculos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Veiculo>> findById(@PathVariable Long id) {
        logger.info("Endpoint veiculos(/veiculos/{id} acessado");
        var veiculo = this.veiculoService.findById(id);
        return ResponseEntity.ok(veiculo);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Veiculo veiculo) {
        logger.info("Endpoint POST veiculos(/veiculos");
        this.veiculoService.save(veiculo);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Veiculo veiculo, @PathVariable Long id) {
        logger.info("Endpoint PUT veiculos(/veiculos/{id}");
        this.veiculoService.update(veiculo, id);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        logger.info("Endpoint DELETE veiculos(/veiculos/{id}");
        this.veiculoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
