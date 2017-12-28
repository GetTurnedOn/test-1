import junit.framework.TestCase;
import java.io.*;

public class AplusB_Tests extends TestCase{
    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    private PrintWriter in;

    protected void setUp() throws IOException{
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream(pos);
        in = new PrintWriter(pos, true);
        System.setIn(pis);
        System.setOut(new PrintStream(out));
    }

    public void test1(){
        in.println("3 5");

        AplusB.main(new String[0]);

        assertEquals("Неправильный ответ:", "8", out.toString().trim());
    }

    public void test2(){
        in.println("276354094 384570935");

        AplusB.main(new String[0]);

        assertEquals("Неправильный ответ:", "660925029", out.toString().trim());
    }
}
