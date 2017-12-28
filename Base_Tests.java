import java.io.*;
import java.util.*;

import junit.framework.TestCase;

public class Base_Tests extends TestCase {

    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    protected void setUp() throws IOException{
        System.setOut(new PrintStream(out));
    }

    public void test1() {
// ctor
        Vehicle v = new Vehicle(19.5, 60);

// get
        assertEquals("Неправильно сработал конструктор Vehicle(petrol,tank)", 19.5, v.getPetrolAmount());
        assertEquals("Неправильно сработал конструктор Vehicle(petrol,tank)", 60.0, v.getTankVolume());

        Base.vehicles_on_base = 49;
        Base.people_on_base = 84;  // count
        Base.petrol_on_base = 1051;  // liters
        Base.goods_on_base  = 5.032;  // tons

// arrive
        v.arrive();

        assertEquals("Вызов Vehicle.arrive() странно повлиял на бензин", 19.5, v.getPetrolAmount());
        assertEquals("Вызов Vehicle.arrive() странно повлиял на объем бака", 60.0, v.getTankVolume());

        assertEquals("Вызов Vehicle.arrive() неправильно записал данные в \"базу\"", 50, Base.vehicles_on_base);
        assertEquals("Вызов Vehicle.arrive() неправильно записал данные в \"базу\"", 85, Base.people_on_base);
        assertEquals("Вызов Vehicle.arrive() неправильно записал данные в \"базу\"", 1051.0, Base.petrol_on_base);
        assertEquals("Вызов Vehicle.arrive() неправильно записал данные в \"базу\"", 5.032, Base.goods_on_base);

// leave
        assertEquals("Vehicle.leave() вернул неправильное значение", true, v.leave());

        assertEquals("После отъезда бак должен быть полный", 60.0, v.getPetrolAmount());
        assertEquals("Вызов Vehicle.leave() странно повлиял на объем бака", 60.0, v.getTankVolume());


        assertEquals("Вызов Vehicle.leave() неправильно записал данные в \"базу\"", 49, Base.vehicles_on_base);
        assertEquals("Вызов Vehicle.leave() неправильно записал данные в \"базу\"", 84, Base.people_on_base);
        assertEquals("Вызов Vehicle.leave() неправильно записал данные в \"базу\"", 1051.0-(60-19.5), Base.petrol_on_base);
        assertEquals("Вызов Vehicle.leave() неправильно записал данные в \"базу\"", 5.032, Base.goods_on_base);
    }

    public void test2(){
// ctor
        Bus v = new Bus(32, 40, 19.5, 60.0);

        assertEquals("Неправильно сработал конструктор Bus с параметрами", 32, v.getPeopleCount());
        assertEquals("Неправильно сработал конструктор Bus с параметрами", 40, v.getMaxPeople());
        assertEquals("Неправильно сработал конструктор Bus с параметрами", 19.5, v.getPetrolAmount());
        assertEquals("Неправильно сработал конструктор Bus с параметрами", 60.0, v.getTankVolume());

        Base.vehicles_on_base = 49;
        Base.people_on_base = 84;  // count
        Base.petrol_on_base = 1051;  // liters
        Base.goods_on_base  = 5.032;  // tons

// arrive
        v.arrive();

        assertEquals("Вызов Bus.arrive() должен высадить людей", 0, v.getPeopleCount());
        assertEquals("Вызов Bus.arrive() странно повлиял на количество мест", 40, v.getMaxPeople());
        assertEquals("Вызов Bus.arrive() странно повлиял на бензин", 19.5, v.getPetrolAmount());
        assertEquals("Вызов Bus.arrive() странно повлиял на объем бака", 60.0, v.getTankVolume());

        assertEquals("Вызов Bus.arrive() неправильно записал данные в \"базу\"", 50, Base.vehicles_on_base);
        assertEquals("Вызов Bus.arrive() неправильно записал данные в \"базу\"", 85+32, Base.people_on_base);
        assertEquals("Вызов Bus.arrive() неправильно записал данные в \"базу\"", 1051.0, Base.petrol_on_base);
        assertEquals("Вызов Bus.arrive() неправильно записал данные в \"базу\"", 5.032, Base.goods_on_base);

// leave
        assertEquals("Bus.leave() вернул неправильное значение", true, v.leave());

        assertEquals("После отъезда автобус должен быть полный", 40, v.getPeopleCount());
        assertEquals("Вызов Bus.leave() странно повлиял на количество мест", 40, v.getMaxPeople());
        assertEquals("После отъезда бак должен быть полный", 60.0, v.getPetrolAmount());
        assertEquals("Вызов Bus.leave() странно повлиял на объем бака", 60.0, v.getTankVolume());

        assertEquals("Вызов Bus.leave() неправильно записал данные в \"базу\"", 49, Base.vehicles_on_base);
        assertEquals("Вызов Bus.leave() неправильно записал данные в \"базу\"", 84+32-40, Base.people_on_base);
        assertEquals("Вызов Bus.leave() неправильно записал данные в \"базу\"", 1051.0-(60-19.5), Base.petrol_on_base);
        assertEquals("Вызов Bus.leave() неправильно записал данные в \"базу\"", 5.032, Base.goods_on_base);
    }

