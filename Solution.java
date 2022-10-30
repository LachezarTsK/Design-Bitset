
public class Bitset {

    private static final int MAX_BIT_STATES = 2;
    private final boolean[] bits;
    private int totalBitsWithValueOne;
    private boolean allBitsFlipped;

    public Bitset(int size) {
        bits = new boolean[size];
    }

    public void fix(int index) {
        totalBitsWithValueOne += (booleanToInt(allBitsFlipped) + booleanToInt(bits[index]) + 1) % MAX_BIT_STATES;
        bits[index] = !allBitsFlipped;
    }

    public void unfix(int index) {
        totalBitsWithValueOne -= (booleanToInt(allBitsFlipped) + booleanToInt(bits[index])) % MAX_BIT_STATES;
        bits[index] = allBitsFlipped;
    }

    public void flip() {
        allBitsFlipped = !allBitsFlipped;
        totalBitsWithValueOne = bits.length - totalBitsWithValueOne;
    }

    public boolean all() {
        return totalBitsWithValueOne == bits.length;
    }

    public boolean one() {
        return totalBitsWithValueOne > 0;
    }

    public int count() {
        return totalBitsWithValueOne;
    }

    @Override
    public String toString() {
        StringBuilder binary = new StringBuilder();
        for (int index = 0; index < bits.length; ++index) {
            binary.append((booleanToInt(bits[index]) + booleanToInt(allBitsFlipped)) % MAX_BIT_STATES);
        }
        return binary.toString();
    }

    /*
     C++: false/true are actually 0/1.
     JavaScript: false/true, under certain circumstances, can convert automatically to 0/1.
     Java: this behaviour can be achieved only with helper code that does the conversion.
     */
    private int booleanToInt(boolean bit) {
        return bit ? 1 : 0;
    }
}
