package org.example;

import java.util.Arrays;
import java.util.InputMismatchException;
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
    public void practica2() {
        Scanner entrada=new Scanner(System.in);
        Random random=new Random();
        boolean comp=true;
        int boleto[]=new int[7];
        do {
            comp=true;
            System.out.println("Introduce los datos de tu boleto:");
            String numeros=entrada.nextLine();
            numeros=numeros.trim();
            comp=numeros.matches("\\d{1,2}-\\d{1,2}-\\d{1,2}-\\d{1,2}-\\d{1,2}-\\d{1,2}/\\d");
            if (!comp){
                System.out.println("ERROR. El formato del boleto no es correcto.");
            }else {
                String boletot[]=numeros.split("[-/]");
                for (int i=0;i<boleto.length;i++){
                    boleto[i]= Integer.parseInt(boletot[i]);
                    if (boleto[i]<=0||boleto[i]>49){
                        comp=false;
                        System.out.println("ERROR. Boleto no válido");
                        break;
                    }else if (i==6){
                        if (boleto[i]<=0||boleto[i]>9){
                            System.out.println("ERROR. Boleto no válido");
                            comp=false;
                        }
                    }
                }
            }
        }while (!comp);
        System.out.println(Arrays.toString(boleto));
        int boleto_real[]=new int[6];
        for (int i=0;i< boleto_real.length;i++){
            boleto_real[i]=boleto[i];
        }
        int reintegro_real=boleto[6];
        int boleto_ganador[]=new int[6];
        System.out.println("Ha salido:");
        do {
            comp=true;
            for (int i=0;i<boleto_ganador.length;i++){
                boleto_ganador[i]=random.nextInt(1,49);
            }
            Arrays.sort(boleto_ganador);
            for (int i=0;i<boleto_ganador.length-1;i++){
                if (boleto_ganador[i]==boleto_ganador[i+1]){
                    comp=false;
                    break;
                }
            }
        }while (!comp);
        System.out.println(Arrays.toString(boleto_ganador));
        int complementario=0;
//        do {
//            comp=true;
//            complementario=random.nextInt(1,49);
//            if (Arrays.asList(boleto_ganador).contains(complementario)){
//                comp=false;
//            }
//        }while(!comp);
        System.out.println("Complementario: "+complementario);
        int reintegro=random.nextInt(0,9);
        System.out.println("Reintegro: "+reintegro);
        System.out.println(" ");
        System.out.println("RESULTADOS:");
        int aciertos=0;

        for (int i=0;i<boleto_ganador.length;i++){
            for (int j=0;j<boleto_real.length;j++){
                if (boleto_ganador[i]==boleto_real[j]){
                    aciertos++;
                }
            }
        }
        if (aciertos==1){
            System.out.println(aciertos+" acierto.");
        }else {
            System.out.println(aciertos+" aciertos.");
        }
        switch (aciertos){
            case 3:System.out.println("5ª Categoría");break;
            case 4:System.out.println("4ª Categoría");break;
            case 5:
//                if (Arrays.asList(boleto).contains(complementario)){
//                    System.out.println("2ª Categoría");
//                }else {
//                    System.out.println("3ª Categoría");
//                }
                break;
            case 6:
                if (reintegro==boleto[6]){
                    System.out.println("1ª Categoría");
                }
                break;
            default:System.out.println("No premiado");break;
        }
        if (reintegro==reintegro_real){
            System.out.println("Reintegro.");
        }
    }
    public void practica3(){
        Scanner entrada=new Scanner(System.in);
        int filas=0;
        int columnas=0;
        boolean comp=false;
        do {
            try {
                System.out.println("Introduce el número de filas:");
                filas=entrada.nextInt();
                comp=false;
            }catch (InputMismatchException err){
                System.out.println("ERROR. Valor introducido no valio");
                entrada.nextLine();
                comp=true;
            }
        }while (comp);

        do {
            try {
                System.out.println("Introduce el número de columnas:");
                columnas=entrada.nextInt();
                comp=false;
            }catch (InputMismatchException err){
                System.out.println("ERROR. Valor introducido no valio");
                entrada.nextLine();
                comp=true;
            }
        }while (comp);

        String matriz[][]= new String[filas][columnas];
        String letras;
        int numi=0;
        int numj=0;

        for (int i = 0; i < matriz.length; i++) {
            System.out.println("Introduce las letras de la fila "+(i+1));
            letras=entrada.next();
            if (letras.matches("[a-zA-Z]+")){
                String vector[]=letras.split("");
                for (int j = 0; j < matriz[0].length; j++) {
                    matriz[i][j]=vector[j];
                }
            }else {
                System.out.println("ERROR. Introduce datos válidos: "+columnas+" letras.");
                comp=true;
                break;
            }
        }
        if (!comp){
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    System.out.print(matriz[i][j]+" ");
                }
                System.out.print("\n");
            }
            do {
                System.out.println("Introduce la palabra a buscar:");
                do {
                    letras=entrada.next();
                    if (letras.matches("[a-zA-Z]+")){
                        comp=false;
                    }else {
                        System.out.println("ERROR. Formato no valido");
                        comp=true;
                    }
                }while(comp);

                i:
                for (int i = numi; i < matriz.length; i++) {
                    j:
                    for (int j = numj; j < matriz[i].length; j++) {
                        if (matriz[i][j].equals(letras.substring(0,1))){
                            numi=i;
                            numj=j;
                            break i;
                        }
                    }
                }

                for (int i=0;i<letras.length();i++){
                    if (matriz[numi][i].equals(letras.substring(i,i+1))){
                        comp=false;
                        continue;
                    }else {
                        comp=true;
                        break;
                    }
                }

                if (comp){
                    for (int i=0;i<letras.length();i++){
                        if (matriz[i][numj].equals(letras.substring(i,i+1))){
                            comp=false;
                            continue;
                        }else {
                            comp=true;
                            break;
                        }
                    }
                }
            }while (comp);
            System.out.println("Encontrada!!! En la posición "+numi+" "+numj);
        }
    }
}
