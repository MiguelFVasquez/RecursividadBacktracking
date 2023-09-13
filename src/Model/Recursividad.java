
package Model;

import java.util.ArrayList;

public class Recursividad {
    /**
     *
     * @param numero
     * @return
     */
    public static int sumaNaturales(int numero){
        if (numero==1){
            return 1;
        }
        return numero+ sumaNaturales(numero-1);

    }
    public int multiplicarNumeros(int a, int b) {
        if (b == 0) {
            return 0;
        } else {
            return a + multiplicarNumeros(a, b - 1);
        }
    }
    public int sumarNumerosImpares(int n) {
        if (n == 0) {
            return 0;
        } else {
            if (n % 2 != 0) {
                return n + sumarNumerosImpares(n - 1);
            } else {
                return sumarNumerosImpares(n - 1);
            }
        }
    }
    public int dividirNumeros(int a, int b) {
        if (a < b) {
            return 0;
        } else {
            return 1 + dividirNumeros(a - b, b);
        }
    }
    public static boolean esNumeroPerfecto(int numero) {
        // Llama a la función auxiliar con índice inicial 1 y suma inicial 0
        return esNumeroPerfectoAux(numero, 1, 0);
    }

    public static boolean esNumeroPerfectoAux(int numero, int divisor, int sumaDivisores) {
        if (divisor >= numero) {
            // Hemos revisado todos los divisores, verificamos si la suma es igual al número
            return sumaDivisores == numero;
        }

        if (numero % divisor == 0) {
            // Si el divisor es un divisor válido, agrégalo a la sumaDivisores
            sumaDivisores += divisor;
        }

        // Llama recursivamente con el siguiente divisor
        return esNumeroPerfectoAux(numero, divisor + 1, sumaDivisores);
    }
    public static boolean esPrimo(int numero) {
        // Casos base
        if (numero <= 1) {
            return false;
        }
        if (numero <= 3) {
            return true;
        }

        // Verificar si el número es divisible por algún número menor o igual a su raíz cuadrada
        return esPrimoRecursivo(numero, 2);
    }

    private static boolean esPrimoRecursivo(int numero, int divisor) {
        // Caso base: si el divisor alcanza la raíz cuadrada del número, no es divisible
        if (divisor * divisor > numero) {
            return true;
        }

        // Verificar si el número es divisible por el divisor actual
        if (numero % divisor == 0) {
            return false;
        }

        // Intentar el siguiente divisor
        return esPrimoRecursivo(numero, divisor + 1);
    }

    public static boolean esPotencia(int n, int b) {
        // Caso base: n es igual a b
        if (n == b) {
            return true;
        }
        // Caso base: n es menor que b (no es potencia)
        if (n < b) {
            return false;
        }
        // Llamada recursiva: dividir n por b y comprobar si el resultado es potencia de b
        return esPotencia(n / b, b);
    }
//--------------------STRINGS----------------------------------------------
    public static boolean verificarVocalesSeguidas(String palabra, int indice){
        char [] letras= palabra.toCharArray();
        if (indice!=letras.length){
            char letra= letras[indice];
            if (letra=='a' || letra=='e' || letra=='i' || letra=='o' || letra=='u'){
                return true;
            }
        }
        return verificarVocalesSeguidas(palabra,indice+1);
    }
    public static String invertir(String cadena) {
        // Caso base: si la cadena es vacía o tiene un solo carácter, retorna la misma cadena.
        if (cadena.isEmpty() || cadena.length() == 1) {
            return cadena;
        }

        // Llama recursivamente a la función para invertir la subcadena excluyendo el primer carácter.
        String subcadenaInvertida = invertir(cadena.substring(1));

        // Concatena el primer carácter al final de la subcadena invertida.
        return subcadenaInvertida + cadena.charAt(0);
    }

    public String darConsonantesRecursiva(String pal, int i) {
        if (i < pal.length()) {
            if (pal.charAt(i) >= 97 && pal.charAt(i) <= 122 && pal.charAt(i) != 'a' && pal.charAt(i) != 'e' && pal.charAt(i) != 'i' && pal.charAt(i) != 'o' && pal.charAt(i) != 'u') {
                return pal.charAt(i) + "" + darConsonantesRecursiva(pal, i + 1);
            }
            return darConsonantesRecursiva(pal, i + 1);
        } else {
            return "";
        }
    }



//--------------------ARRAYS--------------------------------------
    public static void mostrarArray(int [] arreglo, int indice){
        if (indice!=arreglo.length){
            System.out.print(arreglo[indice]+ " ");
            mostrarArray(arreglo, indice+1);
        }
    }
    public static void mostrarArray2(String [] arreglo, int indice){

        if(indice== 0)
            System.out.print("[");

        if(indice==arreglo.length)
            System.out.print("]");
        if (indice!=arreglo.length){
            System.out.print(arreglo[indice] + ", ");
            mostrarArray2(arreglo, indice+1);
        }
    }

