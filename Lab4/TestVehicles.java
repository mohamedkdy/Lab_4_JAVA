package Lab4Generics;
import Lab4Generics.MyExcep.ExcepPassInOtherCar;
import Lab4Generics.PeopleClasses.Fireman;
import Lab4Generics.PeopleClasses.Person;
import Lab4Generics.PeopleClasses.Policeman;
import Lab4Generics.TransportClasses.Bus;
import Lab4Generics.TransportClasses.Cars.FireTruck;
import Lab4Generics.TransportClasses.Cars.PoliceCar;
import Lab4Generics.TransportClasses.Cars.Taxi;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestVehicles {

//задаём экземпляры всех нужных классов

    private static Road road;

    private static Person person1;
    private static Person person2;
    private static Person person3;

    private static Policeman pm;
    private static Policeman pm2;
    private static Policeman pm3;

    private static Fireman fm;
    private static Fireman fm2;
    private static Fireman fm3;

    private static Taxi taxi;
    private static Bus bus;
    private static PoliceCar policeCar;
    private static FireTruck fireTruck;

//всё инициализируем и добавляем машины на дорогу
    @BeforeClass
    public static void startMethod(){
        road = new Road();

        person1 = new Person();
        person2 = new Person();
        person3 = new Person();

        pm = new Policeman();
        pm2 = new Policeman();
        pm3 = new Policeman();

        fm = new Fireman();
        fm2 = new Fireman();
        fm3 = new Fireman();

        taxi = new Taxi();
        bus = new Bus();
        policeCar = new PoliceCar();
        fireTruck = new FireTruck();

        road.addVehicleToRoad(taxi);
        road.addVehicleToRoad(bus);
        road.addVehicleToRoad(policeCar);
        road.addVehicleToRoad(fireTruck);
    }
    //для всех тестов, что происходит: assertEquals сравнивает заданный правильный результат с тем что даёт тестируемый метод
//тестируем что все машины пустые
    @Test
    public void aTestEmptyVehicles(){
        assertEquals(0, road.getCountOfHumans());
        assertEquals(0,road.getCountOf(Fireman.class));
        assertEquals(20,bus.getFreePlaces());
        assertEquals(0, taxi.getBusyPlaces());
    }
    //тот и дальше проверяем тестируемые метод на true/false
    //тестируем работает ли метод посадки пассажиров
    @Test
    public void bAddPassengers(){

            assertTrue(taxi.setAPassenger(person1));
            assertTrue(taxi.setAPassenger(fm));
            //assertTrue(taxi.setAPassenger(pm));
            assertTrue(taxi.setAPassenger(person2));

            assertTrue(policeCar.setAPassenger(pm2));
            assertTrue(fireTruck.setAPassenger(fm2));

            assertTrue(bus.setAPassenger(person3));
            assertTrue(bus.setAPassenger(fm3));
            assertTrue(bus.setAPassenger(pm3));

            try{ assertFalse(bus.setAPassenger(pm2)); }
            catch(IllegalArgumentException ex){ ex.printStackTrace(); }

    }
    @Test//(ExpectedException = ExcepPassInOtherCar.class)
    public void test1(){
        taxi.setAPassenger(pm);
        bus.setAPassenger(pm);
    }
    //тестируем высадку пассажиров

    @Test
    public void cLandPassenger(){

            assertEquals(3, bus.getBusyPlaces());
            assertTrue(bus.landingPassenger(person3));
            assertTrue(bus.landingPassenger(fm3));
            assertTrue(bus.landingPassenger(pm3));

            assertEquals(0, bus.getBusyPlaces());

            assertEquals(2, road.getCountOf(Policeman.class));
            assertTrue(taxi.setAPassenger(pm3));
            assertEquals(3, road.getCountOf(Policeman.class));

        try { assertFalse(bus.landingPassenger(person3));  }
        catch (IllegalArgumentException ex){ ex.printStackTrace();   }

        try{assertFalse(taxi.landingPassenger(person3)); }
        catch (IllegalArgumentException ex) {ex.printStackTrace(); }

        try{assertFalse(policeCar.landingPassenger(pm)); }
        catch (IllegalArgumentException ex){ex.printStackTrace();}

    }
    //тестируем можно ли убрать/добавить машины на дорогу

    @Test
    public void dRoadTest(){
        assertFalse(road.removeVehicleFromRoad(new Bus()));
        assertFalse(road.addVehicleToRoad(bus));
        assertTrue(road.removeVehicleFromRoad(taxi));
        assertEquals(2, road.getCountOfHumans());
    }

}
