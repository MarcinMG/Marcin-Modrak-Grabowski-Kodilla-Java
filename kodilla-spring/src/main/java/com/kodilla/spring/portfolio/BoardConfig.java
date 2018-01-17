package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {

    @Autowired
    @Qualifier("list1")
    TaskList toDoList;
    @Qualifier("list2")
    TaskList inProgressList;
    @Qualifier("list3")
    TaskList doneList;

    @Bean(name = "list1")
    public TaskList getTaskToDoList() {
        return new TaskList();
    }

    @Bean(name = "list2")
    public TaskList getTaskInProgressList() {
        return new TaskList();
    }

    @Bean(name = "list3")
    public TaskList getTaskDoneList() {
        return new TaskList();
    }

    @Bean
    public Board getBoard() {
        return new Board(toDoList, inProgressList, doneList);
    }

}
