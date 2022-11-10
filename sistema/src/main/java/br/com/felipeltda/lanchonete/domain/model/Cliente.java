package br.com.felipeltda.lanchonete.domain.model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Cliente extends Pessoa {
    public String toString(){
        return this.nome;
    }
}
