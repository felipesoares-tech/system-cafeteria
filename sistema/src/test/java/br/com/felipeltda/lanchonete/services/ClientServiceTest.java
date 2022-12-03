package br.com.felipeltda.lanchonete.services;

import br.com.felipeltda.lanchonete.domain.exception.DuplicateEntityException;
import br.com.felipeltda.lanchonete.domain.model.Client;
import br.com.felipeltda.lanchonete.domain.service.ClientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ClientServiceTest {
    @Autowired
    ClientService clientService;

    @Test
    public void must_fail_whenRegisterClientAlreadyExists(){

        Client newClient = new Client();
        newClient.setNome("Felipe Soares");
        newClient.setCpf("02187354644");
        newClient.setTelefone("38998605529");
        newClient.setDataNascimento(LocalDate.parse("1999-05-26"));
        DuplicateEntityException expectedError =
                Assertions.assertThrows(
                        DuplicateEntityException.class, () -> {
                            clientService.registerCustomer(newClient);
                        });
        assertThat(expectedError).isNotNull();

    }
}
