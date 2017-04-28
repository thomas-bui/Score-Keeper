package bowling;

import org.junit.Assert;
import org.junit.Test;

import bowling.Frame;
import bowling.FrameInputParser;
import bowling.exception.InvalidInputException;
import bowling.exception.MaximumFramesException;
import bowling.exception.MaximumPinsException;



/**
 * @author tbui
 */
public class FrameInputParserTest {

    @Test
    public void testStrikeGrouping() throws InvalidInputException {
        FrameInputParser frameInputParser = new FrameInputParser();
        Frame[] frames = frameInputParser.parse("10 1 2 10 1 2 10 1 2 10 1 2 10 1 2");
        for (int i = 0 ; i < 10; i += 2) {
            Frame frame = frames[i];
            Assert.assertEquals(10, frame.getFirst());
            Assert.assertEquals(0, frame.getSecond());
        }

        for (int i = 1 ; i < 10; i += 2) {
            Frame frame = frames[i];
            Assert.assertEquals(1, frame.getFirst());
            Assert.assertEquals(2, frame.getSecond());
        }
    }

    @Test
    public void testGrouping() throws InvalidInputException {
        FrameInputParser frameInputParser = new FrameInputParser();
        Frame[] frames = frameInputParser.parse("1 9 1 9 1 9 1 9 1 9 1 9 1 9 1 9 1 9 1 9");
        for (int i = 0 ; i < 10; i++) {
            Frame frame = frames[i];
            Assert.assertEquals(1, frame.getFirst());
            Assert.assertEquals(9, frame.getSecond());
        }
    }

    @Test
    public void testLastFrame() throws InvalidInputException {
        FrameInputParser frameInputParser = new FrameInputParser();
        Frame[] frames = frameInputParser.parse("10 10 10 10 10 10 10 10 10 10 10 10");
        Frame last = frames[frames.length - 1];
        Assert.assertEquals(10, last.getFirst());
        Assert.assertEquals(10, last.getSecond());
        Assert.assertEquals(10, last.getThird());

        frames = frameInputParser.parse("10 10 10 10 10 10 10 10 10 1 9");
        last = frames[frames.length - 1];
        Assert.assertEquals(1, last.getFirst());
        Assert.assertEquals(9, last.getSecond());
        Assert.assertEquals(0, last.getThird());
    }

    @Test(expected = MaximumPinsException.class)
    public void testTenPinsValidation() throws InvalidInputException {
        FrameInputParser frameInputParser = new FrameInputParser();
        frameInputParser.parse("5 6");
    }

    @Test(expected = MaximumPinsException.class)
    public void testTenPinsValidationOnLastFrame() throws InvalidInputException {
        FrameInputParser frameInputParser = new FrameInputParser();
        frameInputParser.parse("10 10 10 10 10 10 10 10 10 10 5 6");
    }

    @Test(expected = MaximumFramesException.class)
    public void testTenFramesValidation() throws InvalidInputException {
        FrameInputParser frameInputParser = new FrameInputParser();
        frameInputParser.parse("10 10 10 10 10 10 10 10 10 10 10 10 10");
    }

    @Test(expected = InvalidInputException.class)
    public void testInvalidInputValidation() throws InvalidInputException {
        FrameInputParser frameInputParser = new FrameInputParser();
        frameInputParser.parse("0 0 0 -1 0 0");
    }
}
