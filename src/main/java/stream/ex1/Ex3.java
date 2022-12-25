package stream.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ex3 {
    public static void main(String[] args) {

        //요구사항 1. 29살 김건휘를 찾기.
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("김건휘", 29));
        itemList.add(new Item("김건회", 30));
        itemList.add(new Item("김건희", 29));
        itemList.add(new Item("김충희", 28));
        itemList.add(new Item("김은석", 58));
        itemList.add(new Item("김차옥", 58));

        List<Item> result1 = itemList.stream().filter(i -> i.getName().equals("김건휘")).collect(Collectors.toList());
        System.out.println(result1);
        //요구사항 2. 나이가 같으면 그룹핑 해주기.

        Map<Integer, List<Item>> result2 = itemList.stream().collect(Collectors.groupingBy(Item::getAge, Collectors.toList()));
        System.out.println(result2);


        //요구사항 3. 나이가 30이상인 객체 찾기.

        List<Item> result3 = itemList.stream()
                .filter(i -> i.getAge() >= 30)
                .collect(Collectors.toList());
        System.out.println(result3);
        //요구사항 4. 이름이 희가 들어간 사람 찾기.
        List<Item> result4 = itemList.stream()
                .filter(i -> i.getName()
                        .contains("희"))
                .collect(Collectors.toList());
        System.out.println(result4);

        //요구사항 5. 이름이 희가 들어간 사람들의 나이만 리턴.
        itemList.stream().filter(i -> i.getName().contains("희")).mapToInt(i -> i.getAge()).forEach(System.out::println);
    }

    static class Item {
        String name;
        int age;

        public Item(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Item() {
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

        @Override
        public String toString() {
            return "Item{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }


}
