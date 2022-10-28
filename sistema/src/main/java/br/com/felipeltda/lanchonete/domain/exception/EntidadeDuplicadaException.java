package br.com.felipeltda.lanchonete.domain.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "ENTIDADE JÁ EXISTE")
public class EntidadeDuplicadaException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public EntidadeDuplicadaException(String mensagem){
        super(mensagem);
    }
}
