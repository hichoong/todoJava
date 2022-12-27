package refactoring;
/**
 * 리팩토링시 자주 사용되는 단축키
 * 1. extract method
 * 2. extract variable
 * 3. extract constant
 * 4. rename
 * 5. remove inline
 * 6. touch bar에서 활용
 */
public class HelloWorld {
    public static final String HELLO_WORLD = "Hello World";

    public static void main(String[] args) {
        String helloWorld = HELLO_WORLD;
        System.out.println(HELLO_WORLD);


    }
}
