package br.com.felipeltda.lanchonete.domain.model;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Cliente extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String toString(){
        return this.nome;
    }
}
