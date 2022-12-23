package stream.ex1;

/**
 * 스트림(stream)
 * 컬렉션이나 배열에 데이터를 사용할 때 사용되는 문법
 * for문이나 iterator와 같은 코드보다 간결하게 사용이 가능하다.
 * 데이터 소스를 추상화해서 어떤 데이터든 간에 같은 방식으로 다룰 수 있고, 코드의 재사용성이 높아지는 장점을 가지고 있다.
 */

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * 스트림은 데이터 소스를 변경하지 않고, 데이터를 읽기만 한다.
 * 스트림은 일회용으로, 한번 코드를 사용하고 다시 재사용이 불가하다.
 */

public class Exam1 {
    public static void main(String[] args) {
        Stream<Student> studentStream = Stream.of(
                new Student("아무개1", 3, 300),
                new Student("아무개2", 1, 500),
                new Student("아무개3", 2, 400),
                new Student("아무개4", 2, 200),
                new Student("아무개5", 3, 100),
                new Student("아무개6", 1, 100)
        );
        studentStream.sorted(Comparator.comparing(Student::getBan) // 반별정렬
                        //.thenComparing(Comparator.naturalOrder())) //기본 정렬
                        .reversed()) //역순
                .forEach(System.out::println);
    }
}
class Student implements Comparable<Student> {
    String name;
    int ban;
    int totalScore;

    public Student(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }
    public String toString() {
        return String.format("{%s, %d, %d", name, ban, totalScore);
    }

    public String getName() {
        return name;
    }

    public int getBan() {
        return ban;
    }

    public int getTotalScore() {
        return totalScore;
    }
    public int compareTo(Student s) {
        return s.totalScore - this.totalScore;
    }
}
