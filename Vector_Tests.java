import java.io.*;

import junit.framework.TestCase;

public class Vector_Tests extends TestCase {

    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    protected void setUp() throws IOException{
        System.setOut(new PrintStream(out));
    }

    public void test1() {
        Vector v = new Vector();
        v.insert(88, 0);
        v.insert(99, 1);
        assertEquals("Неправильно сработало добавление:", 88.0+" "+99.0, v.get(0)+" "+v.get(1));
        assertEquals("Неправильный размер вектора после добавления:", 2, v.getSize());
    }

    public void test2(){
        Vector v = new Vector();
        v.print();
        assertEquals("Неправильный вывод:", "Empty", out.toString().trim());
        out.reset();

        v.insert(8.8, 0);
        v.insert(9.9, 1);
        assertEquals("Неправильный размер вектора после добавления:", 2, v.getSize());
        v.print();
        assertEquals("Неправильно сработало добавление:", "8.8 9.9", out.toString().trim());
        out.reset();

        v.insert(5.5, 0);
        v.print();
        assertEquals("Неправильно сработало добавление:", "5.5 8.8 9.9", out.toString().trim());
        out.reset();

        v.set(-2, 0);
        assertEquals("Неправильно сработало set():", -2.0, v.get(0));

        v.erase(0);
        assertEquals("Неправильно сработало erase():", 2, v.getSize());
        assertEquals("Неправильно сработало erase():", 8.8, v.get(0));

        Vector vc = new Vector(100);
        assertEquals("Ошибка с размером:", 0, vc.getSize());
        vc.insert(99, 0);
        assertEquals("Ошибка с размером:", 1, vc.getSize());
        assertEquals("Неправильно сработало добавление:", 99.0, vc.get(0));

    }

    public void test3(){
        boolean ae_ok = false;
        try{
            Vector v = new Vector(0);
        }catch(AssertionError e){
            ae_ok = true;
        }
        assertTrue("Создание вектора объемом 0 должно было вызвать ошибку AssertionError!", ae_ok);
        ae_ok = false;

////////////////////////////////////////

        Vector v = new Vector();
        v.insert(88, 0);

        try{
            v.insert(99, 2);
        }catch(AssertionError e){
            ae_ok = true;
        }
        assertTrue("Вставка в несуществующую позицию должна была вызвать ошибку AssertionError!", ae_ok);
        ae_ok = false;

        try{
            v.insert(99, -1);
        }catch(AssertionError e){
            ae_ok = true;
        }
        assertTrue("Вставка в несуществующую позицию должна была вызвать ошибку AssertionError!", ae_ok);

///////////////////////////////////////

        try{
            v.set(100, 1);
        }catch(AssertionError e){
            ae_ok = true;
        }
        assertTrue("Доступ к несуществующему элементу должен был вызвать ошибку AssertionError!", ae_ok);
        ae_ok = false;

        try{
            v.set(100, 2);
        }catch(AssertionError e){
            ae_ok = true;
        }
        assertTrue("Доступ к несуществующему элементу должен был вызвать ошибку AssertionError!", ae_ok);
        ae_ok = false;

        try{
            v.set(100, -1);
        }catch(AssertionError e){
            ae_ok = true;
        }
        assertTrue("Доступ к несуществующему элементу должен был вызвать ошибку AssertionError!", ae_ok);
        ae_ok = false;
/////////////////////////////////////

        try{
            v.get(1);
        }catch(AssertionError e){
            ae_ok = true;
        }
        assertTrue("Доступ к несуществующему элементу должен был вызвать ошибку AssertionError!", ae_ok);
        ae_ok = false;

        try{
            v.get(2);
        }catch(AssertionError e){
            ae_ok = true;
        }
        assertTrue("Доступ к несуществующему элементу должен был вызвать ошибку AssertionError!", ae_ok);
        ae_ok = false;

        try{
            v.get(-1);
        }catch(AssertionError e){
            ae_ok = true;
        }
        assertTrue("Доступ к несуществующему элементу должен был вызвать ошибку AssertionError!", ae_ok);
        ae_ok = false;

/////////////////////////////////////

        try{
            v.erase(1);
        }catch(AssertionError e){
            ae_ok = true;
        }
        assertTrue("Доступ к несуществующему элементу должен был вызвать ошибку AssertionError!", ae_ok);
        ae_ok = false;

        try{
            v.erase(2);
        }catch(AssertionError e){
            ae_ok = true;
        }
        assertTrue("Доступ к несуществующему элементу должен был вызвать ошибку AssertionError!", ae_ok);
        ae_ok = false;

        try{
            v.erase(-1);
        }catch(AssertionError e){
            ae_ok = true;
        }
        assertTrue("Доступ к несуществующему элементу должен был вызвать ошибку AssertionError!", ae_ok);
        ae_ok = false;
    }

    public void test4(){
        double arr[] = {6, 5, 4, 3, 2, 1};
        Vector va = new Vector(arr);

        assertEquals("Неправильный размер вектора:", 6, va.getSize());
        va.print();
        assertEquals("Неправильное содержимое:", "6.0 5.0 4.0 3.0 2.0 1.0", out.toString().trim());
        out.reset();

        arr[3] = 100;
        assertTrue("Содержимое вектора не должно было измениться:", va.get(3)==3.0);

        Vector v = new Vector(18);

        v.insert(5.5, 0);
        v.print();
        assertEquals("Неправильный размер вектора:", 1, v.getSize());
        assertEquals("Неправильное содержимое:", "5.5", out.toString().trim());
        out.reset();
    }

    public void test5(){
        Vector b = new Vector(20);
        b.insert(33, 0);
        b.insert(32, 0);
        assertEquals("Неправильный размер вектора:", 2, b.getSize());
        b.erase(1);  // leave 32
        assertEquals("Неправильный размер вектора:", 1, b.getSize());
        for(int i=0; i<20; i++){
            b.insert(i, b.getSize());
        }
        assertEquals("Неправильный размер вектора:", 21, b.getSize());
        assertEquals("Неправильное содержимое вектора:", 19.0, b.get(b.getSize()-1));
    }

    public void test6(){
        final int M = 1024*1024 / 8;  // 1 Mb
        Vector ins = new Vector(32);
        for(int i=0; i<60*M; i++){
            ins.insert(i+8, i);
        }

        // Это не должно зависнуть :)
    }

    public void test7(){
        // const
        double arr[] = {6, 5, 4, 3, 2, 1};
        Vector va = new Vector(arr);

        Vector cc = (Vector)va.clone();
        assertTrue("Вектора должны были получиться одинакового размера!", cc.getSize() == va.getSize());
        cc.print();
        assertEquals("Содержимое копии должно совпадать с содержимым оригинала:", "6.0 5.0 4.0 3.0 2.0 1.0", out.toString().trim());
        out.reset();

        cc.set(-1,1);
        assertTrue("Изменение одного вектора не должно приводить к изменению другого!", va.get(1)==5.0);

        // clear
        cc.clear();
        cc.print();
        assertEquals("Должен был получиться пустой вектор:", "Empty", out.toString().trim());
    }

}
