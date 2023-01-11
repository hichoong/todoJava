package solution.practice;

import solution.icecream.Icecream;

import java.lang.reflect.Method;

public class Main2 {
    public static void main(String[] args) throws Exception {
        //리플렉션 다시 적용해 보기
        Object merona = new Icecream("메로나", 1500);
        Class icecream = Icecream.class;
        Method setName = icecream.getMethod("setName", String.class);
        setName.invoke(merona, "메로나업그레이드");
        System.out.println(merona.toString());
    }
}
