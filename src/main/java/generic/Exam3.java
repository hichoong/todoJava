package generic;

/**
 * 제한된 제네릭 클래스
 * 제네릭 클래스로 만들어 타입을 명시해도 모든 종류의 타입을 지정할 수 있음
 * 이를 해결할 수 있는 방법으로 제네릭타입 매개변수에 지정할 수 있는 타입의 종류를 제한할 수 있음
 *
 */


class FruitBox<T extends Fruit & Eatable> extends Box<T> {}
public class Exam3 {
    public static void main(String[] args) {
        FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
        FruitBox<Apple> appleBox= new FruitBox<Apple>();
        FruitBox<Grape> grapeBox = new FruitBox<Grape>();
        //FruitBox<Grape> grapeFruitBox = new FruitBox<Apple>(); //에러 타입 불일치
        //FruitBox<Toy> toyBox = new FruitBox<Toy>(); // 에러 Fruit 상속을 받지 않음

        fruitBox.add(new Fruit());
        fruitBox.add(new Apple());
        fruitBox.add(new Grape());
        appleBox.add(new Apple());
        //grapeBox.add(new Apple()); //에러 Grape는 Apple의 자손이 아님

        System.out.println("fruitBox : " + fruitBox);
        System.out.println("appleBox : " + appleBox);
        System.out.println("grapeBox : " + grapeBox);

    }
}
