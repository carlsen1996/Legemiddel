import java.util.*;
import java.io.*;

public class Legesystem{
    private static Lenkeliste<Pasient> pasienter = new Lenkeliste<Pasient>();
    private static SortertLenkeliste<Lege> leger = new SortertLenkeliste<Lege>();
    private static Lenkeliste<Legemiddel> preparater = new Lenkeliste<Legemiddel>();
    private static Lenkeliste<Resept> resepter = new Lenkeliste<Resept>();
    private static Lenkeliste<Legemiddel> vanedannende = new Lenkeliste<Legemiddel>();
    private static int antVanedannende = 0;
    private static Lenkeliste<Legemiddel> narkotiske = new Lenkeliste<Legemiddel>();
    private static int antNarkotiske = 0;
    private static Lenkeliste<Resept> narkotiskResept = new Lenkeliste<Resept>();








    public static void main(String[] args){
      File fil = new File("fil.txt");
      lesFraFil(fil);

      String stopp = "\n1: Skriv ut alle elementer \n2: Legg til \n3: Bruk resept \n4: Undermeny";
      Scanner s = new Scanner(System.in);
      System.out.println(stopp);
      int input = s.nextInt();

      //skriv ut alt
      while (input != 0) {
        if (input == 1) {
          System.out.println("Pasienter: ");
          for (Pasient e : pasienter) {
            System.out.println(e);
          }
          System.out.println("\nLeger: ");
          for (Lege e : leger) {
            System.out.println(e);
          }
          System.out.println("\nLegemidler: ");
          for (Legemiddel e : preparater) {
            System.out.println(e);
          }
          System.out.println("\nResepter: ");
          for (Resept e : resepter) {
            System.out.println(e);
          }
          System.out.println(stopp);
        }
        //legg til
        if (input == 2) {
          System.out.println("1: Legg til lege \n2: Legg til pasient \n3: Legg til Legemiddel \n4: Legg til resept \n5: Gaa tilbake");
          Scanner l = new Scanner(System.in);
          int leggTil = l.nextInt();
          while (leggTil != 5) {
            //legg til lege eller spesialist
            if (leggTil == 1) {
              Scanner n = new Scanner(System.in);
              System.out.println("Navn: ");
              String navn = n.nextLine();
              System.out.println("Kontroll Id: (hvis ikke spesialist skriv 0)");
              int id = n.nextInt();
              if (id == 0) {
                Lege lege = new Lege(navn);
                leger.leggTil(lege);
              }
              else {
                Spesialist spesialist = new Spesialist(navn, id);
                leger.leggTil(spesialist);
              }
              System.out.println("Vil du legge til en til? \n1: Ja \n2: Nei");
              int avslutt = n.nextInt();
              if (avslutt == 2) {
                leggTil = 5;
              }
            }
            //legg til pasient
            else if (leggTil == 2) {
              Scanner p = new Scanner(System.in);
              System.out.println("Navn: ");
              String navn = p.nextLine();
              System.out.println("Fodselsnummer: ");
              String fn = p.nextLine();
              Pasient pasient = new Pasient(navn, fn);
              pasienter.leggTil(pasient);
              System.out.println("Vil du legge til en til? \n1: Ja \n2: Nei");
              int avslutt = p.nextInt();
              if (avslutt == 2) {
                leggTil = 5;
              }
            }
            //legg til legemiddel
            else if (leggTil == 3) {
              Scanner lm = new Scanner(System.in);
              System.out.println("Navn: ");
              String navn = lm.nextLine();
              System.out.println("Pris: ");
              Double pris = lm.nextDouble();
              System.out.println("Virkestoff: ");
              Double vs = lm.nextDouble();
              System.out.println("Type preparat: \n1: Narkotisk \n2: Vanedannende \n3: Vanlig");
              int prep = lm.nextInt();
              if (prep == 1) {
                System.out.println("Styrke: ");
                int styrke = lm.nextInt();
                PreparatA prepA = new PreparatA(navn, pris, vs, styrke);
                preparater.leggTil(prepA);
                narkotiske.leggTil(prepA);
              }
              else if (prep == 2) {
                System.out.println("Styrke: ");
                int styrke = lm.nextInt();
                PreparatB prepB = new PreparatB(navn, pris, vs, styrke);
                preparater.leggTil(prepB);
                vanedannende.leggTil(prepB);
              }
              else if (prep == 3) {
                PreparatC prepC = new PreparatC(navn, pris, vs);
                preparater.leggTil(prepC);
              }
              else {
                System.out.println("Du skrev noe annet enn a, b eller c på type preparat, prøv igjen");
                leggTil = 0;
              }
              System.out.println("Vil du legge til en til? \n1: Ja \n2: Nei");
              int avslutt = lm.nextInt();
              if (avslutt == 2) {
                leggTil = 5;
              }
            }
            //lag resept
            else if (leggTil == 4) {
              Scanner rs = new Scanner(System.in);
              System.out.println("Hvilket legemiddel vil du skrive ut? (tast inn siffer fra 0 og oppover fra toppen og ned)");
              for (Legemiddel e : preparater) {
                System.out.println(e.hentNavn());
              }
              int lm = rs.nextInt();

              System.out.println("Hvilken lege skriver ut? (tast inn siffer fra 0 og oppover fra toppen og ned)");
              for (Lege e : leger) {
                System.out.println(e);
              }
              int le = rs.nextInt();

              System.out.println("Hvem skriver du resepten ut til? (tast inn siffer fra 0 og oppover fra toppen og ned)");
              for (Pasient e : pasienter) {
                System.out.println(e);
              }
              int pas = rs.nextInt();

              System.out.println("Hvor mange ganger skal pasienten kunne ta ut resepten?");
              int reit = rs.nextInt();

              System.out.println("Er dette: \n1: Hvit resept \n2: Blaa resept \n3: P resept \n4: Militaer resept");
              int tres = rs.nextInt();

              Legemiddel legemiddel = preparater.hent(lm);
              for (Legemiddel e : vanedannende) {
                if (e.hentNavn().equals(legemiddel.hentNavn())) {
                  antVanedannende++;
                }
              }
              Lege lege = leger.hent(le);
              Pasient pasient = pasienter.hent(pas);
              //hvit resept
              if (tres == 1) {
                HvitResept hvit = new HvitResept(legemiddel, lege, pasient, reit);
                for (Legemiddel e : narkotiske) {
                  if (e.hentNavn().equals(legemiddel.hentNavn())) {
                    antNarkotiske++;
                    narkotiskResept.leggTil(hvit);
                    lege.narkAnt++;
                    pasient.narkAntPas++;
                  }
                }
                lege.skrivHvitResept(legemiddel, pasient, reit);
                resepter.leggTil(hvit);
              }
              //blaa resept
              else if (tres == 2) {
                try {
                  BlaaResept blaa = new BlaaResept(legemiddel, lege, pasient, reit);
                  for (Legemiddel e : narkotiske) {
                    if (e.hentNavn().equals(legemiddel.hentNavn())) {
                      antNarkotiske++;
                      narkotiskResept.leggTil(blaa);
                      lege.narkAnt++;
                      pasient.narkAntPas++;
                    }
                  }
                  lege.skrivBlaaResept(legemiddel, pasient, reit);
                  resepter.leggTil(blaa);
                }
                catch (Exception e){
                  System.out.println(e);
                }
              }
              //p resept
              else if (tres == 3) {
                PResept p = new PResept(legemiddel, lege, pasient, reit);
                for (Legemiddel e : narkotiske) {
                  if (e.hentNavn().equals(legemiddel.hentNavn())) {
                    antNarkotiske++;
                    narkotiskResept.leggTil(p);
                    lege.narkAnt++;
                    pasient.narkAntPas++;
                  }
                }
                lege.skrivPResept(legemiddel, pasient, reit);
                resepter.leggTil(p);
              }
              militaerresept
              else if (tres == 4) {
                Militaerresept milit = new Militaerresept(legemiddel, lege, pasient, reit);
                for (Legemiddel e : narkotiske) {
                  if (e.hentNavn().equals(legemiddel.hentNavn())) {
                    antNarkotiske++;
                    narkotiskResept.leggTil(milit);
                    lege.narkAnt++;
                    pasient.narkAntPas++;
                  }
                }
                lege.skrivMilitaerresept(legemiddel, pasient, reit);
                resepter.leggTil(milit);
              }
              System.out.println("Vil du legge til en til? \n1: Ja \n2: Nei");
              int avslutt = rs.nextInt();
              if (avslutt == 2) {
                leggTil = 5;

              }
            }
          }
          System.out.println(stopp);
        }
        //Bruk resept
        if (input == 3) {
          Scanner bruk = new Scanner(System.in);
          System.out.println("Hvilken pasient vil du se resepter for?");
          for (Pasient e : pasienter) {
            System.out.println(e);
          }
          int pas = bruk.nextInt();
          Pasient pasient = pasienter.hent(pas);
          Resept res = null;
          System.out.println("Hvilken resept vil du bruke?");
          for (Resept e : pasient.hentResepter()) {
            System.out.println(e);
            res = e;
          }
          int inpres = bruk.nextInt();
          Resept resept = pasient.hentResepter().hent(inpres);
          if (resept.bruk() == true) {
            System.out.println("Brukte resepten, du har " + res.hentReit() + " igjen");
          }
          else {
            System.out.println("Du har brukt opp denne resepten og kan da ikke hente ut flere");
          }
          System.out.println(stopp);
        }
        //statistikk
        if (input == 4) {
          Scanner under = new Scanner(System.in);
          System.out.println("\n1: Skriv ut totalt antall utskrevne vanedannende resepter \n2: Skriv ut totalt antall utskrevne narkotiske resepter \n3: Statistikk paa narkotiske legemidler");
          int meny = under.nextInt();
          if (meny == 1) {
            System.out.println(antVanedannende);
          }
          if (meny == 2) {
            System.out.println(antNarkotiske);
          }
          if (meny == 3) {
            System.out.println("\nHvor mange resepter med narkotiske stoffer har legene skrevet ut: ");
            for (Lege e : leger) {
              System.out.println(e.hentNavn() + ": " + e.narkAnt);
            }
            System.out.println("\nHvor mange resepter med narkotiske stoffer har pasientene faatt skrevet ut: ");
            for (Pasient e : pasienter) {
              System.out.println(e.hentNavn() + ": " + e.narkAntPas);
            }
          }
          System.out.println(stopp);
        }
        input = s.nextInt();
      }
    }
    //les inn fra fil
    private static void lesFraFil(File fil){
        Scanner scanner = null;
        try{
            scanner = new Scanner(fil);
        }catch(FileNotFoundException e){
            System.out.println("Fant ikke filen, starter opp som et tomt Legesystem");
            return;
        }
        String innlest = scanner.nextLine();
        while(scanner.hasNextLine()){

            String[] info = innlest.split(" ");
            //pasienter
            if(info[1].compareTo("Pasienter") == 0){
                while(scanner.hasNextLine()) {
                    innlest = scanner.nextLine();
                    if(innlest.charAt(0) == '#'){
                        break;
                    }
                    String[] pasInfo = innlest.split(", ");
                    String navn = pasInfo[0];
                    String fn = pasInfo[1];
                    Pasient pas = new Pasient(navn, fn);
                    pasienter.leggTil(pas);
                }
            }
            //legemidler
            else if(info[1].compareTo("Legemidler") == 0){
                while(scanner.hasNextLine()){
                    innlest = scanner.nextLine();
                    if(innlest.charAt(0) == '#'){
                        break;
                    }
                    String[] legInfo = innlest.split(", ");
                    String navn = legInfo[0];
                    String prep = legInfo[1];
                    double pris = Double.parseDouble(legInfo[2]);
                    double virk = Double.parseDouble(legInfo[3]);

                    String[] legemiddel = innlest.split(", ");

                    if(legemiddel[1].compareTo("a") == 0){
                        int styrke = Integer.parseInt(legInfo[4]);
                        PreparatA prepA = new PreparatA(navn, pris, virk, styrke);
                        preparater.leggTil(prepA);
                        narkotiske.leggTil(prepA);
                    }
                    else if(legemiddel[1].compareTo("b") == 0){
                        int styrke = Integer.parseInt(legInfo[4]);
                        PreparatB prepB = new PreparatB(navn, pris, virk, styrke);
                        preparater.leggTil(prepB);
                        vanedannende.leggTil(prepB);
                    }
                    else if (legemiddel[1].compareTo("c") == 0){
                        PreparatC prepC = new PreparatC(navn, pris, virk);
                        preparater.leggTil(prepC);
                    }

                }
            }
            //Leger
            else if(info[1].compareTo("Leger") == 0){
                while(scanner.hasNextLine()){
                    innlest = scanner.nextLine();
                    if(innlest.charAt(0) == '#'){
                        break;
                    }
                    info = innlest.split(", ");
                    String navn = info[0];
                    int kontrollid = Integer.parseInt(info[1]);

                    if(kontrollid == 0){
                        Lege lege = new Lege(navn);
                        leger.leggTil(lege);
                    }
                    else{
                        Spesialist spesialist = new Spesialist(navn, kontrollid);
                        leger.leggTil(spesialist);
                    }
                }
            }
            //resepter
            else if(info[1].compareTo("Resepter") == 0){
                while(scanner.hasNextLine()){
                    innlest = scanner.nextLine();
                    info = innlest.split(", ");

                    int lmnr = Integer.parseInt(info[0]);
                    String lege = info[1];
                    int pasId = Integer.parseInt(info[2]);
                    int reit = Integer.parseInt(info[3]);

                    Legemiddel legemiddel = preparater.hent(lmnr);
                    for (Legemiddel e : vanedannende) {
                      if (e.hentNavn().equals(legemiddel.hentNavn())) {
                        antVanedannende++;
                      }
                    }
                    Lege navnLege = null;
                    Pasient id = null;

                    for (Lege e : leger) {
                      if (e.hentNavn().equals(lege)) {
                        navnLege = e;
                      }
                    }
                    for (Pasient e : pasienter) {
                      if (e.hentId() == pasId) {
                        id = e;
                      }
                    }
                    navnLege.skrivHvitResept(legemiddel, id, reit);
                    HvitResept hvit = new HvitResept(legemiddel, navnLege, id, reit);
                    resepter.leggTil(hvit);
                    for (Legemiddel e : narkotiske) {
                      if (e.hentNavn().equals(legemiddel.hentNavn())) {
                        antNarkotiske++;
                        narkotiskResept.leggTil(hvit);
                        navnLege.narkAnt++;
                        id.narkAntPas++;
                      }
                    }
                }
            }
        }
    }
}
