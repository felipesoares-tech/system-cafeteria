package br.com.felipeltda.lanchonete.domain.exception;
public class LinkedEntityException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public LinkedEntityException(String mensagem){
        super(mensagem);
    }
}
