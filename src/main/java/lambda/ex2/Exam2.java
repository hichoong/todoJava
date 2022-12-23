package lambda.ex2;

/**
 * 람다식의 타입과 형변환
 * 함수형 인터페이스로 람다식을 참조할 수 있는 것일 뿐, 람다식의 타입이 함수형 인터페이스의 타입과 일치하는 것은 아니다.
 * 람다식은 익명 객체이고 익명 객체는 타입이 없다.
 * 그래서 대입 연산자의 양변의 타입을 이치시키기 위해 형변환이 필요하다.
 */
@FunctionalInterface
interface MyFunction {
    void myMethod();
}
public class Exam2 {
    public static void main(String[] args) {
        MyFunction f =()->{};
        Object obj = (MyFunction)(()->{});
        String str = ((Object)(MyFunction)(()->{})).toString();

        System.out.println(f);
        System.out.println(obj);
        System.out.println(str);

        //System.out.println(()->{}); // 람다식은 Object타입으로 형변환 안됨
        System.out.println((MyFunction)(()->{}));
        //System.out.println((MyFunction)(()->{}).toString());
        System.out.println(((Object) (MyFunction)(()->{})).toString());
    }
}
