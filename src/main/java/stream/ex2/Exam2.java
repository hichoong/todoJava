package stream.ex2;

import java.io.File;
import java.util.stream.Stream;
/**
 *  스트림 중간 연산자의 기본적인 메서드
 *  sorted() : 정렬할때 사용한다.
 *  filter() : 주어진 조건에 맞지 않는 요소를 걸러내준다.
 *  distinct() : 중복된 요소를 제거해 준다.
 *  map() : 요소에 저장된 값 중에서 원하는 필드만 뽑거나, 특정 형태로 변환할 때 사용
 */

public class Exam2 {
    public static void main(String[] args) {
        File[] fileArr = {
                new File("Ex1.java"),
                new File("Ex1.bak"),
                new File("Ex2.java"),
                new File("Ex1"),
                new File("Ex2.txt"),
                new File("Ex1")
        };
        Stream<File> fileStream = Stream.of(fileArr);
        Stream<String> filenameStream = fileStream.map(File::getName);
        filenameStream.forEach(System.out::println);

        fileStream = Stream.of(fileArr);
        fileStream.map(File::getName)
                .filter(s->s.indexOf('.')!=-1)
                .map(s->s.substring(s.indexOf('.')+1))
                .map(String::toUpperCase)
                .distinct()
                .forEach(System.out::println);
        System.out.println();
    }
}
