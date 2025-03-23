import java.util.Scanner;

public class RectaAreaRettangoloInterattivangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserire la base: ");
        int base = sc.nextInt();
        System.out.println("Inserire l'altezza: ");
        int altezza = sc.nextInt();
        sc.close();
        System.out.println("L'area del rettangolo è: " + areaRettangolo(base, altezza) + "mq");
    }

    public static int areaRettangolo(int base, int altezza) {
        return base * altezza;
    }
}