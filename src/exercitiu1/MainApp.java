package exercitiu1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        try{
             File file= new File("src\\exercitiu1\\judete_in.txt");
             Scanner scanner= new Scanner(file);
             String[] judete= new String[42];
             int i=0;
             while(scanner.hasNextLine()){
                 judete[i++]=scanner.nextLine();
             }
            System.out.println("lista judetelor: ");
             for(String judet: judete) {
                    if(judet!=null){
                     System.out.println(judet);}
             }
             Arrays.sort(judete,0,i-1);

             Scanner inputScanner= new Scanner(System.in);
             System.out.println("Introduceti judetul cautat: ");
             String judetCautat= inputScanner.nextLine();
             System.out.println("Judetul ales este: " +judetCautat);

            if (judetCautat != null && !judetCautat.isEmpty()) {

                int pozitie = Arrays.binarySearch(judete,0,i-1, judetCautat);
                if (pozitie >= 0) {
                    System.out.println("Județul " + judetCautat + " se află pe poziția " + (pozitie + 1) + " în vectorul ordonat.");
                } else {
                    System.out.println("Județul " + judetCautat + " nu a fost găsit în lista de județe.");
                }
            } else {
                System.out.println("Județul introdus nu este valid.");
            }
             inputScanner.close();

        }catch(FileNotFoundException e){
            System.out.println("Fisierul nu a fost gasit");
            e.printStackTrace();
        }
    }
}
