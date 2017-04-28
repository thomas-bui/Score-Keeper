package bowling;

import bowling.exception.InvalidInputException;



/**
 * Read the running score in ten pin bowling and compute the running score total
 *
 * @author tbui
 */
public class ScoreKeeper {

    private FrameInputParser frameInputParser;

    public ScoreKeeper() {
        this.frameInputParser = new FrameInputParser();
    }

    public int computeScore(String inputLine) throws InvalidInputException {
        Frame[] frames = frameInputParser.parse(inputLine);
        int total = 0;

        for (int i = 0; i < 10; i++) {
            Frame frame = frames[i];
            if (frame.getNumber() == 10) {
                // Last frame - Just need the total
                total += frame.getTotal();
            } else if (frame.isStrike()) {
                int nextTurn = frames[i + 1].getFirst();
                int nextNextTurn = (nextTurn == 10 && frame.getNumber() < 9)
                    ? frames[i + 2].getFirst()
                    : frames[i + 1].getSecond();
                total += (frame.getTotal() + nextTurn + nextNextTurn);
            } else if (frame.isSpare()) {
                total += (frame.getTotal() + frames[i+1].getFirst());
            } else {
                total += frame.getTotal();
            }
        }

        return total;
    }
}
