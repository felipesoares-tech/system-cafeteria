package br.com.felipeltda.lanchonete.domain.exception;
public class EntidadeVinculadaException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public EntidadeVinculadaException(String mensagem){
        super(mensagem);
    }
}
