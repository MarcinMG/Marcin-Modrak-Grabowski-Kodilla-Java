package com.kodilla.testing.collection;

import org.junit.*;
import java.util.*;

public class CollectionTestSuite {

    @Before
    public void Before() {
        System.out.println("Test Case: begin");
    }
    @After
    public void After() {
        System.out.println("Test Case: end");
    }
    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        ArrayList<Integer> testList = new ArrayList<Integer>();
        OddNumbersExterminator tester = new OddNumbersExterminator();

        System.out.println("Testing empty list");

        Assert.assertTrue(tester.exterminate(testList).isEmpty());
    }
    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        ArrayList<Integer> testList = new ArrayList<Integer>();
        testList.add(3);
        testList.add(4);
        testList.add(10);
        OddNumbersExterminator tester = new OddNumbersExterminator();

        System.out.println("Testing normal list");

        boolean testNormal = true;
        for(Integer hasOddNumbers : tester.exterminate(testList)) {
            if(hasOddNumbers % 2 != 0) {
                testNormal = false;
                break;
            }
        }
        Assert.assertFalse(testNormal == false);

    }
}
