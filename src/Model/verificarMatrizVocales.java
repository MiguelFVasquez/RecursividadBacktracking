package Model;

import java.util.ArrayList;
import java.util.List;

public class verificarMatrizVocales {

    public static void main(String[] args) {
        String [][] matriz= { {"vacio","carro", "baul", "perro"},
                              {"colombia" , "casa", "moto", "caza"},
                              {"llanta", "reir", "archivo", "silla" },
                              {"cocina", "ola", "ave", "freir"}
                            };
        List<String> listaPalabras= new ArrayList<>();
        System.out.println("-------------------");
        recorrerMatriz(matriz,0,0,listaPalabras);
        System.out.println(listaPalabras.toString());

    }

    public static void recorrerMatriz(String [][] matriz, int i, int j, List<String> listaPalabras){
        int filas= matriz.length;
        int columnas= matriz[0].length;
        //verificar si se ha llegado al final de la matriz
        if (i>=filas || j>=columnas){
            return;
        }
        if (verificarVocalesSeguidas(matriz[i][j],0 )){
            listaPalabras.add(matriz[i][j]);
        }
        if (j+1 <columnas){
            recorrerMatriz(matriz,i,j+1,listaPalabras);
        } else if (i+1<filas) {
            recorrerMatriz(matriz,i+1,0,listaPalabras);
        }

    }

    public static boolean verificarVocalesSeguidas(String palabra, int indice){
        char [] letras= palabra.toCharArray();
        //se verifica si ya se llego al final del arreglo o si la pabra es muuy corta para tener dos voxales seguidas
        if (indice>=letras.length-1) {
            return false;
        }
        char letraActual= letras[indice];
        char letraSiguiente= letras[indice+1];

        if (esVocal(letraActual) && esVocal(letraSiguiente)){
            return true;
        }

        return verificarVocalesSeguidas(palabra,indice+1);
    }

    public static boolean esVocal(char letra){
        return letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u';
    }
}

