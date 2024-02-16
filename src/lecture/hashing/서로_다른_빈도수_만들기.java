package lecture.hashing;

import java.util.*;

public class 서로_다른_빈도수_만들기 {

    public int solution(String s){
        int answer = 0;
        Map<Character, Integer> sh = new HashMap<>();
        for (char c : s.toCharArray()) {
            sh.put(c, sh.getOrDefault(c, 0) + 1);
        }

        Set<Integer> ch = new HashSet<>();
        for (char key : sh.keySet()) {
            while (ch.contains(sh.get(key))) {
                answer++;
                sh.put(key, sh.get(key) - 1);
            }
            if(sh.get(key) == 0) continue;
            ch.add(sh.get(key));
        }

        return answer;
    }

    public static void main(String[] args){
        서로_다른_빈도수_만들기 T = new 서로_다른_빈도수_만들기();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }
}
