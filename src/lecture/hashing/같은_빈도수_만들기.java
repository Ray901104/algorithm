package lecture.hashing;

import java.util.*;

public class 같은_빈도수_만들기 {

    public int[] solution(String s){
        int[] answer = new int[5];
        Map<Character, Integer> frequencies = new HashMap<>();

        for (char c : s.toCharArray()) {
            Integer frequencyNum = frequencies.get(c);
            int count = 1;
            if (frequencyNum != null) {
                frequencies.put(c, ++frequencyNum);
            } else {
                frequencies.put(c, count);
            }
        }

        int max = Integer.MIN_VALUE;
        String abcde = "abcde";
        for (char key : abcde.toCharArray()) {
            if (frequencies.getOrDefault(key, 0) > max) {
                max = frequencies.getOrDefault(key, 0);
            }
        }

        for (int i = 0; i < abcde.length(); i++) {
            answer[i] = max - frequencies.getOrDefault(abcde.charAt(i), 0);
        }

        return answer;
    }

    public static void main(String[] args){
        같은_빈도수_만들기 T = new 같은_빈도수_만들기();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}
