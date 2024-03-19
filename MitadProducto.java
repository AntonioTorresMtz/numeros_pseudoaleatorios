
package mitadproducto;

import java.util.Arrays;
import java.util.Scanner;
public class MitadProducto {

    
    public static void main(String[] args) {
       Scanner leer = new Scanner(System.in);
       
        long x0, x1;
        
        System.out.println("Ingresa la primera semilla x0");
        x0=leer.nextLong();
        System.out.println("Ingresa la segunda semilla");
        x1=leer.nextLong();
        System.out.println("¿Cuantos numeros deseas?");
        int tam=leer.nextInt();
        String central =String.valueOf(x0);
       // System.out.println(x0);
        
       long r[] = new long[tam]; 
       long r1[] = new long[tam+1]; 
       double x[] = new double[tam];
       double sem[] = new double[tam];
       String cadena[] = new String[tam]; 
       String cadena1[] = new String[tam]; 
       
        for (int i = 0; i < tam; i++) {
            r[i]=x0*x1;
            //System.out.println(r[i]);
            cadena[i] = String.valueOf(r[i]);
           // System.out.println(cadena[i]+"  1");
            if (cadena[i].length()%2 == 0) {
               if(central.length()%2 == 0){
                   int aux;
                aux = cadena[i].length() - central.length();
                aux = aux / 2;
               cadena[i] = cadena[i].substring(aux, cadena[i].length() - aux);
                x[i] = Double.parseDouble(cadena[i]);
                sem[i] = x[i] / Math.pow(10, central.length());
                 System.out.println("r" + (i + 1) + "= " + cadena[i] + "  " + "x" + (i+1) + "= " + sem[i]);
               } else{
                   cadena[i] = "0" + cadena[i];
                  //  System.out.println(cadena[i]);
                int aux;
                aux = cadena[i].length() - central.length();
                aux = aux / 2;
               cadena[i] = cadena[i].substring(aux, cadena[i].length() - aux);
                x[i] = Double.parseDouble(cadena[i]);
                sem[i] = x[i] / Math.pow(10, central.length());
                 System.out.println("r" + (i + 1) + "= " + cadena[i] + "  " + "x" + (i+1) + "= " + sem[i]);
               }
                
            } else{
                if (central.length()%2 == 0) {
                    cadena[i] = "0" + cadena[i];
                  //  System.out.println(cadena[i]);
                int aux;
                aux = cadena[i].length() - central.length();
                aux = aux / 2;
               cadena[i] = cadena[i].substring(aux, cadena[i].length() - aux);
                x[i] = Double.parseDouble(cadena[i]);
                sem[i] = x[i] / Math.pow(10, central.length());
                 System.out.println("r" + (i + 1) + "= " + cadena[i] + "  " + "x" + (i+1) + "= " + sem[i]);
                } else{
                    int aux;
                aux = cadena[i].length() - central.length();
                aux = aux / 2;
               cadena[i] = cadena[i].substring(aux, cadena[i].length() - aux);
                x[i] = Double.parseDouble(cadena[i]);
                sem[i] = x[i] / Math.pow(10, central.length());
                 System.out.println("r" + (i + 1) + "= " + cadena[i] + "  " + "x" + (i+1) + "= " + sem[i]);
                }
                 
            }
            x0=x1;
            x1=(long)x[i];
            
        }
         Arrays.sort(sem);
         for (int i = 0; i < tam; i++) {
             System.out.println(sem[i]);
        }
        
        System.out.println("Desea aplicar la prueba KS");
        int ks=leer.nextInt();
        
        if (ks == 1) {
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
            FS[i] = Math.abs(sem[i] - sr1[i]);
            System.out.println(FS[i]);

        }

        System.out.println("");
        System.out.println("F(Ri)-S´(Ri)");
        for (int i = 0; i < tam; i++) {

            FS1[i] = Math.abs(sem[i] - sr2[i]);
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
