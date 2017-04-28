package bowling;

import org.junit.Assert;
import org.junit.Test;

import bowling.exception.InvalidInputException;



/**
 * @author tbui
 */
public class ScoreKeeperTest {

    @Test
    public void testProvidedExamples() throws InvalidInputException {
        ScoreKeeper scoreKeeper = new ScoreKeeper();
        Assert.assertEquals(10, scoreKeeper.computeScore("1 2 3 4"));
        Assert.assertEquals(29, scoreKeeper.computeScore("9 1 9 1"));
        Assert.assertEquals(18, scoreKeeper.computeScore("1 1 1 1 10 1 1"));
        Assert.assertEquals(300, scoreKeeper.computeScore("10 10 10 10 10 10 10 10 10 10 10 10"));
    }

    @Test
    public void testSpares() throws InvalidInputException {
        ScoreKeeper scoreKeeper = new ScoreKeeper();
        Assert.assertEquals(19, scoreKeeper.computeScore("1 9 0 9"));
        Assert.assertEquals(21, scoreKeeper.computeScore("1 9 1 9"));
        Assert.assertEquals(19, scoreKeeper.computeScore("0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 9 9"));
    }

    @Test
    public void testStrikes() throws InvalidInputException {
        ScoreKeeper scoreKeeper = new ScoreKeeper();
        Assert.assertEquals(60, scoreKeeper.computeScore("10 10 10"));
        Assert.assertEquals(28, scoreKeeper.computeScore("10 1 8"));
        Assert.assertEquals(30, scoreKeeper.computeScore("0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 10 10 10"));
    }

    @Test
    public void testMixed() throws InvalidInputException {
        ScoreKeeper scoreKeeper = new ScoreKeeper();
        Assert.assertEquals(187, scoreKeeper.computeScore("10 9 1 5 5 7 2 10 10 10 9 0 8 2 9 1 10"));
        Assert.assertEquals(143, scoreKeeper.computeScore("9 0 0 2 3 5 10 10 10 10 6 2 2 2 6 2"));
        Assert.assertEquals(154, scoreKeeper.computeScore("3 2 3 7 10 10 10 10 4 3 3 3 3 3 3 6"));
    }
}
