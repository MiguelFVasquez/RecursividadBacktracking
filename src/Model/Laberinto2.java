package Model;

public class Laberinto2 {
    public char[][] laberinto={
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', ' ', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', ' ', ' ', ' ', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', ' ', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
    };


    /* --------------------- PRUEBA DEL ALGORITMO --------------------- */
    public static void main(String[] args) {
        Laberinto2 m = new Laberinto2(); 										// construimos un objeto de la clase Laberinto por defecto
        m.laberinto[1][1] = 'X'; 											// introducimos en este caso, la salida (X) en las coordenadas (1,1)
        m.resuelve(8, 1); 											// ahora, introducimos la entrada (S) en las coordenadas (8,1) y llamamos al algoritmo
        //System.out.println(m.imprimirLaberinto()); 							// imprimimos el laberinto ya resuelto (si tiene solución)
        imprimirLaberinto(m.laberinto, 0,0);
    }




    /* ----------------- IMPLEMENTACIÓN DEL ALGORITMO ----------------- */
    public void resuelve(int x, int y){ 				// permite introducir unas coordenadas (x, y)
        if (paso(x, y)) { 								// intentará resolver el laberinto en estas coordenadas
            laberinto[x][y] = 'S'; 						// introduce en las coordenadas (x, y) la entrada
        }
    }

    private boolean paso(int x, int y){

        if (laberinto[x][y]=='X'){ // si hemos llegado a X quiere decir que hemos encontrado solución
            return true; // luego, el algoritmo termina
        }
        boolean result; // se coloca S de START)

        result=paso(x, y+1); // intentamos ir hacia la DERECHA. Primera llamada recursiva
        if (result)return true; // si el resultado es el final, entonces el algoritmo termina

        result=paso(x-1, y); // intentamos ir hacia ARRIBA. Segunda llamada recursiva
        if (result) return true; // si el resultado es el final, entonces el algoritmo termina

        result=paso(x, y-1); // intentamos ir hacia la IZQUIERDA. Tercera llamada recursiva
        if (result) return true; // si el resultado es el final, entonces el algoritmo termina

        result=paso(x+1, y); // intentamos ir hacia ABAJO. Cuarta llamada recursiva
        if (result) return true; // si el resultado es el final, entonces el algoritmo termina


        if (laberinto[x][y]=='#'||laberinto[x][y]=='*' ||laberinto[x][y]=='f') { // si llegamos a una pared o al mismo punto,
            return false; // entonces el laberinto no puede resolverse y termina.
        }

        // si no se cumple ninguna de estas dos situaciones, quiere decir que nos encontramos en un
        // caso intermedio, por lo tanto, que empezamos a recorrer o todavía no hemos llegado a nada
        laberinto[x][y]='*'; // marcamos la posición como visitada (si es la primera, en las coordenadas x e y

        // si no hemos encontrado la solución en estos cuatros movimientos, volvemos atrás, aunque hay que
        // considerar que en este punto, todas las llamadas recursivas han finalizado. Si en ninguna de ellas
        // se ha conseguido el éxito, entonces el algoritmo termina y devuelve false.
        laberinto[x][y]='f'; // en el caso de no ser el resultado, se marca con +. Ya fue pisado
        return false; // vuelta atrás si la solución no se encuentra aquí


    }

    private static void imprimirLaberinto(char [][] matriz, int filas, int columnas) { // imprimiremos nuestra solución. Debido a que la clase Arrays no tiene implementado
        System.out.print(matriz[filas][columnas]+ " ");
        if (filas!= matriz.length-1 || columnas!= matriz[filas].length-1){
            if (columnas==matriz[filas].length-1){
                filas++;
                columnas=0;
                System.out.println(" ");
            }else {
                columnas++;
            }
            imprimirLaberinto(matriz,filas,columnas);
        }
    }
}
