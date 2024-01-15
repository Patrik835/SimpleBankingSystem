package Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {
    public String readLine() {
        try {
            return ((new BufferedReader(
                    new InputStreamReader(System.in))
            ).readLine());
        } catch (IOException ex) {
            return "Gibberish input detected";
        }
    }
}