package br.com.fiap.locatech.locatech.controllers;

import br.com.fiap.locatech.locatech.entities.Pessoa;
import br.com.fiap.locatech.locatech.services.PessoaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    public static final Logger logger = LoggerFactory.getLogger(PessoaController.class);

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAllpessoas(
            @RequestParam int page,
            @RequestParam int size
    ) {
        logger.info("Endpoint pessoas(/pessoas acessado");
        var pessoa = this.pessoaService.findAll(page, size);
        return ResponseEntity.ok(pessoa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pessoa>> findById(@PathVariable Long id) {
        logger.info("Endpoint pessoa(/pessoas/{id} acessado");
        var pessoa = this.pessoaService.findById(id);
        return ResponseEntity.ok(pessoa);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Pessoa pessoa) {
        logger.info("Endpoint POST pessoa(/pessoas");
        this.pessoaService.save(pessoa);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Pessoa pessoa, @PathVariable Long id) {
        logger.info("Endpoint PUT veiculos(/veiculos/{id}");
        this.pessoaService.update(pessoa, id);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        logger.info("Endpoint DELETE pessoa(/pessoas/{id}");
        this.pessoaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
