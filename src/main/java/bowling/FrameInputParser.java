package bowling;

import java.util.Arrays;
import java.util.Iterator;

import bowling.exception.InvalidInputException;
import bowling.exception.MaximumFramesException;
import bowling.exception.MaximumPinsException;


/**
 * A parser to read Frames given in the form of space separated strings
 * Will also validate the input ensuring that Frames are created using correct bowling rules
 *
 * @author tbui
 */
public class FrameInputParser {

    public Frame[] parse(String inputLine) throws InvalidInputException {
        if (inputLine != null) {
            int currentFrame = 1;
            Frame[] frames = new Frame[10];
            String[] inputs = inputLine.trim().split("\\s+");

            Iterator<String> itr = Arrays.asList(inputs).iterator();
            while(itr.hasNext()) {
                if (currentFrame > 10) {
                    throw new MaximumFramesException();
                } else if (currentFrame == 10) {
                    // Special handling for last Frame
                    Frame last = new Frame(
                       readNextTurn(itr),
                       readNextTurn(itr),
                       readNextTurn(itr),
                       currentFrame
                    );
                    if ((last.getFirst() == 10 && last.getSecond() < 10 && (last.getSecond() + last.getThird() > 10)) ||
                        (last.getFirst() < 10 && (last.getFirst() + last.getSecond() > 10))) {
                        throw new MaximumPinsException();
                    }

                    // Ensure the third turn is only provided when legal
                    if (last.getThird() > 0 &&
                            last.getFirst() < 10 &&
                            (last.getFirst() + last.getSecond() < 10)) {
                        throw new MaximumFramesException("Illegal third turn on last Frame");
                    }
                    frames[currentFrame - 1] = last;
                } else {
                    int firstTurn = readNextTurn(itr);
                    if (firstTurn == 10) {
                        frames[currentFrame - 1] = new Frame(firstTurn, 0, 0, currentFrame);
                    } else {
                        // Only read second turn when not a strike
                        int secondTurn = readNextTurn(itr);
                        if (firstTurn + secondTurn > 10) {
                            throw new MaximumPinsException();
                        }
                        frames[currentFrame - 1] = new Frame(firstTurn, secondTurn, 0, currentFrame);
                    }
                }
                currentFrame ++;
            }

            // Fill missing frames
            for (int i = currentFrame - 1; i < 10; i++) {
                frames[i] = new Frame(0, 0, 0, i+1);
            }

            return frames;
        } else {
            throw new InvalidInputException("No input provided");
        }
    }

    private int readNextTurn(Iterator<String> itr) throws InvalidInputException {
        if (itr.hasNext()) {
            String input = itr.next();
            try {
                int scoreValue = Integer.parseInt(input);
                if (scoreValue < 0) {
                    throw new InvalidInputException("'" + input + "' is not valid");
                }
                if (scoreValue > 10) {
                    throw new MaximumPinsException();
                }
                return scoreValue;
            } catch (NumberFormatException e) {
                throw new InvalidInputException("'" + input + "' is not a valid number", e);
            }
        } else {
            // Use 0 for incomplete scores
            return 0;
        }
    }

}
