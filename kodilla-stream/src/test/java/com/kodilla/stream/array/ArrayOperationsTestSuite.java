package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage(){
        //Given
        int[] numbers = new int[20];
        //When
        for(int i=0; i < 20; i++) {
            numbers[i] = i;
        }
        //Then
        double averageTest = ArrayOperations.getAverage(numbers);
        Assert.assertEquals(9.5, averageTest, 0);
    }
}
