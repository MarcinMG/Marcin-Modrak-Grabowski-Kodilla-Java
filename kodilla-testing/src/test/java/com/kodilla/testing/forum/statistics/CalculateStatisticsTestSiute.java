package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculateStatisticsTestSiute {
    @Test
    public void testCalculateStatisticsForZeroPostsWithMock() {
        //Given
        Statistics postsMock = mock(Statistics.class);
        int posts = 0;
        when(postsMock.postsCount()).thenReturn(posts);

        CalculateStatistics calculateStatistics = new CalculateStatistics();

        //When
        calculateStatistics.calculateAdvStatistics(postsMock);
        double avgOfPostUser = calculateStatistics.avgPostsUser;
        double avgOfCommentsPosts = calculateStatistics.avgCommentsPost;
        //Then
        Assert.assertEquals(0, avgOfPostUser, 0);
        Assert.assertEquals(0, avgOfCommentsPosts, 0);
    }
    @Test
    public void testCalculateStatisticsForThousandPostsWithMock() {
        //Given
        Statistics postsMock = mock(Statistics.class);
        int posts = 1000;
        when(postsMock.postsCount()).thenReturn(posts);

        CalculateStatistics calculateStatistics = new CalculateStatistics();

        //When
        calculateStatistics.calculateAdvStatistics(postsMock);
        double avgOfPostUser = calculateStatistics.avgPostsUser;
        double avgOfCommentsPosts = calculateStatistics.avgCommentsPost;
        //Then
        Assert.assertEquals(0, avgOfPostUser, 0);
        Assert.assertEquals(0, avgOfCommentsPosts, 0);
    }
    @Test
    public void testCalculateStatisticsForZeroCommentsWithMock() {
        //Given
        Statistics commentsMock = mock(Statistics.class);
        int comments = 0;
        when(commentsMock.commentsCount()).thenReturn(comments);

        CalculateStatistics calculateStatistics = new CalculateStatistics();

        //When
        calculateStatistics.calculateAdvStatistics(commentsMock);
        double avgOfCommentsUser = calculateStatistics.avgCommentsUser;
        double avgOfCommentsPosts = calculateStatistics.avgCommentsPost;
        //Then
        Assert.assertEquals(0, avgOfCommentsUser, 0);
        Assert.assertEquals(0, avgOfCommentsPosts, 0);
    }
    @Test
    public void testCalculateStatisticsForCommentsLessThanPostsWithMock() {
        //Given
        Statistics commentsMock = mock(Statistics.class);
        int comments = 1000;
        int posts = 2000;
        when(commentsMock.commentsCount()).thenReturn(comments);
        when(commentsMock.postsCount()).thenReturn(posts);

        CalculateStatistics calculateStatistics = new CalculateStatistics();

        //When
        calculateStatistics.calculateAdvStatistics(commentsMock);
        double avgOfPostsUser = calculateStatistics.avgPostsUser;
        double avgOfCommentsUser = calculateStatistics.avgCommentsUser;
        double avgOfCommentsPost = calculateStatistics.avgCommentsPost;
        //Then
        Assert.assertEquals(0, avgOfPostsUser, 0);
        Assert.assertEquals(0, avgOfCommentsUser, 0);
        Assert.assertEquals(0.5, avgOfCommentsPost, 0);
    }
    @Test
    public void testCalculateStatisticsForCommentsMoreThanPostsWithMock() {
        //Given
        Statistics commentsMock = mock(Statistics.class);
        int comments = 2000;
        int posts = 1000;
        when(commentsMock.commentsCount()).thenReturn(comments);
        when(commentsMock.postsCount()).thenReturn(posts);

        CalculateStatistics calculateStatistics = new CalculateStatistics();

        //When
        calculateStatistics.calculateAdvStatistics(commentsMock);
        double avgOfPostsUser = calculateStatistics.avgPostsUser;
        double avgOfCommentsUser = calculateStatistics.avgCommentsUser;
        double avgOfCommentsPost = calculateStatistics.avgCommentsPost;
        //Then
        Assert.assertEquals(0, avgOfPostsUser, 0);
        Assert.assertEquals(0, avgOfCommentsUser, 0);
        Assert.assertEquals(2, avgOfCommentsPost, 0);
    }
    @Test
    public void testCalculateStatisticsForNoUsersWithMock() {
        //Given
        Statistics usersMock = mock(Statistics.class);
        List<String> users = new ArrayList<String>();
        when(usersMock.usersNames()).thenReturn(users);

        CalculateStatistics calculateStatistics = new CalculateStatistics();

        //When
        calculateStatistics.calculateAdvStatistics(usersMock);
        double avgOfPostUser = calculateStatistics.avgPostsUser;
        double avgOfCommentsUser = calculateStatistics.avgCommentsUser;
        //Then
        Assert.assertEquals(0, avgOfPostUser, 0);
        Assert.assertEquals(0, avgOfCommentsUser, 0);
    }
    @Test
    public void testCalculateStatisticsForHoundredUsersWithMock() {
        //Given
        Statistics usersMock = mock(Statistics.class);
        List<String> users = new ArrayList<String>();
        for(int i = 0; i < 100; i++){
            users.add("Joanna" + i);
        }
        when(usersMock.usersNames()).thenReturn(users);

        CalculateStatistics calculateStatistics = new CalculateStatistics();

        //When
        calculateStatistics.calculateAdvStatistics(usersMock);
        double avgOfPostUser = calculateStatistics.avgPostsUser;
        double avgOfCommentsUser = calculateStatistics.avgCommentsUser;
        //Then
        Assert.assertEquals(0, avgOfPostUser, 0);
        Assert.assertEquals(0, avgOfCommentsUser, 0);
    }
}
