package solution.practice;

import solution.icecream.Icecream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //객체 생성
        Icecream melona = new Icecream("메로나", 1500);
        Icecream ssamanko = new Icecream("붕어싸만코", 2500);
        Icecream  ssangssangba= new Icecream("쌍쌍바", 2000);
        Icecream  babamba= new Icecream("바밤바", 1000);
        Icecream  bibibig= new Icecream("비비빅", 2000);
        Icecream  wa= new Icecream("와", 2500);
        Icecream  doublebiyanko= new Icecream("더블비얀코", 1500);
        //stream 사용을 위한 리스트 만들기
        List<Icecream> icecreams = new ArrayList<>();
        icecreams.add(melona);
        icecreams.add(ssamanko);
        icecreams.add(ssangssangba);
        icecreams.add(babamba);
        icecreams.add(bibibig);
        icecreams.add(wa);
        icecreams.add(doublebiyanko);

        //값 들어갔는지 확인하기
        icecreams.stream().forEach(icecream -> System.out.println(icecream.toString()));

        //list, map으로 바꾸기
        Map<String, Icecream> collect = icecreams.stream()
                .collect(Collectors.toMap(Icecream::getName, Function.identity()));
        //조건 사용 * 여기선 IllegalStateException: Duplicate key 2000 (attempted merging values Icecream{name='쌍쌍바', price=2000} and Icecream{name='비비빅', price=2000}) 하나의 키에 두개 값이 들어옴

        /*icecreams.stream().filter(icecream -> icecream.getPrice()>=2000)
                .collect(Collectors.toMap(Icecream::getPrice, Function.identity()));*/

        //그룹핑
        Map<Integer, List<Icecream>> integerListMap = new HashMap<>();
        for (Icecream icecream : icecreams) {
            integerListMap.computeIfAbsent(icecream.getPrice(), k -> new ArrayList<>()).add(icecream);
        }
        for (Integer key : integerListMap.keySet()) {
            List<Icecream> value = integerListMap.get(key);
            System.out.println(key+" : "+value.toString());
        }

        icecreams.stream().sorted(Comparator.comparing(Icecream::getPrice))
                .forEach(icecream -> System.out.println(icecream));
    }




}
