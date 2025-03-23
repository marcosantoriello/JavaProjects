public class ConcatInitials {
    public static void main(String[] args) {
        System.out.println("Result: " + concatInitials(args[0], args[1], args[2]));
    }

    public static String concatInitials(String str1, String str2, String str3) {
        return new String(
            str1.substring(0, 1)
                .concat(str2.substring(0, 1))
                .concat(str3.substring(0, 1)));
    }
}
