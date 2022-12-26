package stream.ex4;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex4 {
    public static void main(String[] args) {

        //filter : 조건에 맞는 데이터를 가려냄
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> listStream = list.stream();
       listStream.filter(i -> i.contains("b")).forEach(System.out::println);
        System.out.println("===========================================");

        //map : 데이터 변환
        List<File> fileList = Arrays.asList(new File("Test1.java"), new File("Test2.java"), new File("Test3.java"));
        fileList.stream()
                .map(File::getName)
                .forEach(System.out::println);
        System.out.println("===========================================");
        fileList.stream()
                .map(i-> i.getName().toUpperCase())
                .forEach(System.out::println);
        System.out.println("===========================================");

        //sort : 정렬, 내림차순 정렬 : reverseOrder()
        //distinct : 중복제거
        List<String> leanlist = Arrays.asList("Java", "Scala", "Groovy", "Python", "Go", "Swift");
        leanlist.stream()
                .sorted()
                .distinct()
                .forEach(System.out::println);
        System.out.println("===========================================");
        leanlist.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
        System.out.println("===========================================");

        //peek : 중간연산 , 주로 값을 중간에 찍어보는 용도로 사용됨.
        int sum = IntStream.of(1, 3, 5, 7, 9)
                .peek(System.out::println)
                .sum();
        System.out.println(sum);
        System.out.println("===========================================");

        //collect : 스트림의 결과값을 List, Map, Set등 다른 종류의 결과값으로 수집할 때 사용되는 메서드.
        //summarizingInt :  하나의 스트림으로 갯수, 합계, 평균, 최댓값, 최솟값을 알 수 있는 메서드.
        List<Product> productList = Arrays.asList(
                new Product(23, "potatoes"),
                new Product(14, "orange"),
                new Product(13, "lemon"),
                new Product(23, "bread"),
                new Product(13, "sugar"));

        List<String> nameList = productList.stream()
                .map(Product::getName)
                .collect(Collectors.toList());
        System.out.println(nameList);
        System.out.println("===========================================");
        IntSummaryStatistics statistics = productList.stream()
                .collect(Collectors.summarizingInt(Product::getValue));
        System.out.println(statistics);
        System.out.println("===========================================");

        //groupingBy : Stream에서 작업한 결과를 특정 그룹으로 묶는 메서드. 결과는 Map으로 반환된다.
        Map<Integer, List<Product>> collect = productList.stream()
                .collect(Collectors.groupingBy(Product::getValue));
        System.out.println(collect);
    }
}

class Product {
    int value;
    String name;

    public Product(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}
