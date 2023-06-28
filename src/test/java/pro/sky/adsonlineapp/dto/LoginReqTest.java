package pro.sky.adsonlineapp.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginReqTest {

    @Test
    public void testGetterAndSetter() {
        LoginReq loginReq = new LoginReq();
        loginReq.setPassword("testPassword");
        loginReq.setUsername("testUsername");

        assertEquals("testPassword", loginReq.getPassword());
        assertEquals("testUsername", loginReq.getUsername());
    }

    @Test
    public void testAllArgsConstructor() {
        LoginReq loginReq = new LoginReq("testPassword", "testUsername");

        assertEquals("testPassword", loginReq.getPassword());
        assertEquals("testUsername", loginReq.getUsername());
    }

    @Test
    public void testNoArgsConstructor() {
        LoginReq loginReq = new LoginReq();

        assertNull(loginReq.getPassword());
        assertNull(loginReq.getUsername());
    }

}