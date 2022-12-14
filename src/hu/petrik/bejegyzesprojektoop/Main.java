package hu.petrik.bejegyzesprojektoop;

import java.io.*;
import java.util.*;

import static java.lang.System.*;

public class Main {
    public static List<Bejegyzes> bejegyzesek = new ArrayList<>();
    public static void main(String[] args) {
        kettoa();
        kettob();
        bekeres();
        kettod();
        //out.println(bejegyzesek);
        kettoe();
        out.println(bejegyzesek);
        haroma();
        haromb();
        haromc();
        haromd();
    }

    //BEOLVASÁS --------------------------------------------------------------------

    public static void bekeres() {
        String fajlNev = "bejegyzesek.csv";
        try {
            beolvas(fajlNev);
        } catch (FileNotFoundException e) {
            err.printf("Hiba miatt nem található az %s fájl\n", fajlNev);
        } catch (IOException e) {
            err.println("Ismeretlen hiba történt a fájl beolvasása során");
        }
    }

    public static void beolvas(String fajlNev) throws IOException {
        FileReader fr = new FileReader(fajlNev);
        BufferedReader br = new BufferedReader(fr);
        String sor = br.readLine();
        while (sor != null && !sor.equals("")) {
            String[] tomb = sor.split(";");
            Bejegyzes bejegyzes = new Bejegyzes(tomb[0], tomb[1]);
            bejegyzesek.add(bejegyzes);
            sor = br.readLine();
        }
        br.close();
        fr.close();
    }

    //MÁSODIK FELADAT -------------------------------------------------------

    public static void kettoa(){
        bejegyzesek.add(new Bejegyzes("Ágozsga", "VisualStudioban javazni"));
        bejegyzesek.add(new Bejegyzes("ZsomBruh", "Profi programozás kulcsa"));
    }

    public static void kettob(){
        Scanner sc = new Scanner(in);
        out.print("Hány új elemet szeretne hozzáadni a listához?\nVálasz: ");
        try{
            int darabszam = sc.nextInt();
            for (int i = 0; i < darabszam; i++) {
                out.print("Szerző neve: ");
                String szerzo = sc.next();
                out.print("Tartalom: ");
                String tartalom = sc.next();
                bejegyzesek.add(new Bejegyzes(szerzo,tartalom));
            }
        }catch (InputMismatchException e){
            out.println("Hiba! Nem egész számot adott meg!");
        }
    }

    public static void kettod(){
        Random r = new Random();
        for (int i = 0; i < bejegyzesek.size()*20; i++) {
            bejegyzesek.get(r.nextInt(bejegyzesek.size())).like();
        }

    }

    public static void kettoe(){
        Scanner sc = new Scanner(in);
        out.print("Adjon meg egy szöveget: ");
        bejegyzesek.get(1).setTartalom(sc.next());
    }

    public static void haroma(){
        int legnagyobb = 0;
        int index = 0;
        for (int i = 0; i < bejegyzesek.size(); i++) {
            if (bejegyzesek.get(i).getLikeok() > legnagyobb){
                legnagyobb = bejegyzesek.get(i).getLikeok();
                index = i;
            }
        }
        out.print("\nLegnépszerűbb bejegyzés like száma:");
        out.println(bejegyzesek.get(index).getLikeok());
    }

    public static void haromb(){
        boolean vane = false;
        for (int i = 0; i < bejegyzesek.size(); i++) {
            if (bejegyzesek.get(i).getLikeok() > 35){
                vane = true;
                break;
            }
        }

        if (vane){
            out.println("\nAz egyik bejegyzés 35 lájknál többet kapott!");
        }else {
            out.println("\nEgyik bejegyzés sem kapott 35 lájknál többet!");
        }
    }

    public static void haromc(){
        boolean vane = false;
        int szamlalo = 0;
        for (int i = 0; i < bejegyzesek.size(); i++) {
            if (bejegyzesek.get(i).getLikeok() < 15){
                szamlalo++;
            }
        }
        out.println(szamlalo + " darab 15-nél kevesebb likeot kapott bejegyzés van.");
    }

    public static void haromd(){
        bejegyzesek.sort((x, y) -> (x.getLikeok() > y.getLikeok()) ? -1 : 1);
        try {
            FileWriter fw = new FileWriter("bejegyzesek_rendezett.txt");
            for (int i = 0; i < bejegyzesek.size(); i++) {
                fw.write(bejegyzesek.get(i).toString());
            }
            fw.close();
        } catch (IOException e){

        }

    }
}
