package stream.optional;

/**
 * 스트림(stream)
 * 컬렉션이나 배열에 데이터를 사용할 때 사용되는 문법
 * for문이나 iterator와 같은 코드보다 간결하게 사용이 가능하다.
 * 데이터 소스를 추상화해서 어떤 데이터든 간에 같은 방식으로 다룰 수 있고, 코드의 재사용성이 높아지는 장점을 가지고 있다.
 */


import java.util.Optional;
import java.util.OptionalInt;

/**
 * 스트림은 데이터 소스를 변경하지 않고, 데이터를 읽기만 한다.
 * 스트림은 일회용으로, 한번 코드를 사용하고 다시 재사용이 불가하다.
 */

public class Exam1 {
    public static void main(String[] args) {
        Optional<String> optStr = Optional.of("abcde");
        Optional<Integer> optInt = optStr.map(String::length);
        System.out.println("optStr=" + optStr.get());
        System.out.println("optInt=" + optInt.get());
        System.out.println("===============================");
        int result1 = Optional.of("123").filter(x->x.length()>0).map(Integer::parseInt).get();
        int result2 = Optional.of("").filter(x->x.length() > 0).map(Integer::parseInt).orElse(-1);
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
        System.out.println("===============================");
        Optional.of("456").map(Integer::parseInt).ifPresent(x-> System.out.printf("result3=%d%n", x));
        OptionalInt optInt1 = OptionalInt.of(0);
        OptionalInt optInt2 = OptionalInt.empty();
        System.out.println(optInt1.isPresent());
        System.out.println(optInt2.isPresent());
        System.out.println(optInt1.getAsInt());
        //System.out.println(optInt2.getAsInt()); //에러 NoSuchElementExceoption
        System.out.println("optInt1 = " + optInt1);
        System.out.println("optInt2 = " + optInt2);
        System.out.println( "optInt1.equals(optInt2) ? " + optInt1.equals(optInt2));
        System.out.println("===============================");
        Optional<String> opt1 = Optional.ofNullable(null);
        Optional<String> opt2 = Optional.empty();
        System.out.println("opt1 = " + opt1);
        System.out.println("opt2 = " + opt2);
        System.out.println( "opt1.equals(opt2) ? " + opt1.equals(opt2));
        System.out.println("===============================");
         int result3 = optStrToInt(Optional.of("123"), 0);
         int result4 = optStrToInt(Optional.of(""), 0);
        System.out.println("result3 = " + result3);
        System.out.println("result4 = " + result4);

    }

    static int optStrToInt(Optional<String> optStr, int defaultValue) {
        try {
            return optStr.map(Integer::parseInt).get();
        } catch (Exception e) {
            return defaultValue;
        }
    }

}
