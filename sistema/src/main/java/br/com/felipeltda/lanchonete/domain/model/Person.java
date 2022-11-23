package br.com.felipeltda.lanchonete.domain.model;

import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@MappedSuperclass
public abstract class Person {
    @Id
    @Column(length = 11)
    @EqualsAndHashCode.Include
    protected String cpf;
    //@NotNull
    @Column(length = 50, nullable = false)
    protected String nome;
    @Column(length = 13)
    protected String telefone;
    @Column(length = 40)
    @Email
    protected String email;
    LocalDate dataNascimento;

}