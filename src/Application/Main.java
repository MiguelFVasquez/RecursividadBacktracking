package Application;


import Model.Recursividad;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hay dos vocales seguidas: "+ Recursividad.verificarVocalesSeguidas("casa",0) );

        //System.out.println("Suma de los n enteros: " + Recursividad.sumaNaturales(9));
        //System.out.println("Factorial: " + Recursividad.factorial(4));
        System.out.println("El numero es primo: " + Recursividad.esPrimo(4));
        System.out.println("El numero es potencia de: " + Recursividad.esPotencia(50,10));
        //-------------------ARRAYS-------------------------------------
        int[] array = {1, 2, 3, 4, 5};
        //Recursividad.mostrarArray(array, 0);
        //System.out.println("Posicion del elemento a buscar: " + Recursividad.posicionElemento(array, 310, 0));
        //--------------------MATICES------------------------------

        int[][] matriz = {  {1, 2, 3,4},
                            {5, 6, 7,8},
                            {9, 10,11,12},
                         };
        //Recursividad.recorrerMatriz(matriz,0,0);
        //Sumar matriz de forma recursiva
        int filas= matriz.length;
        int columnas= matriz[0].length;
        //int resultado= Recursividad.sumaMatrizRecursiva(matriz, filas-1, columnas-1);
        //System.out.println(resultado);
        //int sumaDiagonal= Recursividad.sumarDiagonalPrincipal(matriz, 0, 0);
        //System.out.println(sumaDiagonal);
        //int [][] matrizTranspuesta= Recursividad.matrizTranspuesta(matriz,0,0);
        //Recursividad.recorrerMatriz(matrizTranspuesta,0,0);

        int[][] matrizSimetrica = {
                {1, 2, 3},
                {2, 4, 5},
                {3, 5, 6}
        };

        int[][] matrizNoSimetrica = {
                {9, 2, 3},
                {2, 4, 5},
                {6, 7, 8}
        };
        //System.out.println("¿La matriz es simétrica? " + Recursividad.esMatrizSimetrica(matrizSimetrica)); // Debe imprimir true
        int fila= matrizSimetrica.length;
        int promedio= Recursividad.promedioDiagonalPrincipal(matrizNoSimetrica,0,0)/fila;
        System.out.println("El promedio es: " + promedio);
    }

}