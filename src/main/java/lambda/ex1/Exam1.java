package lambda.ex1;
/**
 * 람다식 (Lambda expression)
 * JDK 1.8 버전부터 람다식이 추가되었다.
 * 람다식의 도입과 함꼐 자바는 객체지향언어인 동시에 함수형 언어가 되었다.
 * 람다식은 함수를 간략하면서도 명확한 식으로 표현할 수 있게 해준다.
 * 람다식으로 표현하면 메서드의 이름과 반환값이 없어지므로, 람다식을 익명함수라고도 한다.
 */

import static lambda.ex1.LambdaEx1.execute;
import static lambda.ex1.LambdaEx1.getMyFunction;

/**
 * 람다식 작성 방법
 *
 */

@FunctionalInterface
interface MyFunction {
    void run();
}
class LambdaEx1 {
    static void execute (MyFunction f) {
        f.run();
    }
    static MyFunction getMyFunction() {
        MyFunction f = () -> System.out.println("f3.run()");
        return f;
    }
}

public class Exam1 {
    public static void main(String[] args) {
     //람다식으로 MyFunction의 run()을 구현
     MyFunction f1 = () -> System.out.println("f1.run()");
     MyFunction f2 = new MyFunction() {
         @Override
         public void run() {
             System.out.println("f2.run()");
         }
     };
     MyFunction f3 = getMyFunction();

     f1.run();
     f2.run();
     f3.run();

     execute(f1);
     execute( () -> System.out.println("run()" ));
    }
}
