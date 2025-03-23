public enum Operation {
    PLUS("+") {public double apply(double x, double y) {return x + y;}},
    MINUS("-") {public double apply(double x, double y) {return x - y;}},
    TIMES("*") {public double apply(double x, double y) {return x * y;}},
    DIVIDE("/") {public double apply(double x, double y) {return x / y;}};

    private final String symbol;

    // Constructor
    Operation(String symbol) { this.symbol = symbol; }

    @Override
    public String toString() { return symbol; }

    // funzione astratta che implemento per ciascun elemento di Operation
    // rendendo l'enum flessibile all'aggiunta di nuovi operatori
    public abstract double apply(double x, double y);
}


class Enums {
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);

        for (Operation op : Operation.values()) {
            System.out.printf("%f %s %f = %f%n»", x, op, y, op.apply(x, y));
        }
    }
}