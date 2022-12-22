package generic;

import java.util.Collections;
import java.util.Comparator;

/**
 * 와일드 카드의 하한제한 <? super T>
 */

class Fruits {
    String name;
    int weight;

    public Fruits(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name + "("+weight+")";
    }
}
class Apples extends Fruits {
    public Apples(String name, int weight) {
        super(name, weight);
    }
}
class Grapes extends Fruits {
    public Grapes(String name, int weight) {
        super(name, weight);
    }
}
class AppleComp implements Comparator<Apples> {
    @Override
    public int compare(Apples o1, Apples o2) {
        return o2.weight - o1.weight;
    }
}
class GrapeComp implements Comparator<Grapes> {

    @Override
    public int compare(Grapes o1, Grapes o2) {
        return o2.weight - o1.weight;
    }
}

class FruitComp implements Comparator<Fruits> {

    @Override
    public int compare(Fruits o1, Fruits o2) {
        return o1.weight - o2.weight;
    }
}
class FruitsBox <T extends Fruits> extends Box<T> {}


public class Exam5 {
    public static void main(String[] args) {
        FruitsBox<Apples> appleBox = new FruitsBox<Apples>();
        FruitsBox<Grapes> grapeBox = new FruitsBox<Grapes>();

        appleBox.add(new Apples("이건 사과1", 100));
        appleBox.add(new Apples("이건 사과2", 300));
        appleBox.add(new Apples("이건 사과3", 200));

        grapeBox.add(new Grapes("이건 포도1", 400));
        grapeBox.add(new Grapes("이건 포도2", 300));
        grapeBox.add(new Grapes("이건 포도3", 200));

        Collections.sort(appleBox.getList(), new AppleComp());
        Collections.sort(grapeBox.getList(), new GrapeComp());

        System.out.println(appleBox);
        System.out.println(grapeBox);
        System.out.println();

        Collections.sort(appleBox.getList(), new FruitComp());
        Collections.sort(grapeBox.getList(), new FruitComp());

        System.out.println(appleBox);
        System.out.println(grapeBox);


    }
}
