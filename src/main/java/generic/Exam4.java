package generic;
/**
 * 와읻르 카드 : <?>
 * static 메서드의 경우 매개변수의 타입을 지정하면 다른 타입은 들어 올 수 없다.
 * 이러한 경우에 <?>를 사용하면 Object타입의 역할을 대체하게 된다.
 * 와일드 카느는 어떠한 타입도 될 수 있다.
 *
 * 와일드카드 사용 방법
 * <? extends T> : 와일드 카드의 상한 제한 T와 그 자손들만 가능
 * <? super T> : 와일드 카드의 하한 제한 T와 그 조상들만 가능
 * <?> : 제한 없음
 */

class Juice {
    String name;
     Juice(String name) {
        this.name = name + "Juice";
    }
    public String toString () {
        return name;
    }
}
class Juicer {
    static Juice makeJuice(FruitBox<? extends Fruit> box) {
        String tmp = "";

        for (Fruit f : box.getList())
            tmp += f + " ";
        return new Juice(tmp);
    }
}

public class Exam4 {
    public static void main(String[] args) {
        FruitBox<Fruit> fruitBox = new FruitBox<>();
        FruitBox<Apple> applebox = new FruitBox<Apple>();

        fruitBox.add(new Apple());
        fruitBox.add(new Grape());
        applebox.add(new Apple());

        System.out.println(Juicer.makeJuice(fruitBox));
        System.out.println(Juicer.makeJuice(applebox));
    }


}
