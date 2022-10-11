package br.com.felipeltda.lanchonete.domain.model;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity //indica que a classe que vai virar uma tabela
public class Cliente extends Pessoa {
    @Id //indica que o atributo é chave da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY)
// indica que a chave será gerada incrementalmente
// pelo banco de dados (sequence)
    private Long id;
    public String toString(){
        return this.nome;
    }
}
