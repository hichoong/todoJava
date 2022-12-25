package stream.ex1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Ex2 {
    public static void main(String[] args) {
        List<Item> itemList = makeMock();
//        itemList.stream().forEach(System.out::println);
//        itemList.stream().sorted(Comparator.comparing(Item::getDate).reversed()).forEach(System.out::println);
        itemList.stream()
                .peek(i-> changeValue(i))
                .sorted(Comparator.comparing(Item::getDate)
                        .reversed())
                .forEach(System.out::println);
//        List<MockItem> mockItemList = itemList.stream().map(MockItem::new).collect(Collectors.toList());
//        List<MockItem> mockItemList = itemList.stream()
//                .map(MockItem::new)
//                .collect(Collectors.toList());

//        System.out.println(mockItemList);


//        List<MockItem> mockItemList = itemList.stream()
//                .map(i-> new MockItem(i.getName()))
//                .collect(Collectors.toList());

//        List<MockItem> mockItemList = itemList.stream()
//                .map(i -> {
//                    MockItem mockItem = new MockItem(i.getValue() + "");
//                    return mockItem;
//                })
//                .collect(Collectors.toList());
//        System.out.println(mockItemList);

        /*
        * 이거는 뭐 할때 스,ㅕㅁㄴㄷ ㅙㅁ ...
        * */
//        List<Item> collect = itemList.stream()
//                .filter(i -> i.getAuth().equals(false))
//                .collect(Collectors.toList());
//        Optional<Item> optionalItem = itemList.stream()
//                .filter(i -> i.getDate().equals(LocalDate.of(2022,12,26)))
//                .findFirst();
//        Item item = null;
//        if(optionalItem.isPresent()) {
//            item = optionalItem.get();
//        }
//        Item item = itemList.stream()
//                .filter(i -> i.getDate().equals(LocalDate.of(2023, 12, 26)))
//                .findFirst()
//                .orElseThrow(() -> new IllegalArgumentException("ggggg"));
//
//        Item item = itemList.stream()
//                .filter(i -> i.getDate().equals(LocalDate.of(2023, 12, 26)))
//                .findFirst()
//                .orElse(null);

//        if( item == null
        Optional<Item> optItem = itemList.stream()
                .filter(i -> i.getDate().equals(LocalDate.of(2023, 12, 26)))
                .findFirst();
//        optItem.ifPresent(i -> System.out.println(i.getAuth()));
        optItem.ifPresentOrElse(
                i-> System.out.println(i.getDate()),
                () -> System.out.println("없어") );
//        System.out.println(">>>>"+item);
        Item item = null;
        Optional.of(item);
    }

    private static List<Item> makeMock() {
        List<Item> itemList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Item item = new Item();
            item.name = i + "";
            item.value = i;
            if(i %2 == 0) {
                item.isAuth = true;
            } else {
                item.isAuth = false;
            }
            item.date = LocalDate.now().plusDays(Long.valueOf(i));
            itemList.add(item);
        }
        return itemList;
    }

    private static void changeValue(Item item) {
        if(item.getValue() < 5) {
            item.setValue( item.getValue() * 10 );
        }
    }

    static class MockItem {
        String key;

        public MockItem() {

        }

        public MockItem(Item item) {
            this.key = item.getName() + " " + item.getValue();
        }

        public MockItem(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return "MockItem{" +
                    "key='" + key + '\'' +
                    '}';
        }
    }
    static class Item {
        String name;
        Integer value;
        Boolean isAuth;
        LocalDate date;

        public Item() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Boolean getAuth() {
            return isAuth;
        }

        public void setAuth(Boolean auth) {
            isAuth = auth;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "name='" + name + '\'' +
                    ", value=" + value +
                    ", isAuth=" + isAuth +
                    ", date=" + date +
                    '}';
        }
    }

}
