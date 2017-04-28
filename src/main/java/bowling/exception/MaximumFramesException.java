package bowling.exception;

/**
 * Thrown when the input exceeds the maximum number of Frames of 10
 *
 * @author tbui
 */
public class MaximumFramesException extends InvalidInputException {

    private static final long serialVersionUID = 1L;

    public MaximumFramesException() {
        super();
    }

    public MaximumFramesException(String message) {
        super(message);
    }

}
