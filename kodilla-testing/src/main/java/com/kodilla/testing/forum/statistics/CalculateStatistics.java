package com.kodilla.testing.forum.statistics;

public class CalculateStatistics {
    int quantityUsers;
    int quantityPosts;
    int quantityComments;
    double avgPostsUser;
    double avgCommentsUser;
    double avgCommentsPost;

    public void calculateAdvStatistics(Statistics statistics) {
        quantityUsers = statistics.usersNames().size();
        quantityPosts = statistics.postsCount();
        quantityComments = statistics.commentsCount();
        if(quantityPosts > 0) {
            avgPostsUser = (double)quantityUsers / quantityPosts;
        }else avgPostsUser = 0;
        if(quantityComments > 0 ) {
            avgCommentsUser = (double)quantityUsers / quantityComments;
        }else avgCommentsUser = 0;
        if(quantityPosts > 0 ) {
            avgCommentsPost = (double)quantityComments / quantityPosts;
        }else avgCommentsPost = 0;
    }

    public void ShowStatistics() {
        System.out.println(quantityUsers);
        System.out.println(quantityPosts);
        System.out.println(quantityComments);
        System.out.println(avgPostsUser);
        System.out.println(avgCommentsUser);
        System.out.println(avgCommentsPost);
    }
}
