package Model;

public class Parqueadero{

    String [][] parqueadero= {
            {"L"," ","L","D","R1","L"," "},
            {"L"," ","L","C"," ","L"," "},
            {" "," "," ","C"," "," "," "},
            {"C"," "," ","C","D","D"," "},
            {"C"," "," "," "," ","L"," "},
            {"C"," ","C"," "," ","L"," "},
            {"C"," ","C"," ","C","C"," "},
            {" "," ","C"," "," "," "," "},
            {"C"," ","C"," ","C"," ","C"},
            {"C"," ","R"," ","C"," ","R"},
            {" "," ","R"," ","C","C","R"},
            {" "," ","R"," "," "," ","R2"}
    };
    String[][] parqueaderoOriginal; // Parqueadero original para restaurar después de parquear el primer carro
    // Variables para mantener las ubicaciones de R1 y R2
    int r1X, r1Y;

    public static void main(String[] args) {
        Parqueadero p= new Parqueadero();
        System.out.println("------------------Sin parquear----------------------");
        imprimirParqueadero(p.parqueadero, 0,0);
        p.parqueadero[11][0]= "E";

        //copio el parqueadero original antes de parquear
        p.parqueaderoOriginal = copiarParqueadero(p.parqueadero);
        //Coordenadas del primer sitio de parqueo
        p.resuelve(0,4);
        System.out.println("\n------------------PRIMER CARRO----------------------");
        imprimirParqueadero(p.parqueadero,0,0);

        p.parqueadero = copiarParqueadero(p.parqueaderoOriginal);
        //Segundo carro
        System.out.println("\n------------------SEGUNDO CARRO----------------------");
        p.parqueadero[0][4]="e";
        p.resuelve(11,6);
        imprimirParqueadero(p.parqueadero,0,0);
    }

    public void resuelve(int x, int y){

        if (paso(x,y)){
            //Salida
            parqueadero[x][y]="e";

        }
    }

    private boolean paso(int x, int y){
        if (x < 0 || x >= parqueadero.length || y < 0 || y >= parqueadero[0].length) {
            return false; // Fuera de los límites
        }

        if (parqueadero[x][y].equals("E")){
            return true;
        }
        if (parqueadero[x][y].equals("C") || parqueadero[x][y].equals("R") || parqueadero[x][y].equals("D") || parqueadero[x][y].equals("+") ||
                parqueadero[x][y].equals("f") || parqueadero[x][y].equals("L")|| parqueadero[x][y].equals("e")){
            return false;
        }



        //derecha,abajo,arriba,izquierda
        parqueadero[x][y] = "+";
        boolean result;
        result= paso(x,y+1); //Derecha
        if (result) return true;

        result= paso(x+1,y); //Abajo
        if (result) return true;

        result= paso(x-1,y); //Arriba
        if (result) return true;

        result= paso(x,y-1  ); //Izquierda
        if (result) return true;

        parqueadero[x][y]= "f";
        return false;

    }

    // Función recursiva para copiar una matriz
    public static String[][] copiarParqueadero(String[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        String[][] matrizCopia = new String[filas][columnas];

        copiarMatrizRecursiva(matriz, matrizCopia, 0, 0);

        return matrizCopia;
    }

    // Función auxiliar recursiva para copiar la matriz y reemplazar "+"
    public static void copiarMatrizRecursiva(String[][] matrizOriginal, String[][] matrizCopia, int fila, int columna) {
        int filas = matrizOriginal.length;
        int columnas = matrizOriginal[0].length;

        if (fila < filas) {
            if (columna < columnas) {
                if (matrizOriginal[fila][columna].equals("+")) {
                    matrizCopia[fila][columna] = " "; // Reemplazar "+" por " "
                } else {
                    matrizCopia[fila][columna] = matrizOriginal[fila][columna];
                }
                copiarMatrizRecursiva(matrizOriginal, matrizCopia, fila, columna + 1);
            } else {
                copiarMatrizRecursiva(matrizOriginal, matrizCopia, fila + 1, 0);
            }
        }
    }


    private static void imprimirParqueadero(String [][] matriz, int filas, int columnas) { // imprimiremos nuestra solución. Debido a que la clase Arrays no tiene implementado
        System.out.print(matriz[filas][columnas]+ " ");
        if (filas!= matriz.length-1 || columnas!= matriz[filas].length-1){
            if (columnas==matriz[filas].length-1){
                filas++;
                columnas=0;
                System.out.println(" ");
            }else {
                columnas++;
            }
            imprimirParqueadero(matriz,filas,columnas);
        }
    }

}