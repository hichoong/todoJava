package stream.ex5;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    public static void main(String[] args) {
        //스트림을 이용해 로또번호 생성하기
        List<Integer> collect = IntStream.range(1, 46)
                .boxed()
                .sorted((n1, n2) -> new Random().nextInt())
                .distinct()
                .limit(6)
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}