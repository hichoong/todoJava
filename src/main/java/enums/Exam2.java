package enums;
/**
 * 열거형에 멤버 추가하기
 * 열거형의 ordinal()메서드는 열거형 상수가 정의된 순서를 반환
 * 하지만 순서의 불규칙성이 있을 수 있어 사용 시 예외사항이 발생 할 수 있다.
 * 그러므로 상수옆에 원하는 값을 괄호에 적어주고 필드와 생성자를 추가해 주어야 한다.
 * 그리고 괄호안에 여러개의 값을 지정할 수 있고, 추가로 필드와 생성자에 추가해 주어야 한다.
 */

public class Exam2 {
    public static void main(String[] args) {
        for (Direction d: Direction.values()) {
            System.out.printf("%s=%d%n", d.name(),d.getValue());
        }

        Direction d1 = Direction.EAST;
        Direction d2 = Direction.of(1);
        Direction d3 = Direction.of(2);


        System.out.println("=====================");
        System.out.printf("d1=%s, %d%n", d1.name(),d1.getValue());
        System.out.printf("d2=%s, %d%n", d2.name(),d2.getValue());
        System.out.printf("d3=%s, %d%n", d3.name(),d3.getValue());

        System.out.println("=====================");

        System.out.println(Direction.EAST.rotate(1));
        System.out.println(Direction.EAST.rotate(2));
        System.out.println(Direction.EAST.rotate(-1));
        System.out.println(Direction.EAST.rotate(-2));
    }
}
