package lecture.simulation;

public class 과일_가져가기 {

    public int solution(int[][] fruit){
        int answer = 0;
        int n = fruit.length;
        int[] ch = new int[n];

        // 1. 최소값이 유일해야 한다.
        // 2. 아직 교환하지 않은 학생이어야 한다.
        // 3. 교환할 학생 서로의 과일 인덱스가 달라야 한다.
        // 4. 교환하고 나서도 최소값의 인덱스는 동일해야 한다.
        for (int i = 0; i < n; i++) {
            if(!isMinUnique(fruit[i])) continue;
            if(ch[i] == 1) continue;
            for (int j = i + 1; j < n; j++) {
                if(!isMinUnique(fruit[j])) continue;
                if(ch[j] == 1) continue;
                int a = getMinIndex(fruit[i]);
                int b = getMinIndex(fruit[j]);
                if (a != b && fruit[i][b] > 0 && fruit[j][a] > 0) {
                    if (fruit[i][a] + 1 <= fruit[i][b] - 1 && fruit[j][b] + 1 <= fruit[j][a] - 1) {
                        fruit[i][a]++;
                        fruit[j][a]--;
                        fruit[j][b]++;
                        fruit[i][b]--;
                        ch[i] = 1;
                        ch[j] = 1;
                        break;
                    }
                }
            }
        }

        for (int[] x : fruit) {
            answer += getMin(x);
        }

        return answer;
    }

    private int getMin(int[] fruit) {
        int min = Integer.MAX_VALUE;
        for (int f : fruit) {
            min = Math.min(min, f);
        }
        return min;
    }

    private int getMinIndex(int[] fruit) {
        int min = getMin(fruit);
        for (int i = 0; i < fruit.length; i++) {
            if(fruit[i] == min) return i;
        }
        return 0;
    }

    private boolean isMinUnique(int[] fruit) {
        int cnt = 0;
        int min = getMin(fruit);
        for (int f : fruit) {
            if(min == f) cnt++;
        }
        return cnt == 1;
    }

    public static void main(String[] args){
        과일_가져가기 T = new 과일_가져가기();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}
