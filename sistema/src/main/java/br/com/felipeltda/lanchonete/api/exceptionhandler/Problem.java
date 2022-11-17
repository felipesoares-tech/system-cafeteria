package br.com.felipeltda.lanchonete.api.exceptionhandler;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
public class Problem {
    private OffsetDateTime dataHora;
    private String mensagem;
}
