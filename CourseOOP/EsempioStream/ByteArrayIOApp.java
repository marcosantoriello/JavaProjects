import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ByteArrayIOApp {
    public static void main(String[] args) {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        String str = "Questo è un test...";

        for (int i = 0; i < str.length(); i++) {
            outStream.write(str.charAt(i));
        }
        System.out.println("Flusso di output: " + outStream);
        System.out.println("Dimensione: " + outStream.size());

        // come argomento prende il buffer da cui leggere lo stream
        ByteArrayInputStream inStream = new ByteArrayInputStream(outStream.toByteArray());
        // si utilizza available per conoscere quanti caratteri si devono leggere
        int inBytes = inStream.available();
        byte[] inBuf = new byte[inBytes];
        int bytesRead = inStream.read(inBuf, 0, inBytes);
        System.out.println(bytesRead + " bytes letti");
        System.out.println("Sono: " + new String(inBuf));
    }
}
