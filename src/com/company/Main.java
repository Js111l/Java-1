package com.company;

import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /// silnia

        System.out.println(Silnia.silnia(6));

        //liczba parzysta/nieparzysta

        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadź cyfrę: ");
        int i = scanner.nextInt();

        if(i%2==1){
            System.out.println("Liczba nieparzysta");
        }
        else if(i%2==0)
        {
            System.out.println("Liczba parzysta");
        }

        /// mnożenie macierzy




        Scanner sc = new Scanner(System.in);

        System.out.println("Wprowadź liczbę wierszy: ");
        int wiersze = sc.nextInt();
        System.out.println("Wprowadź liczbę kolumn" +
                ": ");
         int kolumny = sc.nextInt();


        int[][] macierza = new int[wiersze][kolumny];
        int[][] macierzb = new int[kolumny][wiersze];

        if(macierza[0].length!=macierzb.length){
            System.out.println("Mnożenie niemożliwe!");
        }


        for(int b = 0; b<macierza.length;b++) {
            for (int j =0;j<macierza[0].length;j++){
                System.out.println("Wprowadź parametry: ");
                System.out.printf("A: %d %d", b,j);

                 macierza[b][j]=sc.nextInt();
                System.out.println(macierza[b][j]);
            }
        }

        for(int n = 0; n<macierzb.length;n++) {
            for (int j =0;j<macierzb[0].length;j++){
                System.out.println("Wprowadź parametry: ");
                System.out.printf("B: %d %d", n,j);
                macierzb[n][j]=sc.nextInt();

            }
        }


   MnozenieMacierz mnoze = new MnozenieMacierz();


        System.out.println("Wynik mnożenia macierzy A i B: ");
int [] [] wynik = mnoze.mnozenieMacierz(macierza,macierzb);


        for(int s = 0;s<wynik.length;s++){
            for(int j =0;j<wynik[0].length;j++){
                System.out.print(wynik[s][j]+ "  ");
            }
            System.out.println();



        }
            }



class Silnia{


   static int silnia(int x){

       if(x==1){
           return x;
       }
        return x* silnia(x-1);
    }
}


static class MnozenieMacierz{

  int[][]  mnozenieMacierz(int [][] macierza,int [][] macierzb) {
      int[][] wynik = new int[macierza.length][macierzb[0].length];


      for (int m = 0; m < macierza.length; m++) { ///liczba wierszy macierzy 1
          for (int j = 0; j < macierzb[0].length; j++) { ///liczba kolumn 2 macierzy
              for (int k = 0; k < macierza[0].length; k++) {  ///liczba kolumn macierzy 1
                  wynik[m][j] += macierza[m][k] * macierzb[k][j];
              }
          }
      }

  return wynik;

      }}}