    public void test3(){
        {
// ctor
            Vehicle v = new Vehicle(19.5, 60);

// get
            assertEquals("Неправильно сработал конструктор Vehicle(petrol,tank)", 19.5, v.getPetrolAmount());
            assertEquals("Неправильно сработал конструктор Vehicle(petrol,tank)", 60.0, v.getTankVolume());

            Base.vehicles_on_base = 49;
            Base.people_on_base = 84;  // count
            Base.petrol_on_base = 1051;  // liters
            Base.goods_on_base  = 5.032;  // tons

// arrive
            v.arrive();

            assertEquals("Вызов Vehicle.arrive() странно повлиял на бензин", 19.5, v.getPetrolAmount());
            assertEquals("Вызов Vehicle.arrive() странно повлиял на объем бака", 60.0, v.getTankVolume());

            assertEquals("Вызов Vehicle.arrive() неправильно записал данные в \"базу\"", 50, Base.vehicles_on_base);
            assertEquals("Вызов Vehicle.arrive() неправильно записал данные в \"базу\"", 85, Base.people_on_base);
            assertEquals("Вызов Vehicle.arrive() неправильно записал данные в \"базу\"", 1051.0, Base.petrol_on_base);
            assertEquals("Вызов Vehicle.arrive() неправильно записал данные в \"базу\"", 5.032, Base.goods_on_base);

            // leave
            assertEquals("Vehicle.leave() вернул неправильное значение", true, v.leave());

            assertEquals("После отъезда бак должен быть полный", 60.0, v.getPetrolAmount());
            assertEquals("Вызов Vehicle.leave() странно повлиял на объем бака", 60.0, v.getTankVolume());


            assertEquals("Вызов Vehicle.leave() неправильно записал данные в \"базу\"", 49, Base.vehicles_on_base);
            assertEquals("Вызов Vehicle.leave() неправильно записал данные в \"базу\"", 84, Base.people_on_base);
            assertEquals("Вызов Vehicle.leave() неправильно записал данные в \"базу\"", 1051.0-(60-19.5), Base.petrol_on_base);
            assertEquals("Вызов Vehicle.leave() неправильно записал данные в \"базу\"", 5.032, Base.goods_on_base);

////////// not enough ////////////
            Vehicle v2 = new Vehicle(50, 100);
            Base.petrol_on_base = 40;
            v2.arrive();
            assertEquals("Когда не хватает бензина, уехать должно быть невозможно", false, v2.leave());

// all the same
            assertEquals("Вызов Vehicle.leave() не должен был ничего поменять на базе", 50, Base.vehicles_on_base);
            assertEquals("Вызов Vehicle.leave() не должен был ничего поменять на базе", 85, Base.people_on_base);
            assertEquals("Вызов Vehicle.leave() не должен был ничего поменять на базе", 40.0, Base.petrol_on_base);
            assertEquals("Вызов Vehicle.leave() не должен был ничего поменять на базе", 5.032, Base.goods_on_base);

//////// exactly //////////
            Base.petrol_on_base = 50;
            assertEquals("Когда бензина хватает, уехать должно быть возможно", true, v2.leave());

// left
            assertEquals("Вызов Vehicle.leave() неправильно записал данные в \"базу\"", 49, Base.vehicles_on_base);
            assertEquals("Вызов Vehicle.leave() неправильно записал данные в \"базу\"", 84, Base.people_on_base);
            assertEquals("Вызов Vehicle.leave() неправильно записал данные в \"базу\"", 0.0, Base.petrol_on_base);
            assertEquals("Вызов Vehicle.leave() неправильно записал данные в \"базу\"", 5.032, Base.goods_on_base);

////////// no driver ////////////
            v2.arrive();
            Base.people_on_base = 0;
            Base.petrol_on_base = 100;
            assertEquals("Когда нет водителя, уехать должно быть невозможно", false, v2.leave());

// same
            assertEquals("Вызов Vehicle.leave() не должен был ничего поменять на базе", 50, Base.vehicles_on_base);
            assertEquals("Вызов Vehicle.leave() не должен был ничего поменять на базе", 0, Base.people_on_base);
            assertEquals("Вызов Vehicle.leave() не должен был ничего поменять на базе", 100.0, Base.petrol_on_base);
            assertEquals("Вызов Vehicle.leave() не должен был ничего поменять на базе", 5.032, Base.goods_on_base);

        }
////////////// BUS ////////////////
        {
// ctor
            Bus v = new Bus(32, 40, 19.5, 60);

// get
            assertEquals("Неправильно сработал конструктор Bus с параметрами", 32, v.getPeopleCount());
            assertEquals("Неправильно сработал конструктор Bus с параметрами", 40, v.getMaxPeople());
            assertEquals("Неправильно сработал конструктор Bus с параметрами", 19.5, v.getPetrolAmount());
            assertEquals("Неправильно сработал конструктор Bus с параметрами", 60.0, v.getTankVolume());

// ctor exact
            Bus v_exact = new Bus(40, 40, 60, 60);
            assertEquals("Неправильно сработал конструктор Bus с параметрами", 40, v_exact.getPeopleCount());
            assertEquals("Неправильно сработал конструктор Bus с параметрами", 40, v_exact.getMaxPeople());

            v_exact.arrive();
            v_exact.leave();

            Base.petrol_on_base = 1051;  // liters
            Base.people_on_base = 84;  // count
            Base.goods_on_base  = 5.032;  // tons
            Base.vehicles_on_base = 49;

// arrive
            v.arrive();

            assertEquals("Вызов Bus.arrive() странно повлиял на бензин", 19.5, v.getPetrolAmount());
            assertEquals("Вызов Bus.arrive() странно повлиял на объем бака", 60.0, v.getTankVolume());

            assertEquals("Вызов Bus.arrive() должен высадить людей", 0, v.getPeopleCount());
            assertEquals("Вызов Bus.arrive() странно повлиял на количество мест", 40, v.getMaxPeople());

            assertEquals("Вызов Bus.arrive() неправильно записал данные в \"базу\"", 50, Base.vehicles_on_base);
            assertEquals("Вызов Bus.arrive() неправильно записал данные в \"базу\"", 85+32, Base.people_on_base);
            assertEquals("Вызов Bus.arrive() неправильно записал данные в \"базу\"", 1051.0, Base.petrol_on_base);
            assertEquals("Вызов Bus.arrive() неправильно записал данные в \"базу\"", 5.032, Base.goods_on_base);

// leave
            assertEquals("Bus.leave() вернул неправильное значение", true, v.leave());

            assertEquals("После отъезда бак должен быть полный", 60.0, v.getPetrolAmount());
            assertEquals("Вызов Bus.leave() странно повлиял на объем бака", 60.0, v.getTankVolume());
            assertEquals("После отъезда автобус должен быть полный", v.getMaxPeople(), v.getPeopleCount());

            assertEquals("Вызов Bus.leave() неправильно записал данные в \"базу\"", 49, Base.vehicles_on_base);
            assertEquals("Вызов Bus.leave() неправильно записал данные в \"базу\"", 84 - (40-32), Base.people_on_base);
            assertEquals("Вызов Bus.leave() неправильно записал данные в \"базу\"", 1051.0 - (60-19.5), Base.petrol_on_base);
            assertEquals("Вызов Bus.leave() неправильно записал данные в \"базу\"", 5.032, Base.goods_on_base);

////////// not enough petrol ////////////
            Bus v2 = new Bus(32, 40, 50, 100);
            Base.petrol_on_base = 40;
            v2.arrive();
            assertEquals("Когда не хватает бензина, уехать должно быть невозможно", false, v2.leave());

// all the same
            assertEquals("Вызов Bus.leave() не должен был ничего поменять на базе", 50, Base.vehicles_on_base);
            assertEquals("Вызов Bus.leave() не должен был ничего поменять на базе", 85-8+32, Base.people_on_base);
            assertEquals("Вызов Bus.leave() не должен был ничего поменять на базе", 40.0, Base.petrol_on_base);
            assertEquals("Вызов Bus.leave() не должен был ничего поменять на базе", 5.032, Base.goods_on_base);

//////// exactly petrol //////////
            Base.petrol_on_base = 50;
            Base.people_on_base = 101; // 100 + driver
            assertEquals("Когда бензина хватает, уехать должно быть возможно", true, v2.leave());

// left
            assertEquals("Вызов Bus.leave() неправильно записал данные в \"базу\"", 49, Base.vehicles_on_base);
            assertEquals("Вызов Bus.leave() неправильно записал данные в \"базу\"", 100-40, Base.people_on_base);
            assertEquals("Вызов Bus.leave() неправильно записал данные в \"базу\"", 0.0, Base.petrol_on_base);
            assertEquals("Вызов Bus.leave() неправильно записал данные в \"базу\"", 5.032, Base.goods_on_base);


//////// just one passanger //////////
            Bus v3 = new Bus(32, 40, 19.5, 60);
            v3.arrive();
            Base.people_on_base = 8;
            Base.petrol_on_base = 100;
            assertEquals("Когда бензина хватает, уехать должно быть возможно", true, v3.leave());

// left
            assertEquals("Вызов Bus.leave() неправильно записал данные в \"базу\"", 49, Base.vehicles_on_base);
            assertEquals("Вызов Bus.leave() неправильно записал данные в \"базу\"", 0, Base.people_on_base);
            assertEquals("Вызов Bus.leave() неправильно записал данные в \"базу\"", 100.0 - (60-19.5), Base.petrol_on_base);
            assertEquals("Вызов Bus.leave() неправильно записал данные в \"базу\"", 5.032, Base.goods_on_base);
        }
    }// test3

