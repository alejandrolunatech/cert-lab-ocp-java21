package lab.katas;

import static org.junit.jupiter.api.Assertions.*;

import lab.katas.K01Shapes.*;
import org.junit.jupiter.api.Test;

class K01ShapesTest {
    @Test
    void shapeIsSealedWithThreePermittedTypes() {
        assertTrue(Shape.class.isSealed(), "Shape must be sealed");
        assertEquals(3, Shape.class.getPermittedSubclasses().length);
    }

    @Test
    void areas() {
        assertEquals(Math.PI, K01Shapes.area(new Circle(1)), 1e-9);
        assertEquals(6.0, K01Shapes.area(new Rect(2, 3)), 1e-9);
        assertEquals(3.0, K01Shapes.area(new Triangle(2, 3)), 1e-9);
    }

    @Test
    void descriptions() {
        assertEquals("square 2.0", K01Shapes.describe(new Rect(2, 2)));
        assertEquals("rectangle 2.0x3.0", K01Shapes.describe(new Rect(2, 3)));
        assertEquals("circle r=1.0", K01Shapes.describe(new Circle(1)));
        assertEquals("triangle", K01Shapes.describe(new Triangle(1, 1)));
    }
}
