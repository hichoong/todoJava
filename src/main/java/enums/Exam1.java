package enums;


import static enums.Direction.*;

/**
 * 열거형 Enum
 * 서로관련된 상수들을 관리하기 위해 사용 됨
 * 상수들의 집합
 */

public class Exam1 {
    public static void main(String[] args) {
        Direction d1 = Direction.EAST;
        Direction d2 = Direction.valueOf("WEST");
        Direction d3 = Direction.valueOf(Direction.class, "EAST");

        System.out.println("d1= " + d1);
        System.out.println("d2= " + d2);
        System.out.println("d3= " + d3);

        System.out.println("d1==d2 ? " + (d1 == d2));
        System.out.println("d1==d3 ? " + (d1 == d3));
        System.out.println("d1.equals(d3) ? " + d1.equals(d3));
        System.out.println("d1.compareTo(d3) ? " + d1.compareTo(d3));
        System.out.println("d1.compareTo(d2) ? " + d1.compareTo(d2));

        switch (d1) {
            case EAST :
                System.out.println("The direction is EAST");
                break;
            case SOUTH :
                System.out.println("The direction is SOUTH");
                break;
            case WEST :
                System.out.println("The direction is WEST");
                break;
            case NORTH :
                System.out.println("The direction is NORTH");
                break;
            default:
                System.out.println("Invalid direction.");
                break;
        }
        Direction[] arr = Direction.values();
        for (Direction d : arr) {
            System.out.printf("%s=%d%n", d.name(), d.ordinal());
        }
    }
}