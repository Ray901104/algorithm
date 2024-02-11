package lecture.simulation;

public class 비밀번호 {

    public int solution(int[] keypad, String password){
        int answer = 0;
        int[][] board = new int[3][3];

        //3 * 3 키패드로 변환
        int keyCount = 0;
        while (keyCount < keypad.length) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    board[i][j] = keypad[keyCount++];
                }
            }
        }

        //거리(초) 배열 초기화
        int[][] dist = new int[9][9];
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
                if(i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = 2;
                }
            }
        }

        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                for (int d = 0; d < 8; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) {
                        continue;
                    }
                    dist[board[i][j] - 1][board[nx][ny] - 1] = 1;
                }
            }
        }

        for (int i = 0; i < password.length() - 1; i++) {
            int from = Character.getNumericValue(password.charAt(i));
            int to = Character.getNumericValue(password.charAt(i + 1));

            answer += dist[from-1][to-1];
        }

        return answer;
    }

    public static void main(String[] args){
        비밀번호 T = new 비밀번호();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}
