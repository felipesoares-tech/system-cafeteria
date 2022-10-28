package br.com.felipeltda.lanchonete.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Entidade Vinculada")
public class EntidadeVinculadaException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public EntidadeVinculadaException(String mensagem){
        super(mensagem);
    }
}
