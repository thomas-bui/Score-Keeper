package bowling.exception;

/**
 * General exception thrown in FrameInputParser
 *
 * @author dev
 */
public class InvalidInputException extends Exception {

    private static final long serialVersionUID = 4275078121365066375L;

    public InvalidInputException() {
        super();
    }

    public InvalidInputException(String message) {
        super(message);
    }

    public InvalidInputException(String message, Throwable cause) {
        super(message, cause);
    }
}
