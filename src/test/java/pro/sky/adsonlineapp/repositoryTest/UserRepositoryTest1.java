package pro.sky.adsonlineapp.repositoryTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pro.sky.adsonlineapp.model.User;
import pro.sky.adsonlineapp.repository.UserRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest1 {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUsername() {
        // Create a test user
        User user = new User();
        user.setUsername("testUser");
        user.setEmail("test@example.com");

        // Save the user to the repository
        userRepository.save(user);

        // Test the findByUsername method
        User foundUser = userRepository.findByUsername("testUser");
        assertNotNull(foundUser);
        assertEquals("testUser", foundUser.getUsername());
    }

    @Test
    public void testFindByEmail() {
        // Create a test user
        User user = new User();
        user.setUsername("testUser");
        user.setEmail("test@example.com");

        // Save the user to the repository
        userRepository.save(user);

        // Test the findByEmail method
        Optional<User> foundUser = userRepository.findByEmail("test@example.com");
        assertTrue(foundUser.isPresent());
        assertEquals("test@example.com", foundUser.get().getEmail());
    }

    @Test
    public void testExistsByEmail() {
        // Create a test user
        User user = new User();
        user.setUsername("testUser");
        user.setEmail("test@example.com");

        // Save the user to the repository
        userRepository.save(user);

        // Test the existsByEmail method
        boolean exists = userRepository.existsByEmail("test@example.com");
        assertTrue(exists);
    }
}
