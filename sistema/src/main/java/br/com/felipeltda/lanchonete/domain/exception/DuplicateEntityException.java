package br.com.felipeltda.lanchonete.domain.exception;

//@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "ENTIDADE JÁ EXISTE")
public class DuplicateEntityException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public DuplicateEntityException(String mensagem){
        super(mensagem);
    }
}
