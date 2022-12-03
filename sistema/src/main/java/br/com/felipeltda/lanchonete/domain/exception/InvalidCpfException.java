package br.com.felipeltda.lanchonete.domain.exception;

public class InvalidCpfException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public InvalidCpfException(String mensagem){
        super(mensagem);
    }
}
