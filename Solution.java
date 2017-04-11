public class Solution {

    /* Method which checks each square and iterates through until board is correctly filled */
    public boolean solveProblem(final int N, int board_arr[][], int col) {
        if (col >= N) return true;
        for (int i = 0; i < N; i++) {
            if (isNotAttacked(N, board_arr, col, i)) {
                board_arr[i][col] = 1;
                if (solveProblem(N, board_arr, col + 1)) return true;
                board_arr[i][col] = 0;
            }
        }
        return false;
    }

    /* Method which checks each adjacent square to see whether or not it is under attack */
    public boolean isNotAttacked(final int N, int board_arr[][], int col, int row) {
        int i, j;
        for (i = 0; i < col; i++) {
            if (board_arr[row][i] == 1) return false;
        }
        for (i = row, j = col; j >= 0 && i < N; i++, j--) {
            if (board_arr[i][j] == 1) return false;
        }
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board_arr[i][j] == 1) return false;
        }
        return true;
    }
}
