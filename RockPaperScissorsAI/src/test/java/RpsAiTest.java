/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import rockpaperscissorsai.RpsAi;

/**
 *
 * @author tomi
 */
public class RpsAiTest {

    public RpsAiTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void scoreAtBeginningZero() {
        RpsAi ai = new RpsAi();

        int score = ai.getScore();

        assertEquals(0, score);
    }

    @Test
    public void rightScoreAfterIncreasingScore() {
        RpsAi ai = new RpsAi();

        ai.raiseScore();
        int score = ai.getScore();
        assertEquals(1, score);
    }

    @Test
    public void correctMove() {
        RpsAi ai = new RpsAi();

        for (int i = 0; i < 100; i++) {
            String move = ai.getMove();
            assertThat(move, anyOf(is("ROCK"), is("PAPER"), is("SCISSORS")));
        }
    }
}
