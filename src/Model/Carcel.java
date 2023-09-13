package Model;

import java.util.HashSet;
import java.util.Set;

public class Carcel {
    public char [][] carcel= {
            {' ','P','X',' ','P','P',' ','P'},
            {' ','P','P',' ','P','P',' ','P'},
            {' ',' ',' ',' ',' ',' ',' ',' '},
            {'P',' ','P','P',' ','P','P',' '},
            {'P',' ','X','P',' ','P','P',' '},
            {' ',' ',' ',' ',' ',' ',' ',' '},
            {'P','X','P',' ','P','P',' ','P'}
    };
    //hay 23 presos
    //Se escaparon 3
    //Deben de haber 26
    private int cantPresos = 0;

    private int presosFaltantes=0;

    public static void main(String[] args) {
        Carcel c= new Carcel();
        c.carcel[0][0]='C';
        c.resuelve(5,7);
        imprimirCarcel(c.carcel,0,0);
    }

    public void resuelve(int x, int y){
        if (paso(x,y)){
            carcel[x][y]='G';
        }
        if (presosFaltantes==0){
            System.out.println("No se ha escapado ningun preso");
        }else {
            System.out.println("Se han escapado un total de: "+ presosFaltantes+ " presos");
        }
        System.out.println("Cantidad de presos: " + cantPresos);
    }

    /**
     *
     * @param x, valor de las filas
     * @param y, valor de las columnas
     * @return
     */

    private boolean paso(int x, int y){
        if (x < 0 || x >= carcel.length || y < 0 || y >= carcel[0].length) {
            return false; // Fuera de los límites
        }

        if (carcel[x][y]=='C'){
            return true;
        }
        if (carcel[x][y]=='*' || carcel[x][y]=='f'){
            return false;
        }

        if (carcel[x][y]=='X'){
            presosFaltantes++;
            carcel[x][y]= '*';
            return false;
        }
        if (carcel[x][y]=='P' ){
            cantPresos++;
            carcel[x][y]= '*';
            return false;
        }
        carcel[x][y]='*';
        boolean result;

        result= paso(x,y+1);// Derecha
        if (result) return true;

        result= paso(x+1,y); //Abajo
        if (result) return true;

        result= paso(x-1,y);//Arriba
        if (result) return true;

        result= paso(x,y-1); //Izquierda
        if (result) return true;

        carcel[x][y]='f';
        //System.out.println(cantPresos);
        return false;
    }



    private static void imprimirCarcel(char [][] matriz, int filas, int columnas) { // imprimiremos nuestra solución. Debido a que la clase Arrays no tiene implementado
        System.out.print(matriz[filas][columnas]+ " ");
        if (filas!= matriz.length-1 || columnas!= matriz[filas].length-1){
            if (columnas==matriz[filas].length-1){
                filas++;
                columnas=0;
                System.out.println(" ");
            }else {
                columnas++;
            }
            imprimirCarcel(matriz,filas,columnas);
        }
    }


}