    public void test4(){
// ctor
        Truck v = new Truck(3.5, 4.0, 19.5, 60.0);

        assertEquals("Неправильно сработал конструктор Truck с параметрами", 3.5, v.getCurrentLoad());
        assertEquals("Неправильно сработал конструктор Truck с параметрами", 4.0, v.getMaxLoad());
        assertEquals("Неправильно сработал конструктор Truck с параметрами", 19.5, v.getPetrolAmount());
        assertEquals("Неправильно сработал конструктор Truck с параметрами", 60.0, v.getTankVolume());

        Base.vehicles_on_base = 49;
        Base.people_on_base = 84;  // count
        Base.petrol_on_base = 1051;  // liters
        Base.goods_on_base  = 5.032;  // tons

// arrive
        v.arrive();

        assertEquals("Вызов Truck.arrive() должен выгрузить все товары", 0.0, v.getCurrentLoad());
        assertEquals("Вызов Truck.arrive() странно повлиял на грузоподъемность", 4.0, v.getMaxLoad());
        assertEquals("Вызов Truck.arrive() странно повлиял на бензин", 19.5, v.getPetrolAmount());
        assertEquals("Вызов Truck.arrive() странно повлиял на объем бака", 60.0, v.getTankVolume());

        assertEquals("Вызов Truck.arrive() неправильно записал данные в \"базу\"", 50, Base.vehicles_on_base);
        assertEquals("Вызов Truck.arrive() неправильно записал данные в \"базу\"", 85, Base.people_on_base);
        assertEquals("Вызов Truck.arrive() неправильно записал данные в \"базу\"", 1051.0, Base.petrol_on_base);
        assertEquals("Вызов Truck.arrive() неправильно записал данные в \"базу\"", 5.032+3.5, Base.goods_on_base);

// leave
        assertEquals("Truck.leave() вернул неправильное значение", true, v.leave());

        assertEquals("После отъезда грузовик должен быть загружен", v.getMaxLoad(), v.getCurrentLoad());
        assertEquals("После отъезда бак должен быть полный", 60.0, v.getPetrolAmount());
        assertEquals("Вызов Truck.leave() странно повлиял на объем бака", 60.0, v.getTankVolume());

        assertEquals("Вызов Truck.leave() неправильно записал данные в \"базу\"", 49, Base.vehicles_on_base);
        assertEquals("Вызов Truck.leave() неправильно записал данные в \"базу\"", 84, Base.people_on_base);
        assertEquals("Вызов Truck.leave() неправильно записал данные в \"базу\"", 1051.0-(60-19.5), Base.petrol_on_base);
        assertEquals("Вызов Truck.leave() неправильно записал данные в \"базу\"", 5.032+3.5-4.0, Base.goods_on_base);
    }

