package enums;

public enum Direction {
    EAST(1, ">"), SOUTH(2, "V"), WEST(3, "<"), NORTH(4,"^");

    private static final Direction[] DIR_ARR = Direction.values();
    private final int value;
    private final String symbol;

    Direction(int value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    public int getValue() {
        return value;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Direction of(int dir) {
        if (dir < 1 || dir > 4) {
            throw new IllegalArgumentException("Invlid value : " + dir);
        }
        return DIR_ARR[dir - 1];
    }

    //방향을 회전시키는 메서드 num 값만큼 90도씩 회전
    public Direction rotate (int num) {
        num = num % 4;
        if (num < 0) num += 4; // 음수일때는 시계반대 방향으로 회전
        return DIR_ARR[(value-1+num) % 4];
    }

    @Override
    public String toString() {
        return name() + getSymbol();
    }
}
