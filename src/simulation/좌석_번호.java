package simulation;

import java.util.*;

public class 좌석_번호 {

    public int[] solution(int c, int r, int k){
        int[] answer = new int[2];
        if(k > c * r) return new int[]{0, 0};

        //좌석 배치 초기화
        int[][] seats = new int[c][r];

        //방향, 좌표
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0, y = 0;
        int direction = 1;

        int count = 1;
        while (count < k) {
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if (nx < 0 || nx >= c || ny < 0 || ny >= r || seats[nx][ny] > 0) {
                direction = (direction + 1) % 4;
                continue;
            }
            seats[x][y] = count;
            count++;
            x = nx;
            y = ny;
        }
        answer[0] = x + 1;
        answer[1] = y + 1;
        return answer;
    }

    public static void main(String[] args){
        좌석_번호 T = new 좌석_번호();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}
