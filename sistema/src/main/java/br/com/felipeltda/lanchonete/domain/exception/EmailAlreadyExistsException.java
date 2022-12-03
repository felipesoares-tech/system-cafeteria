package br.com.felipeltda.lanchonete.domain.exception;
import java.io.Serial;

public class EmailAlreadyExistsException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;
    public EmailAlreadyExistsException(String mensagem){
        super(mensagem);
    }
}
