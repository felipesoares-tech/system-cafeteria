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

    @ManyToOne
    @JoinColumn
    private Product product;
    private Double vlrTotal;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_order")
    private Order order;
}
