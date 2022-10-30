
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
     C++ | JavaScript: arithmetic operations can be done directly with false/true.
     Java: helper code is needed that does the conversion from false/true to 0/1.
     */
    private int booleanToInt(boolean bit) {
        return bit ? 1 : 0;
    }
}
