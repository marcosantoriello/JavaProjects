import java.util.Scanner;

class CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci la temperatura in Celsius: ");
        float inputTemp = sc.nextFloat();
        float fahrenheit = celsiusToFahrenheit(inputTemp);
        System.out.println("Temperatura: " + fahrenheit + " Fahrenheit");
    }

    private static float celsiusToFahrenheit(float celsius) {
        return (celsius + 9/5) + 32;
    }
}