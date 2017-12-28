import junit.framework.TestCase;

import java.io.*;
import java.nio.charset.*;

public class Point_Tests extends TestCase {
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

    public void test1() {
        Point p1 = new Point(2, 3);
        p1.print();

        assertEquals("Неправильный вывод!", "Point()\n(2.0, 3.0)\n", to_normalized_string(out.toByteArray()));
    }

    public void test2(){
        Point3d p2 = new Point3d(4, 5, 6);
        p2.print();

        assertEquals("Неправильный вывод!", "Point()\nPoint3d()\n(4.0, 5.0, 6.0)\n", to_normalized_string(out.toByteArray()));
    }

    public void test3(){
        Point[] arr = new Point[2];
        arr[0] = new Point(2,3);
        arr[1] = new Point3d(4,5,6);
        arr[0].print();
        arr[1].print();

        assertEquals("Неправильный вывод!", "Point()\nPoint()\nPoint3d()\n(2.0, 3.0)\n(4.0, 5.0, 6.0)\n", to_normalized_string(out.toByteArray()));
    }
}
