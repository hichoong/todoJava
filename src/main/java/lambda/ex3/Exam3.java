package lambda.ex3;

/**
 * 외부 변수를 참조하는 람다식
 * 람다식 내에서 참조하는 지역변수는 final이 붙지 않았어도 상수로 간주된다.
 * 그리고 외부 지역변수와 같은 이름의 람다식 매개변수는 허용되지 않는다.
 * ex) 만약 void method(int i)로 매개변수를 받았는데, MyFuntion f = (i) -> {}의 형식으로 작성하면 에러발생.
 */

@FunctionalInterface
interface MyFunction {
    void myMethod();
}
class Outer {
    int val= 10;
    class Inner {
        int val=20;
        void method(int i) {
            int val=30;
            //i = 10; //에러 i가 상수의 값

            MyFunction f = () -> {
                System.out.println(" i : " + i);
                System.out.println(" val : " + val);
                System.out.println(" this.val : " + ++this.val);
                System.out.println(" Outer.this.val : " + ++Outer.this.val);
            };
            f.myMethod();
        }
    }
}

public class Exam3 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.method(100);
        System.out.println("뭐지?");
    }
}
