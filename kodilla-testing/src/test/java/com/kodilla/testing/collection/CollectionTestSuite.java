package com.kodilla.testing.collection;

import org.junit.*;
import java.util.*;

public class CollectionTestSuite {

    @Before
    public void before() {
        System.out.println("Test Case: begin");
    }
    @After
    public void after() {
        System.out.println("Test Case: end");
    }
    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        ArrayList<Integer> testList = new ArrayList<Integer>();
        OddNumbersExterminator tester = new OddNumbersExterminator();
        ArrayList<Integer> resultList = tester.exterminate(testList);

        System.out.println("Testing empty list");

        Assert.assertEquals(testList, resultList);
    }
    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        ArrayList<Integer> testList = new ArrayList<Integer>();
        testList.add(3);
        testList.add(4);
        testList.add(10);
        ArrayList<Integer> evenList = new ArrayList<Integer>();
        evenList.add(4);
        evenList.add(10);
        OddNumbersExterminator tester = new OddNumbersExterminator();
        ArrayList<Integer> resultList = tester.exterminate(testList);

        System.out.println("Testing normal list");

        Assert.assertEquals(evenList, resultList);
    }
}