    public void test5(){
// ctor
        Truck v = new Truck(3.5, 4.0, 19.5, 60);

// get
        assertEquals("Неправильно сработал конструктор Truck с параметрами", 3.5, v.getCurrentLoad());
        assertEquals("Неправильно сработал конструктор Truck с параметрами", 4.0, v.getMaxLoad());
        assertEquals("Неправильно сработал конструктор Truck с параметрами", 19.5, v.getPetrolAmount());
        assertEquals("Неправильно сработал конструктор Truck с параметрами", 60.0, v.getTankVolume());

// ctor exact
        Truck v_exact = new Truck(4.0, 4.0, 60, 60);
        assertEquals("Неправильно сработал конструктор Truck с параметрами", 4.0, v_exact.getCurrentLoad());
        assertEquals("Неправильно сработал конструктор Truck с параметрами", 4.0, v_exact.getMaxLoad());

        v_exact.arrive();
        v_exact.leave();

        Base.petrol_on_base = 1051;  // liters
        Base.people_on_base = 84;  // count
        Base.goods_on_base  = 5.032;  // tons
        Base.vehicles_on_base = 49;

// arrive
        v.arrive();

        assertEquals("Вызов Truck.arrive() странно повлиял на бензин", 19.5, v.getPetrolAmount());
        assertEquals("Вызов Truck.arrive() странно повлиял на объем бака", 60.0, v.getTankVolume());

        assertEquals("Вызов Truck.arrive() должен выгрузить товары", 0.0, v.getCurrentLoad());
        assertEquals("Вызов Truck.arrive() странно повлиял на грузопоъемность", 4.0, v.getMaxLoad());

        assertEquals("Вызов Truck.arrive() неправильно записал данные в \"базу\"", 50, Base.vehicles_on_base);
        assertEquals("Вызов Truck.arrive() неправильно записал данные в \"базу\"", 85, Base.people_on_base);
        assertEquals("Вызов Truck.arrive() неправильно записал данные в \"базу\"", 1051.0, Base.petrol_on_base);
        assertEquals("Вызов Truck.arrive() неправильно записал данные в \"базу\"", 5.032+3.5, Base.goods_on_base);

// leave
        assertEquals("Truck.leave() вернул неправильное значение", true, v.leave());

        assertEquals("После отъезда бак должен быть полный", 60.0, v.getPetrolAmount());
        assertEquals("Вызов Truck.leave() странно повлиял на объем бака", 60.0, v.getTankVolume());
        assertEquals("После отъезда автобус должен быть полный", v.getMaxLoad(), v.getCurrentLoad());

        assertEquals("Вызов Truck.leave() неправильно записал данные в \"базу\"", 49, Base.vehicles_on_base);
        assertEquals("Вызов Truck.leave() неправильно записал данные в \"базу\"", 84, Base.people_on_base);
        assertEquals("Вызов Truck.leave() неправильно записал данные в \"базу\"", 1051.0 - (60-19.5), Base.petrol_on_base);
        assertEquals("Вызов Truck.leave() неправильно записал данные в \"базу\"", 5.032+3.5-4.0, Base.goods_on_base);

////////// not enough petrol ////////////
        Truck v2 = new Truck(3.5, 4.0, 50, 100);
        Base.petrol_on_base = 40;
        Base.goods_on_base = 5.032;
        v2.arrive();
        assertEquals("Когда не хватает бензина, уехать должно быть невозможно", false, v2.leave());

// all the same
        assertEquals("Вызов Truck.leave() не должен был ничего поменять на базе", 50, Base.vehicles_on_base);
        assertEquals("Вызов Truck.leave() не должен был ничего поменять на базе", 85, Base.people_on_base);
        assertEquals("Вызов Truck.leave() не должен был ничего поменять на базе", 40.0, Base.petrol_on_base);
        assertEquals("Вызов Truck.leave() не должен был ничего поменять на базе", 5.032+3.5, Base.goods_on_base);

//////// exactly petrol //////////
        Base.petrol_on_base = 50;
        Base.people_on_base = 101; // 100 + driver
        assertEquals("Когда бензина хватает, уехать должно быть возможно", true, v2.leave());

// left
        assertEquals("Вызов Truck.leave() неправильно записал данные в \"базу\"", 49, Base.vehicles_on_base);
        assertEquals("Вызов Truck.leave() неправильно записал данные в \"базу\"", 100, Base.people_on_base);
        assertEquals("Вызов Truck.leave() неправильно записал данные в \"базу\"", 0.0, Base.petrol_on_base);
        assertEquals("Вызов Truck.leave() неправильно записал данные в \"базу\"", 5.032+3.5-4.0, Base.goods_on_base);
    }

