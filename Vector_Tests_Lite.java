import junit.framework.TestCase;

import java.io.*;
import java.nio.charset.*;

public class Vector_Tests_Lite extends TestCase {
    
    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    protected void setUp(){
        System.setOut(new PrintStream(out));
    }

    public void test1(){
        Vector v = new Vector();
        v.insert(5.0, 0);
        v.insert(0.0, 1);
        v.insert(3.0, 0);
        v.print();

        assertEquals("Неправильный результат!", "3.0 5.0 0.0", out.toString().trim());
    }

    public void test2(){
        Vector v = new Vector();
        for(int i=0; i<11; i++)
            v.insert(i+1, i);
        v.print();

        assertEquals("Неправильный результат!", "1.0 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0 10.0 11.0", out.toString().trim());
    }

    public void test3(){
        Vector v = new Vector();

        boolean ae_ok = false;
        try{
            v.insert(2.0, 0);
            v.insert(3.0, 2);
        }catch(AssertionError ae){
            ae_ok = true;
        }
        assertTrue("Корректность номера вставляемого элемента должна проверяться assert'ом!", ae_ok);

        v.print();
        assertEquals("Неправильный результат!", "2.0", out.toString().trim());
    }

}
