package br.com.felipeltda.lanchonete.domain.service;
import br.com.felipeltda.lanchonete.domain.exception.*;
import br.com.felipeltda.lanchonete.domain.model.Attendant;
import br.com.felipeltda.lanchonete.domain.repository.AttendantRepository;
import br.com.felipeltda.lanchonete.domain.util.CpfValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class AttendantService {

    @Autowired
    AttendantRepository attendantRepository;

    public Attendant registerAttendant(Attendant attendant){
        if(attendantRepository.findAll().contains(attendant)){
            throw new DuplicateEntityException("this entity is already registered in the system !");
        }else if(attendantRepository.findByEmail(attendant.getEmail()) != null){
            throw new EmailAlreadyExistsException("the email entered is already being used in the system");
        }else if(!CpfValidator.isCPF(attendant.getCpf())){
            throw new InvalidCpfException("invalid cpf!");
        }




        return attendantRepository.save(attendant);
    }
    public void removeAttendant(Integer attendantId) {
        try {
            attendantRepository.deleteById(attendantId);

        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("entity not found");

        } catch (DataIntegrityViolationException e) {
            throw new LinkedEntityException("entity in use");
        }
    }

}
