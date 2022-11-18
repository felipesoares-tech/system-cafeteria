package br.com.felipeltda.lanchonete.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
public class City {
    @Id
    @Column(length = 11)
    private Long id;
    @Column(length = 120)
    private String nome;
    @Column(length = 2)
    private Integer uf;
    @Column(length = 7)
    private Integer ibge;

}
