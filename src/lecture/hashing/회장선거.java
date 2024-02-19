package lecture.hashing;

import java.util.*;

public class 회장선거 {

    public String solution(String[] votes, int k){
        String answer = " ";

        Map<String, Set<String>> votesMap = new HashMap<>();
        Map<String, Integer> candidate = new HashMap();
        Map<String, Integer> present = new HashMap();
        for (String vote : votes) {
            String a = vote.split(" ")[0];
            String b = vote.split(" ")[1];
            votesMap.putIfAbsent(a, new HashSet<String>());
            votesMap.get(a).add(b);
            candidate.put(b, candidate.getOrDefault(b, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for (String a : votesMap.keySet()) {
            int cnt = 0;
            for (String b : votesMap.get(a)) {
                if(candidate.get(b) >= k) cnt++;
            }
            present.put(a, cnt);
            max = Math.max(max, cnt);
        }

        List<String> res = new ArrayList<>();
        for (String a : present.keySet()) {
            if (present.get(a) >= max) res.add(a);
        }

        Collections.sort(res);

        return res.get(0);
    }

    public static void main(String[] args){
        회장선거 T = new 회장선거();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }
}
