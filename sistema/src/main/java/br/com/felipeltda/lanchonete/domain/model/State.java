package br.com.felipeltda.lanchonete.domain.model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
public class State {
    @Id
    @Column(length = 11)
    private Integer id;
    @Column(length = 75)
    private String nome;
    @Column(length = 2)
    private String uf;
    @Column(length = 2)
    private Integer ibge;
    @Column(length = 3)
    private Integer pais;
    @Column(length = 50)
    private String ddd;
}
