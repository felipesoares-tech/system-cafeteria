package br.com.felipeltda.lanchonete.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
@Entity
public class Atendente extends Pessoa {
    Integer metaDiara;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String toString(){
        return this.nome;
    }
}
