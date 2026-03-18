package br.com.fiap.locatech.locatech.services;

import br.com.fiap.locatech.locatech.dtos.AluguelRequestDTO;
import br.com.fiap.locatech.locatech.entities.Aluguel;
import br.com.fiap.locatech.locatech.repositories.AluguelRepository;
import br.com.fiap.locatech.locatech.repositories.VeiculoRepository;
import br.com.fiap.locatech.locatech.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {

    private final AluguelRepository aluguelRepository;
    private final VeiculoRepository veiculoRepository;

    public AluguelService(AluguelRepository aluguelRepository, VeiculoRepository veiculoRepository) {
        this.aluguelRepository = aluguelRepository;
        this.veiculoRepository = veiculoRepository;
    }

    public Optional<Aluguel> findById(Long id) {
        return Optional.ofNullable(this.aluguelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluguel não encontrado")));
    }

    public List<Aluguel> findAll(int page, int size) {
        int offset = page * size;
        return this.aluguelRepository.findAll(size, offset);
    }

    public void save(AluguelRequestDTO aluguelDTO) {
        Aluguel aluguel = calculateAluguel(aluguelDTO);
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

    private Aluguel calculateAluguel(AluguelRequestDTO aluguelDTO) {
        var veiculo = this.veiculoRepository.findById(aluguelDTO.veiculoId())
            .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));

        var quantidadeDeDias = BigDecimal.valueOf(aluguelDTO.dataFim().getDayOfYear() - aluguelDTO.dataInicio().getDayOfYear());
        var valor = veiculo.getValorDiaria().multiply(quantidadeDeDias);
        return new Aluguel(aluguelDTO, valor);
    }
}
