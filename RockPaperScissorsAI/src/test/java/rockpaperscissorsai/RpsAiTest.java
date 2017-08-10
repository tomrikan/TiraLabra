package rockpaperscissorsai;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
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

    RpsAi ai;

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
        ai = new RpsAi();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void scoreAtBeginningZero() {
        int score = ai.getScore();
        assertEquals(0, score);
    }

    @Test
    public void rightScoreAfterIncreasingScore() {
        ai.raiseScore();
        int score = ai.getScore();
        assertEquals(1, score);
    }

    @Test
    public void aiPlaysCorrectMoves() {
        for (int i = 0; i < 10000; i++) {
            String move = ai.getMove();
            assertThat(move, anyOf(is("ROCK"), is("PAPER"), is("SCISSORS")));
        }
    }

    @Test
    public void updateDataUpdatesMovesList() {
        ai.updateData("ROCK");
        ai.updateData("PAPER");
        ai.updateData("SCISSORS");
        ArrayList<Integer> test = new ArrayList<>();
        test.add(0);
        test.add(1);
        test.add(2);
        
        assertEquals(test, ai.getMoves());
    }
    
    @Test
    public void updatesMarkovCorrectly() {
        ai.updateData("PAPER");
        //TODO
    }

}
