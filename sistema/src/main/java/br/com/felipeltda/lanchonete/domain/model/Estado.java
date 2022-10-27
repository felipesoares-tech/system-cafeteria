package br.com.felipeltda.lanchonete.domain.model;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 2)
    private String nome;
}
