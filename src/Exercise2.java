import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise2 {

    /**
     * Vogliamo sviluppare un programma che simuli un sito di aste online.
     * Ogni oggetto può essere presente in più lotti (ad esempio posso avere
     * 50 pacchetti di carte Magic, 100 penne a sfera, ecc.) e ogni utente
     * può offrire per un numero a scelta di quantità di tali items.
     *
     * Il programma deve chiedere all'utente due importanti informazioni:
     * - Il prezzo che sono disposti a pagare, espresso in euro e centesimi.
     * - La quantità di copie di quel prodotto si vogliano acquistare.
     *
     * Il programma deve validare l'input per entrambe le quantità. per fare ciò
     * seguire i seguenti passi:
     *
     * Price : 1) Chiedere all'utente in input un prezzo, espresso come stringa.
     *         2) La stringa deve contenere:
     *              a) Un numero intero (anche 0) che contenga gli euro
     *              b) Un punto decimale opzionale
     *              c) Un numero intero (anche 0) che contenga i cents.
     *              d) Deve esserci almeno un digit in questo numero. Sono validi
     *                  come input "12.34", "12", ".34", ma non "12,34".
     *          3) Se l'input non è validato, stampare un messaggio di errore.
     *          4) Se l'input è validato, convertirlo in un float.
     *
     * Items: per il numero di item seguire le stesse procedure di price, tranne
     * che stavolta lavoriamo direttamente su degli interi.
     *
     * Se l'utente inserisce un input non valido deve poter ritentare.
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ciao! Inserisci il prezzo che vuoi pagare e la quantità che vuoi acquistare");
        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();
        pubblicaOfferta(input1, input2);
    }

    public static void pubblicaOfferta(String price, String quantity) {
        String regexPrice = "[0-9]*+[.]?[0-9]*";
        if (!price.matches(regexPrice)) {
            throw new InputMismatchException("il prezzo non è valido");
        }
        if (price.charAt(price.length()-1) == '.') {
            price = price.substring(0, price.length()-1);
        }
        String regexQuantity = "[0-9]";
        if (!quantity.matches(regexQuantity)) {
            throw new InputMismatchException("la quantità non è valida!");
        }
        double priceValue = Double.parseDouble(price);
        int quantityValue = Integer.parseInt(quantity);
        System.out.println("Daje è andato tutto a posto!");
    }


}
