package br.com.felipeltda.lanchonete.domain.model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Attendant extends Person {
    @Column(length = 40)
    @Email
    private String email;
    @Column(length = 40)
    private String senha;
    public String toString(){
        return this.nome;
    }
}
