package br.com.felipeltda.lanchonete.domain.exception;
public class DuplicateEntityException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public DuplicateEntityException(String mensagem){
        super(mensagem);
    }
}
