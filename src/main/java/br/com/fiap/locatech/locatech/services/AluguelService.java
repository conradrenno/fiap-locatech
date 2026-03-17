package br.com.fiap.locatech.locatech.services;

import br.com.fiap.locatech.locatech.entities.Aluguel;
import br.com.fiap.locatech.locatech.repositories.AluguelRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {

    private final AluguelRepository aluguelRepository;

    public AluguelService(AluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

    public Optional<Aluguel> findById(Long id) {
        return this.aluguelRepository.findById(id);
    }

    public List<Aluguel> findAll(int page, int size) {
        int offset = page * size;
        return this.aluguelRepository.findAll(size, offset);
    }

    public void save(Aluguel aluguel) {
        var save = this.aluguelRepository.save(aluguel);
        Assert.state(save == 1, "Erro ao salvar aluguel");
    }

    public void update(Aluguel aluguel, Long id) {
        var update = this.aluguelRepository.update(aluguel, id);
        if (update == 0) {
            throw new RuntimeException("Aluguel não encontrada");
        }


    }

    public void delete(Long id) {
        var delete = this.aluguelRepository.delete(id);
        if (delete == 0) {
            throw new RuntimeException("Aluguel não encontrado");
        }
    }
}
