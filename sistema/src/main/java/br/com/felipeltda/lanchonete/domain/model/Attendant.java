package br.com.felipeltda.lanchonete.domain.model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Attendant extends Person {
    Integer metaDiara;
    public String toString(){
        return this.nome;
    }
}
