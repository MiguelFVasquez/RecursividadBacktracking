package Model;
public class NQueens {
    private static final int N = 8;
    private static boolean foundSolution = false;

    public static void main(String[] args) {
        int[][] board = new int[N][N];
        solveNQueens(board, 0);
    }

    public static void solveNQueens(int[][] board, int col) {
        if (foundSolution) {
            return;
        }

        if (col == N) {
            printSolution(board,0,0);
            foundSolution = true;
            return;
        }

        for (int row = 0; row < N; row++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;
                solveNQueens(board, col + 1);
                board[row][col] = 0;
            }
        }
    }

    private static boolean isSafe(int[][] board, int row, int col) {
        // Verificar la fila en busca de reinas
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Verificar la diagonal superior izquierda
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Verificar la diagonal inferior izquierda
        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private static void printSolution(int[][] board, int filas, int columnas) {
        System.out.print(board[filas][columnas]+ " ");
        if (filas!= board.length-1 || columnas!= board[filas].length-1){
            if (columnas==board[filas].length-1){
                filas++;
                columnas=0;
                System.out.println(" ");
            }else {
                columnas++;
            }
            printSolution(board,filas,columnas);
        }
    }
}
