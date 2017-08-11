package rockpaperscissorsai;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import rockpaperscissorsai.Player;

/**
 *
 * @author tomi
 */
public class PlayerTest {
    
    Player player;

    public PlayerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.player = new Player();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void scoreAtBeginningZero() {
        int score = player.getScore();
        assertEquals(0, score);
    }

    @Test
    public void rightScoreAfterRaising() {
        player.raiseScore();
        int score = player.getScore();
        assertEquals(1, score);
    }
    @Test
    public void entersCorrectMove() {
        //TODO
    }
}
