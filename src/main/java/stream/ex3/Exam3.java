package stream.ex3;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exam3 {
    public static void main(String[] args) {
        Student[] stuArr = {
                new Student ("김아무개", 3, 200),
                new Student ("이아무개", 1, 400),
                new Student ("박아무개", 2, 100),
                new Student ("최아무개", 2, 300),
                new Student ("소아무개", 3, 250),
                new Student ("나아무개", 1, 100),
                new Student ("박아무개", 3, 350)
        };
        Stream<Student> studentStream = Stream.of(stuArr);
        studentStream.sorted(Comparator.comparing(Student::getBan)
                .thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);
        studentStream = Stream.of(stuArr);
        IntStream stuScoreStream = studentStream.mapToInt(Student::getTotalScore);
        IntSummaryStatistics stat = stuScoreStream.summaryStatistics();
        System.out.println("count = " + stat.getCount());
        System.out.println("sum = " + stat.getSum());
        System.out.printf("average = %.2f%n",stat.getAverage());
        System.out.println("min = " + stat.getMin());
        System.out.println("max = " + stat.getMax());

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
        return String.format("[%s, %d, %d]", name, ban, totalScore);
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
