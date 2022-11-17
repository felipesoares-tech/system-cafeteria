package br.com.felipeltda.lanchonete.domain.model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Client extends Person {
    public String toString(){
        return this.nome;
    }
}