    public void test6(){
        Base.petrol_on_base = 15000;
        Base.people_on_base= 23;
        Base.goods_on_base  = 1.150;
        Base.vehicles_on_base = 14;

        java.util.Vector<Vehicle> base = new java.util.Vector<Vehicle>();
        for(int test=0; test<1000; test++){

            // add
            if(Math.random() > 0.5){
                // prepare vehicle
                int type = (int)(Math.random() * 3);
                Vehicle v;
                int tank = (int)(Math.random() * 160) + 40;

                // create this type
                if(type==0){
                    v = new Vehicle((int)(Math.random()*tank)+1, tank);
                }// 0
                else if(type==1){
                    int people = (int)(Math.random() * 96) + 5;
                    v = new Bus((int)(Math.random()*people)+1, people, (int)(Math.random()*tank)+1, tank);
                }// 1
                else{
                    assert type==2;
                    int max = (int)(Math.random() * 50) + 1;
                    v = new Truck((Math.random()*max)*0.001, max*0.001, (int)(Math.random()*tank)+1, tank);
                }// 2

                v.arrive();
                base.add(v);
            }// if add
            // else - leave
            else if(!base.isEmpty()){
                int i = (int)(Math.random() * base.size());
                Vehicle v = base.elementAt(i);

                // remember
                int pn = Base.people_on_base;
                int vn = Base.vehicles_on_base;
                double pen = Base.petrol_on_base;
                double gn = Base.goods_on_base;

                if(v.leave() == true){
                    base.remove(i);

                    assertTrue("Счетчики \"базы\" не могут быть отрицательными", Base.people_on_base >= 0);
                    assertTrue("Счетчики \"базы\" не могут быть отрицательными", Base.vehicles_on_base >= 0);
                    assertTrue("Счетчики \"базы\" не могут быть отрицательными", Base.petrol_on_base >= 0);
                    assertTrue("Счетчики \"базы\" не могут быть отрицательными", Base.goods_on_base >= 0);
                }// if left
                // not left
                else{
                    assertTrue("Счетчики \"базы\" не должны меняться, если машина не смогла уехать", Base.people_on_base== pn);
                    assertTrue("Счетчики \"базы\" не должны меняться, если машина не смогла уехать", Base.vehicles_on_base == vn);
                    assertTrue("Счетчики \"базы\" не должны меняться, если машина не смогла уехать", Base.petrol_on_base == pen);
                    assertTrue("Счетчики \"базы\" не должны меняться, если машина не смогла уехать", Base.goods_on_base == gn);
                }
            }// if can leave
        }// for test

        // delete others
        while(!base.isEmpty()){
            Vehicle v = base.lastElement();
            base.remove(base.size()-1);
            v.leave();  // may be cannot..
        }

        assertTrue("Счетчики \"базы\" не могут быть отрицательными", Base.people_on_base >= 0);
        assertTrue("Счетчики \"базы\" не могут быть отрицательными", Base.vehicles_on_base >= 0);
        assertTrue("Счетчики \"базы\" не могут быть отрицательными", Base.petrol_on_base >= 0);
        assertTrue("Счетчики \"базы\" не могут быть отрицательными", Base.goods_on_base >= 0);
    }
}
