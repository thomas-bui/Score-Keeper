package bowling;

/**
 * @author dev
 */
public class Frame {

    private final int first;
    private final int second;
    private final int third; // Only applicable when on the tenth frame
    private final int total;
    private final int number; // The frame number (1 to 10)

    public Frame(int first, int second, int third, int number) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.total = first + second + third; // Pre-computed for performance
        this.number = number;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int getThird() {
        return third;
    }

    public int getNumber() {
        return number;
    }

    public int getTotal() {
        return total;
    }

    public boolean isStrike() {
        return first == 10;
    }

    public boolean isSpare() {
        return !isStrike() && total == 10;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(number);
        sb.append(": ");
        sb.append(first);
        sb.append("+");
        sb.append(second);
        sb.append("+");
        sb.append(third);
        sb.append("=");
        sb.append(total);
        return sb.toString();
    }
}
