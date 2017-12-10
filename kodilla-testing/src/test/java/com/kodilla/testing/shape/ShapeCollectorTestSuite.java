package com.kodilla.testing.shape.tdd;

import com.kodilla.testing.shape.*;
import org.junit.*;
import java.util.ArrayList;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }
    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }
    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }
    @Test
    public void testAddFigure() {
        //Given
        Shape circle = new Circle("Circle", 5);
        ShapeCollector newShape = new ShapeCollector();
        //When
        newShape.addFigure(circle);
        //Then
        Assert.assertEquals(1, newShape.getFiguresQuantity() );
    }
    @Test
    public void testRemoveFigureNotExisting() {
        //Given
        Shape circle = new Circle("Cirlce", 5);
        ShapeCollector newShape = new ShapeCollector();
        //When
        boolean result = newShape.removeFigure(circle);
        //Then
        Assert.assertFalse(result);
    }
    @Test
    public void testRemoveFigure() {
        //Given
        Shape circle = new Circle("Circle", 5);
        ShapeCollector newShape = new ShapeCollector();
        newShape.addFigure(circle);
        //When
        boolean result = newShape.removeFigure(circle);
        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, newShape.getFiguresQuantity() );
    }
    @Test
    public void testGetFigure() {
        //Given
        Shape circle = new Circle("Circle", 5);
        ShapeCollector newShape = new ShapeCollector();
        newShape.addFigure(circle);
        //When
        Shape retrievedFigure;
        retrievedFigure = newShape.getFigure(0);
        //Then
        Assert.assertEquals(circle, retrievedFigure);
    }
    @Test
    public void testShowFigures() {
        //Given
        Shape circle = new Circle("Circle", 5);
        Shape square = new Square("Square", 4);
        Shape triangle = new Triangle("Triangle", 3, 2);
        ShapeCollector newShape = new ShapeCollector();
        newShape.addFigure(circle);
        newShape.addFigure(square);
        newShape.addFigure(triangle);
        //When
        ArrayList<Shape> figureShow =  newShape.showFigures();
        //Then
        Assert.assertEquals(figureShow.get(0), circle);
        Assert.assertEquals(figureShow.get(1), square);
        Assert.assertEquals(figureShow.get(2), triangle);
    }
}
