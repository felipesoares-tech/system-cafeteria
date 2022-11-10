package br.com.felipeltda.lanchonete.api.exceptionhandler;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
public class Problema {
    private OffsetDateTime dataHora;
    private String mensagem;
}
