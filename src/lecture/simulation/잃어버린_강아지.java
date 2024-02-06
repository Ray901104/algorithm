package lecture.simulation;

public class 잃어버린_강아지 {

    public int solution(int[][] board){
        int answer = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0, d1 = 0, d2 = 0;
        int mins = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 2) {
                    x1 = i;
                    y1 = j;
                }
                if (board[i][j] == 3) {
                    x2 = i;
                    y2 = j;
                }
            }
        }

        while (mins < 10000) {
            mins++;
            int nx1 = x1 + dx[d1];
            int ny1 = y1 + dy[d1];
            int nx2 = x2 + dx[d2];
            int ny2 = y2 + dy[d2];
            boolean movedHyunsoo = true;
            boolean movedDog = true;

            if (nx1 < 0 || nx1 >= board.length || ny1 < 0 || ny1 >= board.length || board[nx1][ny1] == 1) {
                d1 = (d1 + 1) % 4;
                movedHyunsoo = false;
            }

            if (nx2 < 0 || nx2 >= board.length || ny2 < 0 || ny2 >= board.length || board[nx2][ny2] == 1) {
                d2 = (d2 + 1) % 4;
                movedDog = false;
            }

            if (movedHyunsoo) {
                x1 = nx1;
                y1 = ny1;
            }

            if (movedDog) {
                x2 = nx2;
                y2 = ny2;
            }

            if (x1 == x2 && y1 == y2) {
                break;
            }
        }
        if(mins >= 10000) return 0;
        answer = mins;
        return answer;
    }

    public static void main(String[] args){
        잃어버린_강아지 T = new 잃어버린_강아지();
        int[][] arr1 = {
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(T.solution(arr1));

        int[][] arr2 = {
                {1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}
        };
        System.out.println(T.solution(arr2));
    }
}
