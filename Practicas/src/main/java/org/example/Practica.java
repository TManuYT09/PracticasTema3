package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Practica {
    public void practica1() {
        Scanner entrada = new Scanner(System.in);
        Random random = new Random();
        boolean comp=false;
        int num;
        int temp;
        int numeros1[] = new int[7];
        int numeros2[] = new int[7];
        int bajas1 = 0;
        int bajas2 = 0;
        int aleatorio;

        System.out.println("Equipo 1");
        do {
            num = 0;
            System.out.println("Introduce la potencia de los samurais: ");
            String numt = entrada.nextLine();
            numt=numt.trim();
            String[] numerost = numt.split(" ");
            try {
                for (int i = 0; i < numeros1.length; i++) {
                    temp = Integer.valueOf(numerost[i]);
                    num = num + temp;
                    numeros1[i] = temp;
                }
                comp=false;
            }catch (NumberFormatException err){
                System.out.println("ERROR. Valor no deseado detectado");
                entrada.nextLine();
                comp=true;
            }
            if (num>30){
                System.out.println("ERROR. La potencia total no suma 30.");
                comp=true;
            }else {
                for (int i=0;i<numeros1.length;i++){
                    if (numeros1[i]>24){
                        System.out.println("ERROR. La potencia del "+(i+1)+"º samurai es mayor a 24");
                        comp=true;
                    }
                }
            }
        }while (comp);
        System.out.println("Equipo completado.");

        System.out.println("Equipo 2");
        do {
            num = 0;
            System.out.println("Introduce la potencia de los samurais: ");
            String numt = entrada.nextLine();
            numt=numt.trim();
            String[] numerost = numt.split(" ");

            try {
                for (int i = 0; i < numeros2.length; i++) {
                    temp = Integer.valueOf(numerost[i]);
                    num = num + temp;
                    numeros2[i] = temp;
                }
                comp=false;
            }catch (NumberFormatException err){
                System.out.println("ERROR. Valor no deseado detectado");
                entrada.nextLine();
                comp=true;
            }
            if (num>30){
                System.out.println("ERROR. La potencia total no suma 30.");
                comp=true;
            }else {
                for (int i=0;i<numeros2.length;i++){
                    if (numeros2[i]>24){
                        System.out.println("ERROR. La potencia del "+(i+1)+"º samurai es mayor a 24");
                        comp=true;
                    }
                }
            }
        }while (comp);
        System.out.println("Equipo completado.");

        System.out.println("¡Empieza la batalla!");
        aleatorio= random.nextInt(7);
        System.out.println("La batalla inicia con el Samurai "+(aleatorio+1));
        for (int i=0;i<numeros1.length;i++){
            while (numeros1[aleatorio]==0&&numeros2[aleatorio]==0){
                aleatorio= random.nextInt(7);
            }
            System.out.println("Samurai "+(aleatorio+1)+".");
            if (numeros1[aleatorio]>numeros2[aleatorio]){
                System.out.println("Gana Equipo 1");
                System.out.println(numeros1[aleatorio]+" vs "+numeros2[aleatorio]);
                bajas2++;
            }else {
                System.out.println("Gana Equipo 2");
                System.out.println(numeros1[aleatorio]+" vs "+numeros2[aleatorio]);
                bajas1++;
            }
            numeros1[aleatorio]=0;
            numeros2[aleatorio]=0;
            aleatorio= random.nextInt(7);
        }
        if (bajas1>bajas2){
            System.out.println("¡Equipo 2 GANA! Equipo 1 ha tenido "+bajas1);
        }else {
            System.out.println("¡Equipo 1 GANA! Equipo 2 ha tenido "+bajas2);
        }
    }
}
