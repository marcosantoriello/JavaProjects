public class SwapChars {
    public static void main(String[] args) {
        swapFirstLastChars(args[0]);
    }

    /*
     * Funzione che data una stringa di almeno due caratteri ne 
     * costruisce un'altra scambiando il primo e l'ultimo carattere 
     * della stringa di partenza
     */
    public static String swapFirstLastChars(String str) {
        if (str.length() < 2) {
            System.out.println("The string must have at the least 2 characters");
            return null;
        }
        char first = str.charAt(0);
        char last = str.charAt(str.length() - 1);
        String toReturn = new String(last + str.substring(1, str.length()-1) + first);
        System.out.println(toReturn);
        return toReturn;
    }
}
