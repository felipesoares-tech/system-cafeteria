package br.com.felipeltda.lanchonete.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Atendente extends Pessoa {
    Integer metaDiara;
    public String toString(){
        return this.nome;
    }
}
