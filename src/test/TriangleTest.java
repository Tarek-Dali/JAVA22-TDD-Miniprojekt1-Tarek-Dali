package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import main.Triangle;
import main.Triangle.TYPE;


public class TriangleTest {

    Triangle triangle;

    @BeforeEach
    void initTriangle() {
        triangle = new Triangle();
    }

    @Test
    @DisplayName("Test scalene triangle where no sides are the same")
    void testScalene() {
        triangle.setCurrent_type(3, 4, 5);
        assertEquals(TYPE.SCALENE, triangle.getCurrent_type());
    }

    @Test
	@DisplayName("Test isosceles triangle where only two sides are the same, a==b")
	void testIsosceles() {
		triangle.setCurrent_type(3, 3, 4);
		assertEquals(TYPE.ISOSCELES, triangle.getCurrent_type());
	}

	@Test
	@DisplayName("Test isosceles triangle where only two sides are the same, a==c")
	void testIsoscelesOne() {
		triangle.setCurrent_type(3, 4, 3);
		assertEquals(TYPE.ISOSCELES, triangle.getCurrent_type());
	}
	
	@Test
	@DisplayName("Test isosceles triangle where only two sides are the same, b==c")
	void testIsoscelesTwo() {
		triangle.setCurrent_type(4, 3, 3);
		assertEquals(TYPE.ISOSCELES, triangle.getCurrent_type());
	}

    @Test
    @DisplayName("Test equilateral triangle where all sides are the same")
    void testEquilateral() {
        triangle.setCurrent_type(3, 3, 3);
        assertEquals(TYPE.EQUILATERAL, triangle.getCurrent_type());
    }

    @Test
    @DisplayName("Is not a triangle")
    void testIsNotATriangle() {
        triangle.setCurrent_type(1, 2, 3);
        assertNull(triangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Is not a triangle if A 0")
    void testIsNotATriangleAZero() {
        triangle.setCurrent_type(0, 2, 3);
        assertNull(triangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Is not a triangle if B 0")
    void testIsNotATriangleBZero() {
        triangle.setCurrent_type(2, 0, 3);
        assertNull(triangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Is not a triangle if C 0")
    void testIsNotATriangleCZero() {
        triangle.setCurrent_type(2, 2, 0);
        assertNull(triangle.getCurrent_type());
    }

    @Test
    @DisplayName("Null values")
    void testNullValues() {
        triangle.setCurrent_type(0, 0, 2);
        assertNull(triangle.getCurrent_type());
    }

    @Test
    @DisplayName("Null values 1")
    void testNullValuesNegatives() {
        triangle.setCurrent_type(-1, -2, -3);
        assertNull(triangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Null values a + b <= c")
    void testNullAplusB() {
    	triangle.setCurrent_type(2, 2, 4);
        assertNull(triangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Null values a + c <= b")
    void testNullAplusC() {
    	triangle.setCurrent_type(2, 4, 2);
        assertNull(triangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Null values b + c <= a")
    void testNullBplusC() {
    	triangle.setCurrent_type(4, 2, 2);
        assertNull(triangle.getCurrent_type());
    }

    @Test
    @DisplayName("Test user input")
    void testUserInput() {
        String data = "3,4,5";
        InputStream in = new ByteArrayInputStream(data.getBytes());
        System.setIn(in);
        triangle.getUserInput();
        assertEquals(TYPE.SCALENE, triangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Test user input wrong format")
    void testUserInputFormat() {
        String data = "a,b,c";
        InputStream in = new ByteArrayInputStream(data.getBytes());
        System.setIn(in);
        triangle.getUserInput();
        assertEquals(null, triangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Test user input length")
    void testUserInputLength() {
        String data = "3,4,5,6,7";
        InputStream in = new ByteArrayInputStream(data.getBytes());
        System.setIn(in);
        triangle.getUserInput();
        assertEquals(null, triangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Test triangle which receives array string")
    void testTriangleString() {
        String[] invalidInput = { "0", "2", "2" };
        Triangle triangle = new Triangle(invalidInput);
        assertNull(triangle.getCurrent_type());
    }

    @Test
    @DisplayName("Test triangle which receives invalid input")
    void testTriangleInvalidInput() {
        String[] invalidInput = { "a", "b", "c" };
        Triangle triangle = new Triangle(invalidInput);
        assertNull(triangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Test triangle which receives invalid length input")
    void testTriangleInvalidLengthInput() {
        String[] invalidInput = { "1", "2", "2", "4" };
        Triangle triangle = new Triangle(invalidInput);
        assertNull(triangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Test triangle which sets 3 numbers")
    void testTriangle() {
    	Triangle triangle = new Triangle(0,2,3);
    	assertNull(triangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Test toString not triangle print")
    void testToStringNotTriangle() {
        triangle.setCurrent_type(0, 3, 3);
        assertEquals("0, 3, 3, This is not a triangle", triangle.toString());
    }
    
    @Test
    @DisplayName("Test toString Equilateral print")
    void testToStringEquilateral() {
        triangle.setCurrent_type(3, 3, 3);
        assertEquals("3, 3, 3, This is a Equilateral triangle", triangle.toString());
    }
    
    @Test
    @DisplayName("Test toString Scalene print")
    void testToStringScalene() {
        triangle.setCurrent_type(3, 4, 5);
        assertEquals("3, 4, 5, This is a Scalene triangle", triangle.toString());
    }
    
    @Test
    @DisplayName("Test toString Isocles print")
    void testToStringIsocles() {
        triangle.setCurrent_type(3, 3, 4);
        assertEquals("3, 3, 4, This is a Isosceles triangle", triangle.toString());
    }
    
}