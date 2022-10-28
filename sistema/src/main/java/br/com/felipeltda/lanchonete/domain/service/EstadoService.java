package br.com.felipeltda.lanchonete.domain.service;
import br.com.felipeltda.lanchonete.domain.exception.EntidadeDuplicadaException;
import br.com.felipeltda.lanchonete.domain.exception.EntidadeNaoEncontradaException;
import br.com.felipeltda.lanchonete.domain.exception.EntidadeVinculadaException;
import br.com.felipeltda.lanchonete.domain.model.Estado;
import br.com.felipeltda.lanchonete.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public Estado salvar(Estado estado){
        if(estadoRepository.findAll().contains(estado)){
            throw new EntidadeDuplicadaException(
                    String.format("Já existe estado com o nome " + estado.getNome())
            );
        }
        return  estadoRepository.save(estado);
    }

    public void remover(Integer estadoId){
        try{
            estadoRepository.deleteById(estadoId);
        }catch (EmptyResultDataAccessException e){
            throw new EntidadeNaoEncontradaException("Não existe um cadastro de estado com codigo informado");
        } catch (DataIntegrityViolationException e){
            throw new EntidadeVinculadaException("Estado ja esta associado a uma cidade");
        }
    }
}
