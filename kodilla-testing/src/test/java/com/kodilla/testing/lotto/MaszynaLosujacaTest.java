package com.kodilla.testing.lotto;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MaszynaLosujacaTest {

    @Test
    public void testMiniLottoWithConditionListSizeDifferentThan5() {
        //Given
        DataBase dataBaseMock = mock(DataBase.class);
        List<Integer> wylosowaneLiczby = new ArrayList<Integer>();
        wylosowaneLiczby.add(1);
        wylosowaneLiczby.add(2);
        List<Integer> podaneLiczby = new ArrayList<Integer>();
        podaneLiczby.add(1);
        podaneLiczby.add(2);
        when(dataBaseMock.wylosuj(6)).thenReturn(wylosowaneLiczby);

        MaszynaLosujaca maszynaLosujaca = new MaszynaLosujaca(dataBaseMock);

        //When
        int liczbaTrafien = maszynaLosujaca.miniLotto(podaneLiczby);

        //Then
        Assert.assertEquals(0, liczbaTrafien);
    }

    @Test
    public void testMiniLottoWithConditionAnyElementLessThan1orMoreThan36() {
        //Given
        DataBase dataBaseMock = mock(DataBase.class);
        List<Integer> wylosowaneLiczby = new ArrayList<Integer>();
        wylosowaneLiczby.add(1);
        wylosowaneLiczby.add(2);
        wylosowaneLiczby.add(3);
        wylosowaneLiczby.add(4);
        wylosowaneLiczby.add(5);
        List<Integer> podaneLiczby = new ArrayList<Integer>();
        podaneLiczby.add(1);
        podaneLiczby.add(2);
        podaneLiczby.add(0);
        podaneLiczby.add(4);
        podaneLiczby.add(5);
        List<Integer> podaneLiczby2 = new ArrayList<Integer>();
        podaneLiczby.add(1);
        podaneLiczby.add(2);
        podaneLiczby.add(3);
        podaneLiczby.add(4);
        podaneLiczby.add(37);
        when(dataBaseMock.wylosuj(5)).thenReturn(wylosowaneLiczby);

        MaszynaLosujaca maszynaLosujaca = new MaszynaLosujaca(dataBaseMock);

        //When
        int liczbaTrafien0 = maszynaLosujaca.miniLotto(podaneLiczby);
        int liczbaTrafien37 = maszynaLosujaca.miniLotto(podaneLiczby2);

        //Then
        Assert.assertEquals(0, liczbaTrafien0);
        Assert.assertEquals(0, liczbaTrafien37);
    }

    @Test
    public void testMiniLottoWithConditionNoHits() {
        //Given
        DataBase dataBaseMock = mock(DataBase.class);
        List<Integer> wylosowaneLiczby = new ArrayList<Integer>();
        wylosowaneLiczby.add(1);
        wylosowaneLiczby.add(2);
        wylosowaneLiczby.add(3);
        wylosowaneLiczby.add(4);
        wylosowaneLiczby.add(5);
        List<Integer> podaneLiczby = new ArrayList<Integer>();
        podaneLiczby.add(6);
        podaneLiczby.add(7);
        podaneLiczby.add(8);
        podaneLiczby.add(9);
        podaneLiczby.add(10);
        when(dataBaseMock.wylosuj(5)).thenReturn(wylosowaneLiczby);

        MaszynaLosujaca maszynaLosujaca = new MaszynaLosujaca(dataBaseMock);

        //When
        int liczbaTrafien = maszynaLosujaca.miniLotto(podaneLiczby);

        //Then
        Assert.assertEquals(0, liczbaTrafien);
    }

    @Test
    public void testMiniLottoWithConditionAnyHits() {
        //Given
        DataBase dataBaseMock = mock(DataBase.class);
        List<Integer> wylosowaneLiczby = new ArrayList<Integer>();
        wylosowaneLiczby.add(1);
        wylosowaneLiczby.add(2);
        wylosowaneLiczby.add(3);
        wylosowaneLiczby.add(4);
        wylosowaneLiczby.add(5);
        List<Integer> podaneLiczby1 = new ArrayList<Integer>();
        podaneLiczby1.add(6);
        podaneLiczby1.add(7);
        podaneLiczby1.add(8);
        podaneLiczby1.add(9);
        podaneLiczby1.add(1);
        List<Integer> podaneLiczby5 = new ArrayList<Integer>();
        podaneLiczby5.add(1);
        podaneLiczby5.add(2);
        podaneLiczby5.add(3);
        podaneLiczby5.add(4);
        podaneLiczby5.add(5);
        when(dataBaseMock.wylosuj(5)).thenReturn(wylosowaneLiczby);

        MaszynaLosujaca maszynaLosujaca = new MaszynaLosujaca(dataBaseMock);

        //When
        int liczbaTrafien1 = maszynaLosujaca.miniLotto(podaneLiczby1);
        int liczbaTrafien5 = maszynaLosujaca.miniLotto(podaneLiczby5);

        //Then
        Assert.assertEquals(1, liczbaTrafien1);
        Assert.assertEquals(5, liczbaTrafien5);
    }

    @Test
    public void testJackpotWithConditionListSizeDifferentThan2or5() {
        //Given
        DataBase dataBaseMock = mock(DataBase.class);
        List<Integer> wylosowaneLiczby = new ArrayList<Integer>();
        wylosowaneLiczby.add(1);
        List<Integer> podaneLiczby = new ArrayList<Integer>();
        podaneLiczby.add(1);
        when(dataBaseMock.wylosuj(6)).thenReturn(wylosowaneLiczby);

        MaszynaLosujaca maszynaLosujaca = new MaszynaLosujaca(dataBaseMock);

        //When
        int liczbaTrafien = maszynaLosujaca.jackpot(podaneLiczby);

        //Then
        Assert.assertEquals(0, liczbaTrafien);
    }

    @Test
    public void testJackpotWithConditionList2ElementsOfList() {
        //Given
        DataBase dataBaseMock = mock(DataBase.class);
        List<Integer> wylosowaneLiczby = new ArrayList<Integer>();
        wylosowaneLiczby.add(1);
        wylosowaneLiczby.add(10);
        List<Integer> podaneLiczby = new ArrayList<Integer>();
        podaneLiczby.add(1);
        podaneLiczby.add(9);
        when(dataBaseMock.wylosuj(2)).thenReturn(wylosowaneLiczby);

        MaszynaLosujaca maszynaLosujaca = new MaszynaLosujaca(dataBaseMock);

        //When
        int liczbaTrafien = maszynaLosujaca.jackpot(podaneLiczby);

        //Then
        Assert.assertEquals(1, liczbaTrafien);
    }

    @Test
    public void testJackpotWithConditionList5ElementsOfList() {
        //Given
        DataBase dataBaseMock = mock(DataBase.class);
        List<Integer> wylosowaneLiczby = new ArrayList<Integer>();
        wylosowaneLiczby.add(1);
        wylosowaneLiczby.add(20);
        wylosowaneLiczby.add(30);
        wylosowaneLiczby.add(40);
        wylosowaneLiczby.add(50);
        List<Integer> podaneLiczby = new ArrayList<Integer>();
        podaneLiczby.add(1);
        podaneLiczby.add(21);
        podaneLiczby.add(31);
        podaneLiczby.add(40);
        podaneLiczby.add(50);
        when(dataBaseMock.wylosuj(5)).thenReturn(wylosowaneLiczby);

        MaszynaLosujaca maszynaLosujaca = new MaszynaLosujaca(dataBaseMock);

        //When
        int liczbaTrafien = maszynaLosujaca.jackpot(podaneLiczby);

        //Then
        Assert.assertEquals(3, liczbaTrafien);
    }
}
