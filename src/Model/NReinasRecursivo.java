package Model;

public class NReinasRecursivo {
    private static final int N = 8;  // Tamaño del tablero de ajedrez (8x8)
    private static boolean solucionEncontrada = false;  // Variable para controlar si se encontró una solución

    public static void main(String[] args) {
        int[][] tablero = new int[N][N];  // Crear un tablero NxN
        solveNQueens(tablero, 0, 0);  // Llamar a la función para resolver el problema de las N reinas desde la posición 0,0 del tablero
    }

    public static void solveNQueens(int[][] tablero, int col, int fil) {
        if (solucionEncontrada) {  // Si ya se encontró una solución, salir
            return;
        }

        if (col == N) {  // Si todas las reinas se han colocado en las columnas, imprimir la solución y marcar como encontrada
            printSolution(tablero, 0, 0);
            solucionEncontrada = true;
            return;
        }

        if (fil < N) {  // Si no se ha explorado todas las filas en la columna actual
            if (esSeguro(tablero, fil, col)) {  // Comprobar si es seguro colocar una reina en esta posición
                tablero[fil][col] = 1;  // Colocar una reina en la posición
                solveNQueens(tablero, col + 1, 0);  // Llamar recursivamente para la siguiente columna y reiniciar fila a 0
                tablero[fil][col] = 0;  // Deshacer la colocación de la reina para explorar otras posibilidades
            }
            solveNQueens(tablero, col, fil + 1);  // Intentar la siguiente fila en la misma columna
        }
    }

    // Función para verificar si es seguro colocar una reina en la posición dada
    private static boolean esSeguro(int[][] tablero, int fil, int col) {
        return revisarFila(tablero, fil, col, 0) &&  // Comprobar si no hay reinas en la misma fila
                revisarDiagonalSuperiorIzquierda(tablero, fil, col) &&  // Comprobar la diagonal superior izquierda
                revisarDiagonalInferiorIzquierda(tablero, fil, col);  // Comprobar la diagonal inferior izquierda
    }

    // Función para comprobar si no hay reinas en la misma fila
    private static boolean revisarFila(int[][] tablero, int fil, int col, int currentCol) {
        if (currentCol == col) {
            return true;  // No hay reinas en la misma fila
        }

        if (tablero[fil][currentCol] == 1) {
            return false;  // Hay una reina en la misma fila
        }

        return revisarFila(tablero, fil, col, currentCol + 1);  // Comprobar la siguiente columna
    }

    // Función para comprobar la diagonal superior izquierda
    private static boolean revisarDiagonalSuperiorIzquierda(int[][] board, int fil, int col) {
        if (fil < 0 || col < 0) {
            return true;  // No hay reinas en la diagonal superior izquierda
        }

        if (board[fil][col] == 1) {
            return false;  // Hay una reina en la diagonal superior izquierda
        }

        return revisarDiagonalSuperiorIzquierda(board, fil - 1, col - 1);  // Comprobar la siguiente posición en la diagonal
    }

    // Función para comprobar la diagonal inferior izquierda
    private static boolean revisarDiagonalInferiorIzquierda(int[][] board, int fil, int col) {
        if (fil >= N || col < 0) {
            return true;  // No hay reinas en la diagonal inferior izquierda
        }

        if (board[fil][col] == 1) {
            return false;  // Hay una reina en la diagonal inferior izquierda
        }

        return revisarDiagonalInferiorIzquierda(board, fil + 1, col - 1);  // Comprobar la siguiente posición en la diagonal
    }

    // Función para imprimir la solución
    private static void printSolution(int[][] board, int filas, int columnas) {
        System.out.print(board[filas][columnas] + " ");  // Imprimir el contenido de la casilla (0 o 1)
        if (filas != board.length - 1 || columnas != board[filas].length - 1) {
            if (columnas == board[filas].length - 1) {
                filas++;
                columnas = 0;
                System.out.println(" ");  // Cambiar de fila
            } else {
                columnas++;
            }
            printSolution(board, filas, columnas);  // Llamar recursivamente para imprimir el resto de la solución
        }
    }
}
