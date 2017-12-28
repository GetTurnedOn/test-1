import junit.framework.TestCase;

import java.io.*;
import java.nio.charset.*;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class ShortDate_Tests extends TestCase {
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
        ShortDate d = new ShortDate();
        assertEquals("Вновь созданный объект ShortDate должен быть 1-ым января!", "1.1", d.toString());
        out.reset();

        d.set(13, 12);
        assertEquals("Вызов set(13, 12) должен заменить объект 12-ым декабря!", "13.12", d.toString());
        out.reset();

        assertTrue("Вызов set(13, 12) должен заменить объект 12-ым декабря!", d.getDay()==13 && d.getMonth()==12);
    }

    public void test2(){
        ShortDate d = new ShortDate(3, 2);
        assertTrue("После конструирования new ShortDate(3, 2) ожидалось получить 3-я февраля!", d.getDay()==3 && d.getMonth()==2);

        d.increment();
        assertTrue("После инкремента 3 февраля ожидалось получить 4-е февраля!", d.getDay()==4 && d.getMonth()==2);
    }

    public void test3(){
        ShortDate d1 = new ShortDate();
        assertEquals("Конструктор по умолчанию ничего на экран выводить не должен", "", out.toString());
        ShortDate d2 = new ShortDate(2, 22); // error
        assertEquals("При создании ShortDate(2, 22) ожидалась ошибка!", "Error creating 2.22\n", to_normalized_string(out.toByteArray()));
        out.reset();
        assertTrue("При некоррректном вызове конструктора объект должно все равно создаваться!", d2.getDay()==2 && d2.getMonth()==22);

        assertTrue("Когда дата корректная, метод set() должен возвращать true!", d1.set(13, 12)); // 13 dec OK
        assertFalse("Когда дата некорректная, метод set() должен возвращать false!", d1.set(13,13)); // false
        assertTrue("После некорректного вызова set() содержимое объекта должно было остаться прежним!", d1.getDay()==13 && d1.getMonth()==12);

        ShortDate last = new ShortDate(31, 12);
        assertTrue(last.getDay()==31 && last.getMonth()==12);
        assertFalse("Инкремент 12-го декабря должен давать false!", last.increment()); // false
        assertTrue("Инкремент 12-го декабря должен давать 1-ое января!", last.getDay()==1 && last.getMonth()==1);

        ShortDate minus = new ShortDate(-3, 2);
        assertEquals("Минус 3-го числа не бывает!", "Error creating -3.2\n", to_normalized_string(out.toByteArray()));
        out.reset();

        ShortDate feb = new ShortDate(29, 2);
        assertEquals("29-го февраля не бывает!", "Error creating 29.2\n", to_normalized_string(out.toByteArray()));
        out.reset();
    }

    public void test4(){
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        ShortDate obj = new ShortDate(31, 12);

        for(int m=0; m<12;m++){
            for(int d=1; d<=days[m]; d++){
                obj.increment();
                assertTrue("Неправильно работает инкремент! Ожидалось: " + d+"."+(m+1) +", получено: " + obj.getDay()+"."+obj.getMonth(), d==obj.getDay() && m==obj.getMonth()-1);
            }
        }
    }

    public void test5(){
        ShortDate d = new ShortDate();
        assertTrue(d.set(31,1));
        assertFalse("Нет такой даты!", d.set(31,2));
        assertTrue(d.set(31,3));
        assertFalse("Нет такой даты!", d.set(31,4));
        assertTrue(d.set(31,5));
        assertFalse("Нет такой даты!", d.set(31,6));
        assertTrue(d.set(31,7));
        assertTrue(d.set(31,8));
        assertFalse("Нет такой даты!", d.set(31,9));
        assertTrue("Нет такой даты!", d.set(31,10));
        assertFalse("Нет такой даты!", d.set(31,11));
        assertTrue(d.set(31,12));
    }

    public void test6(){
        ShortDate[] d = new ShortDate[12];
        int i = 0;
        d[i++] = new ShortDate(31,1);
        assertEquals("", out.toString()); out.reset();
        d[i++] = new ShortDate(31,2);
        assertEquals("Error creating 31.2\n", to_normalized_string(out.toByteArray())); out.reset();
        d[i++] = new ShortDate(31,3);
        assertEquals("", out.toString()); out.reset();
        d[i++] = new ShortDate(31,4);
        assertEquals("Error creating 31.4\n", to_normalized_string(out.toByteArray())); out.reset();
        d[i++] = new ShortDate(31,5);
        assertEquals("", out.toString()); out.reset();
        d[i++] = new ShortDate(31,6);
        assertEquals("Error creating 31.6\n", to_normalized_string(out.toByteArray())); out.reset();
        d[i++] = new ShortDate(31,7);
        assertEquals("", out.toString()); out.reset();
        d[i++] = new ShortDate(31,8);
        assertEquals("", out.toString()); out.reset();
        d[i++] = new ShortDate(31,9);
        assertEquals("Error creating 31.9\n", to_normalized_string(out.toByteArray())); out.reset();
        d[i++] = new ShortDate(31,10);
        assertEquals("", out.toString()); out.reset();
        d[i++] = new ShortDate(31,11);
        assertEquals("Error creating 31.11\n", to_normalized_string(out.toByteArray())); out.reset();
        d[i++] = new ShortDate(31,12);
    }
}
