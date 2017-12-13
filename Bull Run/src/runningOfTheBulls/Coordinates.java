package runningOfTheBulls;

public class Coordinates{

    private int column;
    private int tier;
    private char value;

    public Coordinates() {
        column = 0;
        tier = 0;
        value = ' ';
    }

    public int getColumn() {
        return column;
    }

    public int getTier() {
        return tier;
    }

    public char getValue() {
        return value;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public void setValue(char value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "column=" + column +
                ", tier=" + tier +
                ", value=" + value +
                '}';
    }
}
