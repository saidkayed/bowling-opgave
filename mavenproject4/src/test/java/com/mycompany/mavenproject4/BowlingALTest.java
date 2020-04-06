/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author sidad
 */
public class BowlingALTest {

    public BowlingALTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of PointsSum method, of class BowlingAL.
     */
    @Test
    public void testSimpleTest() {
        System.out.println("Simple Test");
        int[][] points = {
            {2, 1},
            {3, 1},
            {4, 1},
            {5, 1}
        };
        BowlingAL instance = new BowlingAL();
        String expResult = "[3, 7, 12, 18]";
        String result = instance.PointsSum(points);
        assertEquals(expResult, result);

    }

    @Test
    public void testStrikeTest1() {
        System.out.println("StrikeTest1");
        int[][] strike = {
            {0, 10},
            {5, 3},
            {4, 5},
            {2, 2},
            {1, 8},
            {4, 4},};
        BowlingAL instance = new BowlingAL();
        String expResult = "[18, 26, 35, 39, 48, 56]";
        String result = instance.PointsSum(strike);
        assertEquals(expResult, result);

    }

    @Test
    public void testStrikeTest2() {
        System.out.println("StrikeTest2");
        int[][] strikeStrike2 = {
            {10, 0},
            {10, 0},
            {10, 0},
            {10, 0},
            {10, 0},
            {10, 0},
            {10, 0},
            {10, 0},
            {10, 0},
            {10, 0},
            {10, 10}};
        BowlingAL instance = new BowlingAL();
        String expResult = "[30, 60, 90, 120, 150, 180, 210, 240, 270, 300]";
        String result = instance.PointsSum(strikeStrike2);
        assertEquals(expResult, result);

    }

    @Test
    public void testStrikeSpare() {
        System.out.println("StrikeSpareTest");
        int[][] strikeSpare = {
            {0, 10},
            {5, 5},
            {4, 5},
            {2, 2},
            {1, 8},
            {4, 4},};
        BowlingAL instance = new BowlingAL();
        String expResult = "[20, 34, 43, 47, 56, 64]" ;
        String result = instance.PointsSum(strikeSpare);
        assertEquals(expResult, result);

    }
    
     @Test
    public void testSPARE() {
        System.out.println("SpareTest");
        int[][] spare = {
        {1, 9},
        {3, 1},
        {5, 5},
        {2, 2},
        {1, 9},
        {4, 4},};
        BowlingAL instance = new BowlingAL();
        String expResult = "[13, 17, 29, 33, 47, 55]" ;
        String result = instance.PointsSum(spare);
        assertEquals(expResult, result);

    }

}
