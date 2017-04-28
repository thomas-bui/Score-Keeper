package bowling.exception;

/**
 * Throw when the the total score of turns for a Frame exceeds ten
 *
 * @author tbui
 */
public class MaximumPinsException extends InvalidInputException {

    private static final long serialVersionUID = 4626744548405934095L;

    public MaximumPinsException() {
        super();
    }

    public MaximumPinsException(String message) {
        super(message);
    }

}
