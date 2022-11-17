package br.com.felipeltda.lanchonete.api.exceptionhandler;

import br.com.felipeltda.lanchonete.domain.exception.EntidadeDuplicadaException;
import br.com.felipeltda.lanchonete.domain.exception.EntidadeNaoEncontradaException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    /*@Autowired
    private MessageSource messageSource;*/

    @ExceptionHandler(EntidadeDuplicadaException.class)
    public ResponseEntity<?> tratarEntidadeDuplicada(EntidadeDuplicadaException e, WebRequest request){
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.UNAUTHORIZED,request);
    }

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<?> tratarEntidadeNaoEncontrada(EntidadeNaoEncontradaException e, WebRequest request){
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND,request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception e, Object body, HttpHeaders headers, HttpStatus status, WebRequest request){

        if(body == null){
            body = Problema.builder()
                    .dataHora(OffsetDateTime.now())
                    .mensagem(status.getReasonPhrase())
                    .build();
        }else if (body instanceof String){
            body = Problema.builder()
                    .dataHora(OffsetDateTime.now())
                    .mensagem((String) body)
                    .build();
        }

        return super.handleExceptionInternal(e,body,headers, status,request);
    }

}
