import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    // Method that prints to console (e.g., in your application code)
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Test
    void testPrintOutput() {
        String expectedOutput = "Hello, World!";
        printMessage(expectedOutput); // Call the method that prints

        // Assert that the captured output matches the expected output
        assertEquals(expectedOutput + System.lineSeparator(), outputStreamCaptor.toString());
    }
}