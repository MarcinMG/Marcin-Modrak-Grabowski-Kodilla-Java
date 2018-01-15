package com.kodilla.spring.calculator;

import com.kodilla.spring.library.Library;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
    @Test
    public void testCalculations() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double testAdd = calculator.add(1,1);
        double testSub = calculator.sub(2,2);
        double testMul = calculator.mul(3,3);
        double testDiv = calculator.div(4,4);
        //Then
        Assert.assertEquals(2, testAdd, 0);
        Assert.assertEquals(0, testSub, 0);
        Assert.assertEquals(9, testMul, 0);
        Assert.assertEquals(1, testDiv, 0);
    }
}
