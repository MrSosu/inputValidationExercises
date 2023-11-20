import java.util.Scanner;

public class Exercise1 {

    /** ESERCIZIO 1
     * 1) Individuare i possibili errori da input validation.
     * 2) Mostrare degli esempi dove l'input potrebbe dare problemi,
     *    descrivendo l'eventuale problema.
     * 3) Cosa accade se passassi in input non numerici o per il numero di nomi
     *    o per il nome da voler ottenere?
     * 4) Riscrivere il programma con una corretta applicazione dell'input validation.
     */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sz = getArraySize(scan);
        String[] names = getNames(scan,sz);

        int which = getWhich(scan);
        String aName = getName(which,names);

        System.out.println("You choose name: "+aName);
    }

    public static int getArraySize(Scanner scan) {
        if (scan == null) {
            throw new NullPointerException("lo scanner è null!");
        }
        System.out.print("How many names? ");
        String next = scan.nextLine();
        int n = 0;
        try {
            n = Integer.parseInt(next);
            while (n <= 0) {
                System.out.println("Devi inserire un numero positivo!");
                n =  scan.nextInt();
            }
        } catch (NumberFormatException e) {
            System.out.println("Errore! Inserisci un numero valido");
            scan.nextLine();
            getArraySize(scan);
        }

        scan.nextLine();
        return n;
    }

    public static String[] getNames(Scanner scan, int sz) {
        if (scan == null) {
            throw new NullPointerException("lo scanner è null!");
        }
        if (sz < 0) {
            throw new IllegalArgumentException("La size deve essere positiva!");
        }
        String[] names = new String[sz];
        for (int i = 0; i < sz; i++ ){
            System.out.print("type name # "+(i+1)+": ");
            names[i] = scan.nextLine();
        }
        return names;
    }

    public static int getWhich(Scanner scan) {
        if (scan == null) {
            throw new NullPointerException("lo scanner è null!");
        }
        System.out.print("Which name: ");
        String next = scan.nextLine();
        int n = 0;
        try {
            n = Integer.parseInt(next);
            while (n <= 0) {
                System.out.println("Devi inserire un numero positivo!");
                n =  scan.nextInt();
            }
        } catch (NumberFormatException e) {
            System.out.println("Errore! Inserisci un numero valido");
            scan.nextLine();
            getWhich(scan);
        }
        return n;
    }

    public static String getName(int n,String[] vals) {
        if (n < 1) {
            throw new IllegalArgumentException("n è negativo!");
        }
        if (vals.length == 0) {
            throw new IllegalArgumentException("l'array è vuoto!");
        }
        return vals[n-1];
    }

}
