package br.com.felipeltda.lanchonete.controller;

import br.com.felipeltda.lanchonete.api.controller.ClientController;
import br.com.felipeltda.lanchonete.domain.model.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ClientControllerTest {

    @Autowired
    ClientController clientController;

    @Test
    public void must_fail_whenRegisterInvalidEmailForClient(){
        Client newClient = new Client();
        newClient.setNome("Felipe Soares");
        newClient.setCpf("02187354646");
        newClient.setEmail("soares.felipe200gmailcom");
        newClient.setTelefone("38998605529");
        newClient.setDataNascimento(LocalDate.parse("1999-05-26"));
        MethodArgumentNotValidException expectedError =
                Assertions.assertThrows(
                        MethodArgumentNotValidException.class, () -> {
                            clientController.save(newClient);
                        });
        assertThat(expectedError).isNotNull();

    }
}
