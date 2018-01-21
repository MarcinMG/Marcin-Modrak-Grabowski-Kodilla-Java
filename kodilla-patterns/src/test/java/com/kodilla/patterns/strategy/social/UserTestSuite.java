package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User marcin = new Millenials("Marcin Marcin");
        User marek = new YGeneration("marek Marek");
        User mariusz = new ZGeneration("Mariusz Mariusz");

        //When
        String marcinShouldPost = marcin.sharePost();
        System.out.println("Marcin post: " + marcinShouldPost);
        String marekShouldPost = marek.sharePost();
        System.out.println("Marek post: " + marekShouldPost);
        String mariuszShouldPost = mariusz.sharePost();
        System.out.println("Mariusz post: " + mariuszShouldPost);

        //Then
        Assert.assertEquals("Using facebook", marcinShouldPost);
        Assert.assertEquals("Using twitter", marekShouldPost);
        Assert.assertEquals("Using snapchat", mariuszShouldPost);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User marcin = new Millenials("Marcin Marcin");

        //When
        String marcinShouldPost = marcin.sharePost();
        System.out.println("Marcin post: " + marcinShouldPost);
        marcin.setSocialMedia(new TwitterPublisher());
        marcinShouldPost = marcin.sharePost();
        System.out.println("Marcin now post: " + marcinShouldPost);

        //Then
        Assert.assertEquals("Using twitter", marcinShouldPost);
    }
}
