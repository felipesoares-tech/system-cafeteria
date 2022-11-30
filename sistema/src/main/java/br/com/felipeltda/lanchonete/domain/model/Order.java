package br.com.felipeltda.lanchonete.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="order_lan")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn
    private Client client;
    @OneToOne
    @JoinColumn
    private Attendant attendant;

    @OneToMany(mappedBy = "order")
    private List<Item> itens = new ArrayList<>();
}
