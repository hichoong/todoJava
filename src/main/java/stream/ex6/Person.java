package stream.ex6;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private int age;
    private String phoneNumber;

    public Person(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("아이언맨", 45, "010-1234-1234"));
        personList.add(new Person("토르", 1200, null));
        personList.add(new Person("헐크", 47, "010-1234-5678"));
        personList.add(new Person("블랙위도우", 47, "010-1234-5678"));
        personList.add(new Person("호크아이", 45, "010-4321-4321"));
        personList.add(new Person("캡틴아메리카", 100, null));

        //List<V> to Map<K, V>
        Map<String, Person> personMap = personList.stream().
                collect(Collectors.toMap(Person::getName, Function.identity())); // Function.identity는 항상 입력된 인자를 반환

        //위의 스트림 람다표현식이나 메서드 참조를 모두 풀어서 작성
        personList.stream().collect(Collectors.toMap(new Function<Person, String>() {
            @Override
            public String apply(Person person) {
                return person.getName();
            }
        }, new Function<Person, Person>() {
            @Override
            public Person apply(Person person) {
                return person;
            }
        }));

        //filter를 이용한 조건
        Map<String, Person> personMap2 = personList.stream()
                .filter(person -> person.getAge() >= 100) // 100살 이상만 골라낸다.
                .collect(Collectors.toMap(Person::getName, Function.identity()));
        personMap2.forEach((s, person) ->
                System.out.println("이름=" + s +"나이=" + person.getAge() +"전화번호="+person.getPhoneNumber()));

        //하나의 키에 두개의 값이 들어와 예외사항(IllegalStateException)발생 시 BinaryOperator를 사용하는 방식
        Map<Integer, Person> integerPersonMap = personList.stream()
                .collect(Collectors.toMap(
                person -> person.getAge(), Function.identity(),
                (oldValue, newValue) -> newValue
        ));

        //중복 키를 허용하는 방식 (duplicateKey) Collectors.groupingBy을 사용해 그룹핑
        //Map<Integer, List<Person>> duplicateMap = personList.stream().collect(Collectors.groupingBy(Person::getAge));
        Map<Integer, List<Person>> duplicateMap = new HashMap<>();
        for (Person person : personList) {
            duplicateMap.computeIfAbsent(person.getAge(), k -> new ArrayList<>()).add(person);
        }
        for(Integer key : duplicateMap.keySet()){
            List<Person> value = duplicateMap.get(key);
            System.out.println(key+" : "+value.toString());
        }

        //스트림 정렬하기 sort
        personList.stream().sorted(Comparator.comparing(Person::getAge))
                .forEach(person -> System.out.println(person.getName() +" " + person.getAge()));
    }
}
