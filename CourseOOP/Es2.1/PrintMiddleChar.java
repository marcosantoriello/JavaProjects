class PrintMiddleChar {
    public static void main(String[] args) {
        System.out.println("Middle char is: " + findMiddleChar(args[0]));
    }

    public static char findMiddleChar(String s) {
        return s.charAt(s.length() / 2 - 1);
    }
}