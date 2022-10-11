package br.com.felipeltda.lanchonete.sistema.modelos;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@MappedSuperclass
public abstract class Pessoa {
    @Column(length = 11)
    protected String cpf;
    @Column(length = 50, nullable = false)
    protected String nome;
    @Column(length = 13)
    protected String telefone;
    @Column(length = 40)
    protected String email;
    LocalDate dataNascimento;

}