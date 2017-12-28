import junit.framework.TestCase;
import java.io.*;
import java.util.*;
import java.nio.charset.*;

public class Runners_Tests extends TestCase{
    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    private PrintWriter in;

    protected void setUp() throws IOException{
        // format uses Locale.getDefault(), Scanner uses Locale.getDefault(Locale.Category.FORMAT) %)
        Locale.setDefault(Locale.getDefault(Locale.Category.FORMAT));

        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream(pos);
        in = new PrintWriter(pos, true);
        System.setIn(pis);
        System.setOut(new PrintStream(out));
    }

    protected String to_normalized_string(byte[] arr){
        int j = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] != 13)
                arr[j++] = arr[i];
        }// for
        return new String(arr, 0, j, Charset.defaultCharset());
    }

    public void test1(){
        in.println(3);
        in.printf("Horstmann %.1f%n", 9.4);
        in.printf("Schildt %.1f%n", 10.1);
        in.printf("Eckel %.1f%n", 12.0);

        Runners.main(new String[0]);

        assertEquals("Неправильный ответ:", "1 Horstmann 9.4\n2 Schildt 10.1\n3 Eckel 12.0\n", to_normalized_string(out.toByteArray()));
    }

    public void test2(){
        in.println(3);
        in.printf("Eckel %.1f%n", 12.1);
        in.printf("Eckel %.1f%n", 12.1);
        in.printf("Horstmann %.1f%n", 9.5);
        in.printf("Schildt %.1f%n", 10.2);

        Runners.main(new String[0]);

        assertEquals("Неправильный ответ:", "1 Horstmann 9.5\n2 Schildt 10.2\n3 Eckel 12.1\n", to_normalized_string(out.toByteArray()));
    }

    public void test3(){
        in.println(11);
        in.printf("Ivanov %.1f%n", 12.6);
        in.printf("Petrov %.1f%n", 11.1);
        in.printf("Sidorov %.1f%n", 13.0);
        in.printf("Smith %.1f%n", 9.5);
        in.printf("Doe %.1f%n", 10.2);
        in.printf("Salo %.1f%n", 14.3);
        in.printf("Nagasaki %.1f%n", 18.2);
        in.printf("Booch %.1f%n", 11.6);
        in.printf("Knuth %.1f%n", 9.8);
        in.printf("Pylypets %.1f%n", 10.0);
        in.printf("Neumann %.1f%n", 14.0);

        Runners.main(new String[0]);

        assertEquals("Неправильный ответ:", "1 Smith 9.5\n2 Knuth 9.8\n3 Pylypets 10.0\n", to_normalized_string(out.toByteArray()));
    }
}
