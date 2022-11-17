package br.com.felipeltda.lanchonete.domain.service;
import br.com.felipeltda.lanchonete.domain.exception.DuplicateEntityException;
import br.com.felipeltda.lanchonete.domain.exception.EntityNotFoundException;
import br.com.felipeltda.lanchonete.domain.exception.LinkedEntityException;
import br.com.felipeltda.lanchonete.domain.model.State;
import br.com.felipeltda.lanchonete.domain.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public State salvar(State state){
        if(stateRepository.findAll().contains(state)){
            throw new DuplicateEntityException(
                    String.format("Já existe estado com o nome " + state.getNome())
            );
        }
        return  stateRepository.save(state);
    }

    public void remover(Integer estadoId){
        try{
            stateRepository.deleteById(estadoId);
        }catch (EmptyResultDataAccessException e){
            throw new EntityNotFoundException("Não existe um cadastro de estado com codigo informado");
        } catch (DataIntegrityViolationException e){
            throw new LinkedEntityException("Estado ja esta associado a uma cidade");
        }
    }
}
