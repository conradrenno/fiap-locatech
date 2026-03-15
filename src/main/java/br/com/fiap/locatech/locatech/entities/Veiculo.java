package br.com.fiap.locatech.locatech.entities;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Veiculo {

    private Long id;
    private String marca;
    private String placa;
    private String modelo;
    private int ano;
    private String cor;
    private BigDecimal valorDiaria;


}
