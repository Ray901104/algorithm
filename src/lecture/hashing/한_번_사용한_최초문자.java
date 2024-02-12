package lecture.hashing;

import java.util.*;

public class 한_번_사용한_최초문자 {

    public int solution(String s){
        Map<Character, Integer> sh = new HashMap<>();
        for (char x : s.toCharArray()) {
            sh.put(x, sh.getOrDefault(x, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if(sh.get(s.charAt(i)) == 1) return i + 1;
        }
        return -1;
    }

    public static void main(String[] args){
        한_번_사용한_최초문자 T = new 한_번_사용한_최초문자();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}
