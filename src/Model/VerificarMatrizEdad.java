package Model;

import java.util.ArrayList;
import java.util.List;

public class VerificarMatrizEdad {

    public static void main(String[] args) {
        Persona p1= new Persona(5); //Primo
        Persona p2= new Persona(7); //primo
        Persona p3= new Persona(1);
        Persona p4= new Persona(3);//primo
        Persona p5= new Persona(6);//perfecto
        Persona p6= new Persona(45);
        Persona p7= new Persona(13);//primo
        Persona p8= new Persona(89);//primo
        Persona p9= new Persona(2);//primo
        Persona p10= new Persona(28);
        Persona p11= new Persona(496);
        Persona p12= new Persona(8128);
        Persona p13= new Persona(11);//primo
        Persona p14= new Persona(4);
        Persona p15= new Persona(8);
        Persona p16= new Persona(89);//primo
        Persona p17= new Persona(31);//primo
        Persona p18= new Persona(37);//primo
        Persona p19= new Persona(43);//primo
        Persona p20= new Persona(10);

        int [][] matriz= {
                {5,7,1,3},
                {6,45,13,89},
                {2,28,496,8128},
                {11,4,8,89},
                {31,37,43,10}

        };
        List<Integer> listaEdadPrimo= new ArrayList<>();
        List<Integer> listaEdadPerfecto= new ArrayList<>();
        System.out.println("-------------------------------------");
        recorrerMatriz(matriz,0,0,listaEdadPrimo,listaEdadPerfecto);
        System.out.println("Personas con número primo\n");
        imprimirArrayListRecursivo(listaEdadPrimo,0);
        System.out.println("\nPersonas con una edad equivalente a un número perfecto\n");
        imprimirArrayListRecursivo(listaEdadPerfecto,0);
    }

    public static void recorrerMatriz(int [][] matriz, int i,int j, List<Integer> listaEdadPrimo,  List<Integer> listaEdadPerfecto){
        int filas= matriz.length;
        int columnas= matriz[0].length;
        //verificar si se ha llegado al final de la matriz
        if (i>=filas || j>=columnas){
            return;
        }

        if (esPrimo(matriz[i][j])){
            listaEdadPrimo.add(matriz[i][j]);
        } else if (esNumeroPerfecto(matriz[i][j])) {
            listaEdadPerfecto.add(matriz[i][j]);
        }else if (esPrimo(matriz[i][j]) && esNumeroPerfecto(matriz[i][j])){
            listaEdadPrimo.add(matriz[i][j]);
            listaEdadPerfecto.add(matriz[i][j]);
        }
        if (j+1<columnas){
            recorrerMatriz(matriz,i,j+1,listaEdadPrimo,listaEdadPerfecto);
        } else if (i+1< filas) {
            recorrerMatriz(matriz,i+1,0,listaEdadPrimo,listaEdadPerfecto);
        }

    }

    public static boolean esPrimo(int numero) {
        // Casos base
        if (numero <= 1) return false;
        if (numero <= 3) return true;


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

    public static void imprimirArrayListRecursivo(List<Integer> lista, int index) {
        // Base case: si el índice es igual o mayor que el tamaño de la lista, detener la recursión.
        if (index >= lista.size()) {
            return;
        }

        // Imprimir el elemento en el índice actual
        System.out.print(lista.get(index)+" ");

        // Llamar recursivamente para imprimir el siguiente elemento en la lista
        imprimirArrayListRecursivo(lista, index + 1);
    }



}
