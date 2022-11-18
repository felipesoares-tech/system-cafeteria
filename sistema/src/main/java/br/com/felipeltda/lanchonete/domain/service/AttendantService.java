package br.com.felipeltda.lanchonete.domain.service;
import br.com.felipeltda.lanchonete.domain.exception.DuplicateEntityException;
import br.com.felipeltda.lanchonete.domain.exception.EntityNotFoundException;
import br.com.felipeltda.lanchonete.domain.exception.LinkedEntityException;
import br.com.felipeltda.lanchonete.domain.model.Attendant;
import br.com.felipeltda.lanchonete.domain.repository.AttendantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class AttendantService {

    @Autowired
    AttendantRepository attendantRepository;

    public Attendant registerAttendant(Attendant attendant){
        if(attendantRepository.existsById(attendant.getCpf())){
            throw new DuplicateEntityException("this entity is already registered in the system !");
        }
        return attendantRepository.save(attendant);
    }
    public void removeAttendant(String attendantId) {
        try {
            attendantRepository.deleteById(attendantId);

        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(attendantId);

        } catch (DataIntegrityViolationException e) {
            throw new LinkedEntityException("entity in use");
        }
    }

}
