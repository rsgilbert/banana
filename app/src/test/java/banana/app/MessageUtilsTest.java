/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package banana.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageUtilsTest {
    @Test public void testGetMessage() {
        assertEquals("Hello      World!", MessageUtils.getMessage());
    }
}
