package pro.sky.adsonlineapp.dto;

import org.junit.jupiter.api.Test;
import pro.sky.adsonlineapp.constants.Role;

import static org.junit.jupiter.api.Assertions.*;

class RegisterReqTest {

    @Test
    void testRegisterReq() {
        RegisterReq registerReq = new RegisterReq("testuser", "testpass", "Test", "User", "12345678", Role.USER);
        assertEquals("testuser", registerReq.getUsername());
        assertEquals("testpass", registerReq.getPassword());
        assertEquals("Test", registerReq.getFirstName());
        assertEquals("User", registerReq.getLastName());
        assertEquals("12345678", registerReq.getPhone());
        assertEquals(Role.USER, registerReq.getRole());
    }

    @Test
    void testRegisterReqEmptyConstructor() {
        RegisterReq registerReq = new RegisterReq();
        assertNotNull(registerReq);
    }

    @Test
    void testRegisterReqAllArgsConstructor() {
        RegisterReq registerReq = new RegisterReq("testuser", "testpass", "Test", "User", "12345678", Role.USER);
        RegisterReq registerReq2 = new RegisterReq(registerReq.getUsername(), registerReq.getPassword(), registerReq.getFirstName(),
                registerReq.getLastName(), registerReq.getPhone(), registerReq.getRole());
        assertEquals(registerReq, registerReq2);
    }

}