    public int sumarElementosArray(ArrayList<Integer> array, int pos) {
        if (pos >= array.size()) {
            return 0;
        } else {
            return array.get(pos) + sumarElementosArray(array, pos + 1);
        }
    }

    //Buscar un  elemento dentro de un arreglo, devuelve la posicion en la que esta este eelememto

    public static int posicionElemento(int [] arreglo, int elementoBuscar ,int indice){
        /*SI EL ELEMENTO NO ESTA*/
        if (indice== arreglo.length){
            return -1;
        }
        /*CASO BASE*/
        if (arreglo[indice]== elementoBuscar) {
            return indice;
        }
        return posicionElemento(arreglo,elementoBuscar,indice+1);

    }

    /**
     * 2) Ordena un arreglo de manera recursiva
     * @param arreglo
     * @param n es el arreglo.length
     */
    public void ordenarArray(int[] arreglo, int n) {
        if (n == 1) {
            return;
        }
        realizarPasada(arreglo, 0, n - 1);
        ordenarArray(arreglo, n - 1);
    }
    /**
     * 2) Realiza la pasada por el arreglo modificando este mismo
     * @param arreglo
     * @param inicio
     * @param fin
     */
    private void realizarPasada(int[] arreglo, int inicio, int fin) {
        if (inicio == fin) {
            return;
        }
        if (arreglo[inicio] > arreglo[inicio + 1]) {
            int num = arreglo[inicio];
            arreglo[inicio] = arreglo[inicio + 1];
            arreglo[inicio + 1] = num;
        }
        realizarPasada(arreglo, inicio + 1, fin);
    }

