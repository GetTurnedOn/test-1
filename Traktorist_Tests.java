import java.io.*;
import java.nio.charset.*;
import junit.framework.TestCase;

public class Traktorist_Tests extends TestCase {

    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    protected void setUp() throws IOException{
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
        TraktoristList list = new TraktoristList(10);
        list.add("Petrov", 4.5, 2);
        list.add("Petrov", 4.5);
        list.add("Petrov");
        list.add();

        list.print();

        assertEquals("Перегруженные конструкторы работают неправильно!", "Petrov 4.5 2\nPetrov 4.5 1\nPetrov 4.0 1\nIvanov 4.0 1\n", to_normalized_string(out.toByteArray()));
    }

    public void test2() {
        TraktoristList list = new TraktoristList(10);

        list.add(4.5);
        list.add(4.5, 2);

        list.print();

        assertEquals("Перегруженные конструкторы с оценкой и курсом работают неправильно!", "Ivanov 4.5 1\nIvanov 4.5 2\n", to_normalized_string(out.toByteArray()));
    }

    public void test3() {
        TraktoristList list = new TraktoristList(10);

        list.add(2);
        list.add("Petrov", 2);

        list.print();

        assertEquals("Перегруженные конструкторы без указания оценки работают неправильно!", "Ivanov 4.0 2\nPetrov 4.0 2\n", to_normalized_string(out.toByteArray()));
    }

    // test return true
    public void test4() {
        TraktoristList list = new TraktoristList(10);

        assertTrue("При успешном добалении add() должна возвращать true!", list.add("Petrov", 2));
        assertTrue("При успешном добалении add() должна возвращать true!", list.add(3.5));
    }

    // test return false
    public void test5() {
        TraktoristList list = new TraktoristList(10);

        assertFalse("При неуспешном добалении add() должна возвращать false!", list.add("Petrov", 3));
        assertFalse("При неуспешном добалении add() должна возвращать false!", list.add("Petrov", 0));
        assertFalse("При неуспешном добалении add() должна возвращать false!", list.add("Petrov", -1));

        assertFalse("При неуспешном добалении add() должна возвращать false!", list.add(3));
        assertFalse("При неуспешном добалении add() должна возвращать false!", list.add(0));
        assertFalse("При неуспешном добалении add() должна возвращать false!", list.add(-1));
    }

    // test more exotic false
    public void test6() {
        TraktoristList list = new TraktoristList(10);

        assertFalse("При неуспешном добалении add() должна возвращать false!", list.add(5.2));
        assertFalse("При неуспешном добалении add() должна возвращать false!", list.add(-2.0));

        assertFalse("При неуспешном добалении add() должна возвращать false!", list.add("", 3.0, 2));
    }

    // test overflow
    public void test7() {
        TraktoristList list = new TraktoristList(2);
        list.add("Petrov", 4.5, 2);
        list.add("Petrov", 4.5);

        assertFalse("При переполнении массива должно возвращаться false!", list.add("Petrov"));
    }

}
