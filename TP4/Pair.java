public class Pair {
    private int first;
    private int second;

    public Pair(int x, int y) {
        this.set_first(x);
        this.set_second(y);
    }

    /**
     * @return the first
     */
    public int get_first() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void set_first(int first) {
        this.first = first;
    }

    /**
     * @return the second
     */
    public int get_second() {
        return second;
    }

    /**
     * @param second the second to set
     */
    public void set_second(int second) {
        this.second = second;
    }

}
