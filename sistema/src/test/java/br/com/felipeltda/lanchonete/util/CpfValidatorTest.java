package br.com.felipeltda.lanchonete.util;

import br.com.felipeltda.lanchonete.domain.util.CpfValidator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CpfValidatorTest {
    @Test
    public void cpfTest() {
        // invalid cpfs
        // cpfs invalidos
        assertFalse(CpfValidator.isCPF(null));
        assertFalse(CpfValidator.isCPF(""));
        assertFalse(CpfValidator.isCPF("0"));
        assertFalse(CpfValidator.isCPF("00000000000"));
        assertFalse(CpfValidator.isCPF("11111111111"));
        assertFalse(CpfValidator.isCPF("99999999999"));
        assertFalse(CpfValidator.isCPF("12345687911"));
        assertFalse(CpfValidator.isCPF("11488954644"));
        assertFalse(CpfValidator.isCPF("32132454544"));
        assertFalse(CpfValidator.isCPF("456567767657"));
        assertFalse(CpfValidator.isCPF("123.456.879-11"));
        assertFalse(CpfValidator.isCPF("114.889.546-44"));
        assertFalse(CpfValidator.isCPF("321.324.545-44"));
        assertFalse(CpfValidator.isCPF("456.567.767-57"));

        assertFalse(CpfValidator.isCPF("071.721.522-98"));
        assertFalse(CpfValidator.isCPF("847.781.803-72"));
        assertFalse(CpfValidator.isCPF("471.382.531-09"));
        assertFalse(CpfValidator.isCPF("434.896.155-73"));
        assertFalse(CpfValidator.isCPF("179.947.946-37"));
        assertFalse(CpfValidator.isCPF("328.179.426-20"));
        assertFalse(CpfValidator.isCPF("916.326.148-04"));
        assertFalse(CpfValidator.isCPF("761.859.339-69"));
        assertFalse(CpfValidator.isCPF("916.326.148-**"));
        assertFalse(CpfValidator.isCPF("761.859.339-##"));


        // valid cpfs
        // is not allowed special characters and masks
        assertTrue(CpfValidator.isCPF("07172152298"));
        assertTrue(CpfValidator.isCPF("84778180372"));
        assertTrue(CpfValidator.isCPF("47138253109"));
        assertTrue(CpfValidator.isCPF("43489615573"));
        assertTrue(CpfValidator.isCPF("17994794637"));
        assertTrue(CpfValidator.isCPF("32817942620"));
        assertTrue(CpfValidator.isCPF("91632614804"));
        assertTrue(CpfValidator.isCPF("76185933969"));
    }
}
