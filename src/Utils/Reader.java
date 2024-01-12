package Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {
    public String readLine() {
        try{
            String line = (new BufferedReader(
                    new InputStreamReader(System.in))
            ).readLine();

            return (line);
        }
        catch(IOException ex) {
            return "Gibberish input detected";
        }
    }
}