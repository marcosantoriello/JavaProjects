import java.util.Scanner;

public class FahrenheitToCelsius {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserire la temperatura in Fahrenheit: ");
        float inputTemp = sc.nextFloat();
        float celsiusTemp = fahrenheitToCelsius(inputTemp);
        System.out.println("Temperature: " + celsiusTemp + "°C");
    }

    private static float fahrenheitToCelsius(float fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
}
