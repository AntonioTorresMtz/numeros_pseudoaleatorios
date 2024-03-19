package multiplicador;

import java.util.Arrays;
import java.util.Scanner;

public class Multiplicador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingresa el valor K");
        long k = leer.nextInt();
        leer.nextLine();
        System.out.println("Ingresa el valor de la semilla inicial");
        long x0 = leer.nextInt();
        leer.nextLine();
        System.out.println("Ingresa el numero de numeros aleatorios a calcular");
        int tam = leer.nextInt();
        leer.nextLine();

        long arreglo[] = new long[tam];
        String valor[] = new String[tam];
        double semilla[] = new double[tam];
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = k * x0;
            valor[i] = String.valueOf(arreglo[i]);
           // System.out.println(valor[i]);

            if (valor[i].length() % 2 == 0) {
                valor[i] = "0" + valor[i];
                int aux;
                aux = valor[i].length() - 5;
                aux = aux / 2;
                // System.out.println(valor[i]);
                valor[i] = valor[i].substring(aux, valor[i].length() - aux);
                //System.out.println(valor[i]);
                arreglo[i] = Integer.parseInt(valor[i]);
                semilla[i] = arreglo[i] / Math.pow(10, 5);
                System.out.println("r" + (i + 1) + "= " + valor[i] + "  " + "x" + (i+1) + "= " + semilla[i]);

            } else {
                int aux;
                aux = valor[i].length() - 5;
                aux = aux / 2;
                valor[i] = valor[i].substring(aux, valor[i].length() - aux);
                arreglo[i] = Integer.parseInt(valor[i]);
                semilla[i] = arreglo[i] / Math.pow(10, 5);
                System.out.println("r" + (i + 1) + "= " + valor[i] + "  " + "x" + (i+1) + "= " + semilla[i]);
            }

            x0 = arreglo[i];

        }
        Arrays.sort(semilla);
        //  for (int j = 0; j < semilla.length; j++) {
        //       System.out.println(semilla[j]);
        //}
        
        System.out.println("Deseas realizar la prueba KS");
        String si=leer.nextLine();
       
        
        if (si.equals("si")) {
            
             double grupo = 1.0 / (double) tam;
        // System.out.println(grupo);
        double sr2[] = new double[tam];
        double sr1[] = new double[tam];

        int j = 1;
        System.out.println("");
        System.out.println("S(Ri)");
        for (int i = 0; i < sr1.length; i++) {
            sr1[i] = j * grupo;
            System.out.println(sr1[i]);
            j++;
        }

        System.out.println("");
        System.out.println("");
        System.out.println("S´(Ri)");
        for (int i = 0; i < sr2.length; i++) {
            sr2[i] = i * grupo;
            System.out.println(sr2[i]);
        }

        System.out.println("");
        double[] FS = new double[tam];
        double[] FS1 = new double[tam];

        System.out.println("");
        System.out.println("F(Ri)-S(Ri)");
        for (int i = 0; i < tam; i++) {
            FS[i] = Math.abs(semilla[i] - sr1[i]);
            System.out.println(FS[i]);

        }

        System.out.println("");
        System.out.println("F(Ri)-S´(Ri)");
        for (int i = 0; i < tam; i++) {

            FS1[i] = Math.abs(semilla[i] - sr2[i]);
            System.out.println(FS1[i]);

        }
        double max = 0;
        for (int i = 0; i < tam; i++) {
            if (FS[i] > max) {
                max = FS[i];
            }
        }
        System.out.println(max);
        double max1 = 0;
        for (int i = 0; i < tam; i++) {
            if (FS[i] > max1) {
                max1 = FS[i];
            }
        }
        System.out.println(max1);
        if (max > max1) {
            System.out.println("La Diferencia Maxima es: " + max);
        } else {
            System.out.println("La Diferencia Maxima es: " + max1);
        }

            
        }
       
        
    }
}