    /**
     * 23) Busqueda binaria recursiva
     * @param arreglo
     * @param num     Valor a buscar
     * @param low     0
     * @param high    arreglo.length - 1
     * @return posicion del valor
     */
    public int binarySearchRecursiva(int[] arreglo, int num, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (arreglo[mid] == num) {
                return mid;
            } else if (arreglo[mid] < num) {
                return binarySearchRecursiva(arreglo, num, mid + 1, high);
            } else {
                return binarySearchRecursiva(arreglo, num, low, mid - 1);
            }
        } else {
            return -1;
        }
    }


    //-------------------MATRICES-----------------------------------

    public static void recorrerMatriz(String [][] matriz, int filas, int columnas){
        System.out.print(matriz[filas][columnas] + " ");
        if (filas!= matriz.length-1 || columnas!= matriz[filas].length-1){
            if (columnas== matriz[filas].length-1){
                filas++;
                columnas=0;
                System.out.println(" ");
            }else {
                columnas++;
            }
            recorrerMatriz(matriz, filas,columnas);
        }
    }
    //Sumar los elementos de una matriz
    public static int sumaMatrizRecursiva(int[][] matriz, int fila, int columna) {
        // Caso base: cuando estamos fuera de los límites de la matriz
        if (fila < 0 || columna < 0) {
            return 0;
        }

        // Sumar el elemento actual y avanzar en la recursión
        int elementoActual = matriz[fila][columna];
        int sumaSubmatrizSuperior = sumaMatrizRecursiva(matriz, fila - 1, columna);
        int sumaSubmatrizIzquierda = sumaMatrizRecursiva(matriz, fila, columna - 1);

        // Sumar el elemento actual y las sumas de las submatrices
        return elementoActual + sumaSubmatrizSuperior + sumaSubmatrizIzquierda
                - sumaMatrizRecursiva(matriz, fila - 1, columna - 1);
    }
    //Sumar dos matrices
    public static int[][] sumaMatrices(int[][] matrizA, int[][] matrizB) {
        int filas = matrizA.length;
        int columnas = matrizA[0].length;

        int[][] resultado = new int[filas][columnas];

        // Llamada a la función recursiva para sumar las matrices
        sumaMatricesRecursiva(matrizA, matrizB, resultado, 0, 0);

        return resultado;
    }

    private static void sumaMatricesRecursiva(int[][] matrizA, int[][] matrizB, int[][] resultado, int fila, int columna) {
        int filas = matrizA.length;
        int columnas = matrizA[0].length;

        // Verificar si hemos llegado al final de la matriz
        if (fila >= filas || columna >= columnas) {
            return;
        }

        // Sumar los elementos correspondientes y guardar el resultado en la matriz resultado
        resultado[fila][columna] = matrizA[fila][columna] + matrizB[fila][columna];

        // Llamada recursiva para el siguiente elemento en la fila o columna
        if (columna + 1 < columnas) {
            sumaMatricesRecursiva(matrizA, matrizB, resultado, fila, columna + 1);
        } else if (fila + 1 < filas) {
            sumaMatricesRecursiva(matrizA, matrizB, resultado, fila + 1, 0);
        }
    }


    //Sumar los elementos de la diagonal superior
    public  static int sumarDiagonalPrincipal(int [][] matriz, int fila, int columna){
        int filas= matriz.length; //Obtiene la cantidad de filas
        int columnas= matriz[0].length; //Obtiene la cantidad de columanas
        if (fila<0 || columna<0 || fila>= filas || columna>=columnas){ //Se verifica si la fila y la columna están dentro de los limites, si NO lo están retorna 0, en caso contrario obteine el elemento en esa posicion
            return 0;
        }
        int elementoActual= matriz[fila][columna];
        return elementoActual+sumarDiagonalPrincipal(matriz, fila+1, columna+1);
    }


    // Matriz transpuesta
    public static int[][] matrizTranspuesta(int[][] matriz, int fila, int columna) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        // Crear una matriz transpuesta con las dimensiones invertidas
        int[][] transpuesta = new int[columnas][filas];

        // Llamar a la función recursiva para llenar la matriz transpuesta
        return matrizTranspuestaRecursiva(matriz, transpuesta, fila, columna);
    }

    private static int[][] matrizTranspuestaRecursiva(int[][] matriz, int[][] transpuesta, int fila, int columna) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        // Verificar si hemos llegado al final de la matriz original
        if (fila >= filas) {
            return transpuesta;
        }

        // Copiar el elemento actual en la matriz transpuesta
        transpuesta[columna][fila] = matriz[fila][columna];

        // Mover a la siguiente fila o columna
        if (columna + 1 < columnas) {
            // Si no hemos llegado al final de la columna actual, avanzamos a la siguiente columna
            matrizTranspuestaRecursiva(matriz, transpuesta, fila, columna + 1);
        } else {
            // Si hemos llegado al final de la columna actual, avanzamos a la siguiente fila y reiniciamos la columna
            matrizTranspuestaRecursiva(matriz, transpuesta, fila + 1, 0);
        }

        return transpuesta;
    }
    //Maatriz simetrica
    public static boolean esMatrizSimetrica(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        // Verificar si la matriz es cuadrada
        if (filas != columnas) {
            return false;
        }

        // Llamar a la función recursiva para comprobar la simetría
        return esMatrizSimetricaRecursiva(matriz, 0, 0);
    }

    private static boolean esMatrizSimetricaRecursiva(int[][] matriz, int fila, int columna) {
        int filas = matriz.length;

        // Verificar si hemos llegado al final de la matriz
        if (fila >= filas) {
            return true;
        }

        // Verificar si el elemento actual es igual al elemento simétrico
        if (matriz[fila][columna] != matriz[columna][fila]) {
            return false;
        }

        // Mover a la siguiente columna o fila
        if (columna + 1 < filas) {
            // Si no hemos llegado al final de la fila actual, avanzamos a la siguiente columna
            return esMatrizSimetricaRecursiva(matriz, fila, columna + 1);
        } else {
            // Si hemos llegado al final de la fila actual, avanzamos a la siguiente fila y reiniciamos la columna
            return esMatrizSimetricaRecursiva(matriz, fila + 1, fila + 1);
        }
    }
    //Hallar promedio de la diagonal principal de una matriz
    public  static int promedioDiagonalPrincipal(int [][] matriz, int fila, int columna){
        int filas= matriz.length; //Obtiene la cantidad de filas
        int columnas= matriz[0].length; //Obtiene la cantidad de columanas
        if (fila<0 || columna<0 || fila>= filas || columna>=columnas){ //Se verifica si la fila y la columna están dentro de los limites, si NO lo están retorna 0, en caso contrario obteine el elemento en esa posicion
            return 0;
        }
        int elementoActual= matriz[fila][columna];
        return elementoActual+promedioDiagonalPrincipal(matriz, fila+1, columna+1);
    }

    //Recorrer una matriz de manera inversa
    public static void recorrerMatrizInversa(int[][] matriz, int fila, int columna) {
        // Verifica si hemos llegado al inicio de la matriz (fila y columna igual a 0).
        if (fila == 0 && columna == 0) {
            System.out.println(matriz[0][0]);
            return;
        }

        // Imprime el valor actual de la matriz y luego llama recursivamente con la fila y columna anterior.
        System.out.print(matriz[fila][columna] + " ");

        // Caso: Llegamos al inicio de una fila, pasamos a la siguiente fila y última columna.
        if (columna == 0) {
            recorrerMatrizInversa(matriz, fila - 1, matriz[0].length - 1);
        } else {
            // Caso general: Retrocedemos a la columna anterior en la misma fila.
            recorrerMatrizInversa(matriz, fila, columna - 1);
        }
    }

    //Recorrer matriz de derecha a izquierda
    public static void recorrerMatrizDerechaAIzquierda(int[][] matriz, int fila, int columna) {
        // Verifica si hemos llegado al final de la matriz (última fila y última columna).
        if (fila == matriz.length - 1 && columna == matriz[0].length - 1) {
            System.out.println(matriz[fila][columna]);
            return;
        }

        // Imprime el valor actual de la matriz y luego llama recursivamente con la fila y columna siguiente.
        System.out.print(matriz[fila][columna] + " ");

        // Caso: Llegamos al final de una fila, pasamos a la siguiente fila y primera columna.
        if (columna == 0) {
            recorrerMatrizDerechaAIzquierda(matriz, fila + 1, 0);
        } else {
            // Caso general: Avanzamos a la columna anterior en la misma fila.
            recorrerMatrizDerechaAIzquierda(matriz, fila, columna - 1);
        }
    }
    //Recorrer matriz en forma de serpiente
    public static void recorrerMatrizResultadoEspecifico(int[][] matriz, int fila, int columna) {
        // Verifica si hemos llegado al final de la matriz (última fila y última columna).
        if (fila == matriz.length - 1 && columna == matriz[0].length - 1) {
            System.out.println(matriz[fila][columna]);
            return;
        }

        // Imprime el valor actual de la matriz y luego llama recursivamente con la fila y columna siguiente.
        System.out.print(matriz[fila][columna] + " ");

        // Caso: Llegamos al final de una fila, pasamos a la siguiente fila y primera columna.
        if (columna == matriz[0].length - 1) {
            recorrerMatrizResultadoEspecifico(matriz, fila + 1, 0);
        } else if (fila % 2 == 0) {
            // Caso general: Avanzamos a la columna siguiente en la misma fila para filas pares.
            recorrerMatrizResultadoEspecifico(matriz, fila, columna + 1);
        } else {
            // Caso especial: Avanzamos a la columna anterior en la misma fila para filas impares.
            recorrerMatrizResultadoEspecifico(matriz, fila, columna - 1);
        }
    }

    public int darFilaMayorRecursiva(int[][] matriz, int i, int j, int suma, int sumaMayor, int index) {
        if (i < matriz.length) {
            if (j < matriz[0].length) {
                return darFilaMayorRecursiva(matriz, i, j + 1, suma + matriz[i][j], sumaMayor, index);
            } else {
                if (suma > sumaMayor) {
                    sumaMayor = suma;
                    index = i;
                }
                return darFilaMayorRecursiva(matriz, i + 1, 0, 0, sumaMayor, index);
            }
        } else {
            return index;
        }
    }
    /**
     * 19) Suma los elementos de las columnas impares de una matriz
     * @param matriz
     * @param i 0
     * @param j 0
     * @return
     */
    public int sumaColumnasImpares(int[][] matriz, int i, int j, int suma) {
        if (i < matriz.length) {
            if (j < matriz[0].length) {
                if (j % 2 != 0) {
                    suma += matriz[i][j];
                }
                return sumaColumnasImpares(matriz, i, j + 1, suma);
            } else {
                return sumaColumnasImpares(matriz, i + 1, 0, suma);
            }
        } else {
            return suma;
        }
    }


    /**
     * Recorre una matriz como una serpiente
     * @param matrix
     * @param i 0
     * @param j 0
     * @param cont 1
     */
    public void llenarMatrizSerpiente(int[][] matrix, int i, int j, int cont) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Caso base: Si hemos llenado toda la matriz, detener la recursión
        if (cont > rows * cols) {
            return;
        }

        // Llenar la fila de izquierda a derecha si la fila es par
        if (i % 2 == 0) {
            matrix[i][j] = cont;
        } else { // Llenar la fila de derecha a izquierda si la fila es impar
            matrix[i][cols - 1 - j] = cont;
        }
        // Calcular las coordenadas de la siguiente celda
        int nextRow = i;
        int nextCol = j + 1;

        if (nextCol >= cols) {
            nextRow++;
            nextCol = 0;
        }
        // Llamar recursivamente con el valor incrementado
        llenarMatrizSerpiente(matrix, nextRow, nextCol, cont + 1);
    }



}
