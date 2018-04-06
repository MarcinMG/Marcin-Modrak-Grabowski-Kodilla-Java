package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaskQueueTestSuite {
    @Test
    public void testUpdate() {
        //Given
        TaskQueue marcinQueue = new TaskQueue("marcinTasks");
        TaskQueue kasiaQueue = new TaskQueue("kasiaTasks");
        TaskQueue bobQueue = new TaskQueue("bobTasks");
        Mentor mentorPiotr = new Mentor("Piotr");
        Mentor mentorKarolina = new Mentor("Karolina");
        marcinQueue.registerObserver(mentorPiotr);
        kasiaQueue.registerObserver(mentorPiotr);
        bobQueue.registerObserver(mentorKarolina);
        //When
        marcinQueue.addTask("Marcin first task");
        kasiaQueue.addTask("Kasia first task");
        bobQueue.addTask("Bob first task");
        kasiaQueue.addTask("Kasia second task");
        //Then
        assertEquals(3, mentorPiotr.getUpdateCount());
        assertEquals(1, mentorKarolina.getUpdateCount());
    }
}
