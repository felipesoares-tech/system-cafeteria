package br.com.felipeltda.lanchonete.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double valorUnitario;
    private Integer quantidade;
    @Column(length = 50, nullable = false)
    @EqualsAndHashCode.Include
    private String nome;

}
