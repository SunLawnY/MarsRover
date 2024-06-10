package InputAndParser;

import Plateau.Mars;
import Rover.Rover;
import Rover.MoveFunction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;

import static InputAndParser.Parser.command;
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
    void testCommand_ValidInput() {
        // Arrange
        String input = "LRM";

        // Act
        ArrayList<MoveFunction> result = command(input);

        // Assert
        assertEquals(3, result.size());
        assertEquals(MoveFunction.L, result.get(0));
        assertEquals(MoveFunction.R, result.get(1));
        assertEquals(MoveFunction.M, result.get(2));
    }

    @Test
    void testCommand_InvalidInput() {
        // Arrange
        String input = "LRX";

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                command(input);
            }
        });
        assertEquals("Error: Invalid command 'X'. Instructions should only contain L, R or M", exception.getMessage());
    }

    @Test
    void testCommand_EmptyInput() {
        // Arrange
        String input = "";

        // Act
        ArrayList<MoveFunction> result = command(input);

        // Assert
        assertTrue(result.isEmpty());
    }

    @Test
    void testCommand_MixedCaseInput() {
        // Arrange
        String input = "lRm";

        // Act
        ArrayList<MoveFunction> result = command(input);

        // Assert
        assertEquals(3, result.size());
        assertEquals(MoveFunction.L, result.get(0));
        assertEquals(MoveFunction.R, result.get(1));
        assertEquals(MoveFunction.M, result.get(2));
    }

    @Test
    void testCommand_SingleValidCommand() {
        // Arrange
        String input = "M";

        // Act
        ArrayList<MoveFunction> result = command(input);

        // Assert
        assertEquals(1, result.size());
        assertEquals(MoveFunction.M, result.get(0));
    }
}