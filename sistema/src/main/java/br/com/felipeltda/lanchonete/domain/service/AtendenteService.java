package br.com.felipeltda.lanchonete.domain.service;

import br.com.felipeltda.lanchonete.domain.exception.EntidadeDuplicadaException;
import br.com.felipeltda.lanchonete.domain.model.Atendente;
import br.com.felipeltda.lanchonete.domain.repository.AtendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtendenteService {

    @Autowired
    AtendenteRepository atendenteRepository;

    public Atendente cadastrarAtendente(Atendente atendente){
        if(atendenteRepository.existsById(atendente.getCpf())){
            throw new EntidadeDuplicadaException("ATENDENTE INFORMADO JÁ ESTÁ CADASTRADO NO SISTEMA!");
        }
        return atendenteRepository.save(atendente);
    }

}
