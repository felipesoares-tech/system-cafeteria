package br.com.felipeltda.lanchonete.domain.model;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@MappedSuperclass
public abstract class Person {
    @Id
    @Column(length = 11)
    @EqualsAndHashCode.Include
    protected String cpf;
    @NotNull
    @Column(length = 50, nullable = false)
    protected String nome;
    @Column(length = 13)
    protected String telefone;
    protected LocalDate dataNascimento;

}