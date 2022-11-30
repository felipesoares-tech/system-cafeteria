package br.com.felipeltda.lanchonete.domain.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer qtd;
    @OneToOne
    private Product product;
    private Double vlrTotal;
    @ManyToOne
    @JoinColumn
    private Order order;
}
