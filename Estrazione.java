import java.util.Random;

public class Estrazione extends Thread {
    private int matriceNumeri[][];
    private int numeroVincitori;
    private int numero; // prova
    private int vincitori[];

    public Estrazione() {
        matriceNumeri = new int[5][5];
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matriceNumeri[i][j] = random.nextInt(100);
            }
        }
        
    }
    
    public Estrazione(int n) {
        matriceNumeri = new int[n][n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriceNumeri[i][j] = random.nextInt(100);
            }
        }
        
    }
    

    public void stampaMatrice() {
        System.out.println("Scheda Vincente: ");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matriceNumeri[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
    public void stampaVincitori() {
        // Implementazione per stampare i vincitori
    }

    public void verifica(int numero, int idGiocatore) {
       
       
       //fare confronto delle matrici per determinare vincitore

        for (int i = 0; i < matriceNumeri.length; i++) {
            for (int j = 0; j < matriceNumeri[i].length; j++) {
                if (numero == matriceNumeri[i][j]) {
                    System.out.println("Giocatore" + idGiocatore+ " Hai vinto");
                }
            }
        }
       
       /* if (numero == this.numero) {
            System.out.println("Giocatore " + idGiocatore + " hai scelto il numero " + numero + " e hai vinto!");
        } else {
            System.out.println("Hai perso!");
        } */
    }

    public void run() {
        System.out.println("INIZIO ESTRAZIONE!");
        stampaMatrice();
        // Logica di estrazione e stampa finale
    }
}