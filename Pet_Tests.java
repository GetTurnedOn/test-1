import java.io.*;

import junit.framework.TestCase;
import java.io.*;
import java.nio.charset.*;

public class Pet_Tests extends TestCase {
    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    private PrintWriter in;

    protected void setUp() throws IOException{
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

    public void test1() {
        // array of two pointers
        Pet arr[] = new Pet[2];

        arr[0] = new Cat();
        arr[1] = new Dog();

        arr[0].talk();
        arr[1].talk();

        assertEquals("Неправильный ответ:", "Meow!\nWoof!\n", to_normalized_string(out.toByteArray()));
    }
}
