import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rapetti Riccardo
 */
public class Lotteria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Scelta del numero dei numeri da estrarre
        int n = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Inserisci il numero di estrazioni: ");
            n = Integer.parseInt(br.readLine());
        } catch (IOException ex) {
            Logger.getLogger(Lotteria.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore durante la lettura dell'input.");
            return;
        } catch (NumberFormatException ex) {
            System.err.println("Input non valido. Inserisci un numero intero.");
            return;
        }

        // Creazione dell'oggetto Estrazione
        Estrazione e = new Estrazione(n);
        e.stampaMatrice();
        e.start();

        // Creazione e avvio dei thread Giocatore
        Giocatore g1 = new Giocatore(1, e);
        Giocatore g2 = new Giocatore(2, e);
        Giocatore g3 = new Giocatore(3, e);

        g1.start();
        g2.start();
        g3.start();

        // Sincronizzazione con i thread Giocatore
        try {
            g1.join();
            g2.join();
            g3.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Lotteria.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore join.");
        }

        // Comunicazione di fine gioco
        System.out.println("FINE LOTTERIA");
    }
}
