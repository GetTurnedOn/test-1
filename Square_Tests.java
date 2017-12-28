import java.io.*;

import junit.framework.TestCase;

public class Square_Tests extends TestCase {

    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    protected void setUp() throws IOException{
        System.setOut(new PrintStream(out));
    }

    public void test1() {
        Square s = new Square(2);
        s.print();

        assertEquals("Неправильный результат вычисления", 4.0, s.getArea());
        assertEquals("Неправильный результат вычисления", 8.0, s.getPerimeter());
    }

    public void test2(){
        Rectangle r = new Rectangle(2, 3);

        assertEquals("Неправильныая работа конструктора", 2.0, r.getWidth());
        assertEquals("Неправильныая работа конструктора", 3.0, r.getHeight());

        assertEquals("Неправильный результат вычисления", 6.0, r.getArea());
        assertEquals("Неправильный результат вычисления", 10.0, r.getPerimeter());


    }

    public void test3(){
        Square s = new Square(2);

        s.setSide(3);
        assertEquals("Неправильныая работа setSide()", 3.0, s.getSide());

        assertEquals("Неправильный результат вычисления", 9.0, s.getArea());
        assertEquals("Неправильный результат вычисления", 12.0, s.getPerimeter());
    }

}
