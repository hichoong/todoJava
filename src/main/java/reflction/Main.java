package reflction;

import java.lang.reflect.Method;

/*
* 리플렉션 : 구체적인 클래스 타입을 알지 못해도 그 클래스의 정보(타입, 메서드, 변수등)에 접글할 수 있게 해주는 자바 API
* 주로 스프링 프레임워크를 사용하면 접하게 된다.
*
* */
public class Main {
    public static void main(String[] args) throws Exception {
        Object car = new Car("아기자동차", 100);
        //car.move(); 컴파일 단계에서 에러가 발생
        /*자바는 컴파일러를 사용한다.
        즉 컴파일 타임에 타입이 결정된다.
        car라는 이름의 객체는 컴파일 타임에 Object로 타입이 결정됐기 때문에 Object 클래스의 인스턴스 변수와 메서드만 사용할 수 있다.
        * */

        Class carClass = Car.class;
        Method move = carClass.getMethod("move");
        move.invoke(car, null); //invoke 메서드 : 해당메서드를 실행하는데 첫번째 인자 : 메서드를 실행할 객체, 두번째 인자 : 매개변수 여기서 인자의 개수는 여러개가 가능

        Method getPosition = carClass.getMethod("getPosition");
        int posiion = (int) getPosition.invoke(car, null);
        System.out.println(posiion);

        //매개변수에 인자값이 있는 경우를 사용해보기
        Method setPosition = carClass.getMethod("setName", String.class);
        setPosition.invoke(car, "멋진자동차");
        System.out.println(car.toString());

        //매개변수가 여러개인 경우
        Method setAllField = carClass.getMethod("setAllField", String.class, int.class);
        setAllField.invoke(car, "뉴자동차", 120);
        System.out.println(car.toString());
    }
}
