package InputAndParser;

import Plateau.Mars;
import Rover.Rover;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    public void testValidInput() {
        Mars mars = new Mars(5, 5);
        Rover rover = Parser.roverParser(1, "1 2 N", mars);
        assertNotNull(rover);
        assertEquals(1, rover.getPosition().getX());
        assertEquals(2, rover.getPosition().getY());
        assertEquals(Parser.CompassDirection.N, rover.getPosition().getFacing());
    }

    @Test
    public void testInvalidInputFormat() {
        Mars mars = new Mars(5, 5);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Parser.roverParser(1, "1 2", mars);
        });
        assertEquals("Error: Invalid input format. Please provide exactly three components: X coordinate, Y coordinate, and facing direction.", exception.getMessage());
    }

    @Test
    public void testNonNumericCoordinates() {
        Mars mars = new Mars(5, 5);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Parser.roverParser(1, "a 2 N", mars);
        });
        assertEquals("Error: Coordinates must be numeric values. Please re-enter the XY coordinates.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            Parser.roverParser(1, "1 b N", mars);
        });
        assertEquals("Error: Coordinates must be numeric values. Please re-enter the XY coordinates.", exception.getMessage());
    }

    @Test
    public void testCoordinatesOutOfBounds() {
        Mars mars = new Mars(5, 5);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Parser.roverParser(1, "6 2 N", mars);
        });
        assertEquals("Error: Coordinates out of bounds. X and Y must be at least 0 and within the map range.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            Parser.roverParser(1, "1 6 N", mars);
        });
        assertEquals("Error: Coordinates out of bounds. X and Y must be at least 0 and within the map range.", exception.getMessage());
    }

    @Test
    public void testInvalidFacingDirection() {
        Mars mars = new Mars(5, 5);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Parser.roverParser(1, "1 2 Z", mars);
        });
        assertEquals("Error: Invalid facing direction. Please enter a valid direction: E, S, W, or N.", exception.getMessage());
    }

    @Test
    void command() {
    }
}