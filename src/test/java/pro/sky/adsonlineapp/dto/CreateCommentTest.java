package pro.sky.adsonlineapp.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateCommentTest {

    @Test
    public void testCreateComment() {
        CreateComment comment = new CreateComment("Hello world");
        assertEquals("Hello world", comment.getText());
    }

    @Test
    public void testSetText() {
        CreateComment comment = new CreateComment();
        comment.setText("Hello");
        assertEquals("Hello", comment.getText());
    }

    @Test
    public void testNoArgsConstructor() {
        CreateComment comment = new CreateComment();
        assertNull(comment.getText());
    }

    @Test
    public void testAllArgsConstructor() {
        CreateComment comment = new CreateComment("Hello world");
        assertEquals("Hello world", comment.getText());
    }

}