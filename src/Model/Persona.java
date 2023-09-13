package Model;

public class Persona {
    int edad;

    public Persona(int edad) {
        this.edad = edad;
    }
    public Persona(){

    }
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    public boolean esPrimo() {
        // Casos base
        if (this.edad <= 1) {
            return false;
        }
        if (this.edad <= 3) {
            return true;
        }

        // Verificar si el número es divisible por algún número menor o igual a su raíz cuadrada
        return esPrimoRecursivo(this.edad, 2);
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

    public  boolean esNumeroPerfecto() {
        // Llama a la función auxiliar con índice inicial 1 y suma inicial 0
        return esNumeroPerfectoAux(this.edad, 1, 0);
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

}
