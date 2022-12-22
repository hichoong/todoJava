package generic;

/**
 * 제네릭 : 다양한 타입의 객체들을 다루는 메서드나 컬렉션 클래스에 컴파일 시 타입 체크를 해주는 기능
 * 장점
 * 타입 안정성을 제공
 * 타입체크와 형변환을 생략할 수 있어 코드가 간결해 짐
 */

/**
 *기존의 클래스를 만들던 방식
 **/

public class exam1 {
    public static void main(String[] args) {
        Box<String> box = new Box<>();
        box.add("이건 뭘까요?");
        box.add("저도 모르죠");

        System.out.println(box);
    }
}