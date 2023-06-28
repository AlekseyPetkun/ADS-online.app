package pro.sky.adsonlineapp.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class AdTest {

    @Test
    public void testGetId() {
        Ad ad = new Ad(1, 100, "Test ad", "This is a test ad", "/image/test.jpg", new User(), null);
        assertEquals((Integer) 1, ad.getId());
    }

    @Test
    public void testSetTitle() {
        Ad ad = new Ad();
        ad.setTitle("New title");
        assertEquals("New title", ad.getTitle());
    }

    @Test
    public void testGetComments() {
        Ad ad = new Ad();
        Comment comment1 = new Comment();
        Comment comment2 = new Comment();
        ad.setComments(Arrays.asList(comment1, comment2));
        assertEquals(2, ad.getComments().size());
    }

    @Test
    public void testSetAuthor() {
        Ad ad = new Ad();
        User user = new User();
        ad.setAuthor(user);
        assertEquals(user, ad.getAuthor());
    }
}