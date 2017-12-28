import junit.framework.TestCase;

import java.io.*;
import java.nio.charset.*;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class Stakan_Tests extends TestCase {

    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    protected void setUp(){
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
        Stakan s = new Stakan();
        assertTrue("Конструктор по умолчанию должен создавать стакан в 30г, 200мл!", s.getMass()==30.0 && s.getVolume()==200.0);
    }

    public void test2(){
        Stakan s = new Stakan(10, 100);
        assertTrue("Должен был получиться стакан в 10г, 100мл!", s.getMass()==10.0 && s.getVolume()==100.0);

        s.setMass(20);
        s.setVolume(150);
        assertTrue("Должен был получиться стакан в 20г, 150мл!", s.getMass()==20.0 && s.getVolume()==150.0);
    }

    public void test3(){
        Stakan s = new Stakan(20, 150);
        s.print();
        assertEquals("Должен был получиться стакан в 20г, 150мл, пустой!", "Mass: 20.0 g, Volume: 150.0 ml, Content: 0.0 ml\n", to_normalized_string(out.toByteArray()));
        out.reset();

        s.setContent(100);
        s.print();
        assertEquals("Должен был получиться стакан в 20г, 150мл, 100мл внутри!", "Mass: 20.0 g, Volume: 150.0 ml, Content: 100.0 ml\n", to_normalized_string(out.toByteArray()));
        out.reset();

        assertEquals("Где 100 грамм?", 100.0f, s.getContent());
    }

    public void test4(){
        Stakan s = new Stakan(0, 0);
        assertTrue("Должен был получиться стакан в 30г, 200мл!", s.getMass()==30.0 && s.getVolume()==200.0);

        assertFalse("Объем 0 не бывает!", s.setVolume(0));  // error
        assertFalse("Масса 0 не бывает!", s.setMass(0));    // error

        assertFalse("250мл в 200мл не должно вмещаться!", s.setContent(250));  // error

    }
}
