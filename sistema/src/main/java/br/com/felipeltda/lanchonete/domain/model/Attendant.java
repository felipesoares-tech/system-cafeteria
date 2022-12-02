package br.com.felipeltda.lanchonete.domain.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Attendant extends Person {
    @Column(length = 40)
    @Email
    @Size(max = 40)
    private String email;
    @Column(length = 40)
    private String senha;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Attendant attendant = (Attendant) o;
        return getId() != null && Objects.equals(getId(), attendant.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
