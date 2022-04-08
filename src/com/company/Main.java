package com.company;

import javax.swing.*;
import java.util.*;
import java.time.*;
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


        for(int s = 0;s<wynik.length;s++) {
            for (int j = 0; j < wynik[0].length; j++) {
                System.out.print(wynik[s][j] + "  ");
            }
            System.out.println();
        }





            Rowerek rower1 = new Rowerek();

            Rowerek rower2 = new Rowerek();


            rower1.start();
            rower2.start();


rower2.przyspiesz(50);

rower1.wyswietlStan();

rower2.wyswietlStan();

rower2.stop();
rower1.stop();

rower2.wyswietlStan();









KoszykProduktow koszyk = new KoszykProduktow();

koszyk.dodajProduktDoKoszyka("p1");
koszyk.dodajProduktDoKoszyka("p2");
koszyk.dodajProduktDoKoszyka("p3");
koszyk.pokazZamowienie();








Pomoce.pokazGodzine();

Pomoce.dodajDwieLiczby(2,3);


Punkt p1 = new Punkt(2,3);
Punkt p2 = new Punkt(3,4);
Linia l = new Linia(new Punkt(2,3),new Punkt(3,3));

//bez użycia konstruktora:
        /*
l.poczatek.X=3;
l.poczatek.Y=3;

l.koniec.Y=5;
l.koniec.X=9;
*/

//punkty
        System.out.println("p1.X: ");
        System.out.println(p1.X);
        System.out.println("p1.Y: ");
        System.out.println(p1.Y);

        System.out.println("p2.X: ");
        System.out.println(p2.X);
        System.out.println("p2.Y: ");
        System.out.println(p2.Y);
        //linia
        System.out.println("X z lini koniec: ");
        System.out.println(l.koniec.X);
        System.out.println("Y z lini poczatek: ");
        System.out.println(l.poczatek.Y);
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


///KLASY
class Punkt{

public int X;
public int Y;

   Punkt(int x, int y){
       this.X = x;
       this.Y=y;
   }

     Punkt() {

    }
}

class Linia extends Punkt{

    Punkt poczatek;
    Punkt koniec;
    Linia(Punkt poczatek, Punkt koniec)
    {
        this.poczatek=poczatek;
        this.koniec=koniec;

    }

}







class Pomoce{


    static void pokazGodzine(){
LocalTime ll = LocalTime.now();

        System.out.println( ll.getHour() +":"+ll.getMinute());

    }
    static int dodajDwieLiczby(int a, int b){

        return  a+b;

    }
}


class KoszykProduktow{

    Stack <String> produkty = new Stack<>();

    void dodajProduktDoKoszyka(String s){
        produkty.push(s);
    }
    void pokazZamowienie(){
        System.out.println(produkty);
    }


}




class Rowerek{

    boolean wRuchu;
    int prędkość;


    void start(){


        wRuchu=true;
        prędkość=0;
    }

    void stop(){
        wRuchu=false;
        prędkość=0;
    }

    void przyspiesz(int p){
        wRuchu=true;
        this.prędkość=p;
    }

    void wyswietlStan(){
        System.out.println("Prędkość: " +prędkość);
        System.out.println("Czy rowerek jest w ruchu?" +( wRuchu ? "Tak":"Nie"));
    }
}

