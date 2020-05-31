package Lab4Generics.TransportClasses;

import Lab4Generics.MyExcep.ExcepNoPass;
import Lab4Generics.MyExcep.ExcepNoPlace;
import Lab4Generics.MyExcep.ExcepPassHere;
import Lab4Generics.MyExcep.ExcepPassInOtherCar;
import Lab4Generics.PeopleClasses.Person;
import java.util.ArrayList;
import java.util.UUID;

//абстрактнй класс транспортного тсредства, от которого наследуются все другие
abstract public class Vehicle <T extends Person> {
    //приватные поля класса
    private int maxAmountOfPlaces;
    private UUID id;
    //публичное поле - список пассажиров
    public ArrayList<T> passengersInVehicle;

    {
        id = UUID.randomUUID();
        passengersInVehicle = new ArrayList<>();
        maxAmountOfPlaces = 20;
    }
    //метод ищет экземпляр класса Пассажир, который поступает на вход, и возвращает 0 или 1
    public boolean isPassengerInVehicle(T passenger){
        return passengersInVehicle.contains(passenger);
    }
    //"садит" пассажира, если есть свободное место И этого пассажира нет в машине
    public  boolean setAPassenger(T passenger){
        if(!isHasFreePlace()) throw new ExcepNoPlace();
        if(!isPassengerInVehicle(passenger))
        {
            if(!passenger.isSeat()){
                passengersInVehicle.add(passenger);
                passenger.setSeat(true);
                return true;
            }
            else
                throw new ExcepPassInOtherCar();
              //System.out.println(new StringBuilder().append(passenger.getId()).append(" is already in some vehicle. Firstly land it"));
        }
        throw new ExcepPassHere();
        //System.out.println(new StringBuilder().append(passenger.getId()).append(" is already in this vehicle."));
        //return false;
    }
    //высадить пассажира из машины
    public boolean landingPassenger(T passenger){
        if(passenger.isSeat() && isPassengerInVehicle(passenger))
        {
            passengersInVehicle.remove(passenger);
            passenger.setSeat(false);
            return true;
        }
        throw new ExcepNoPass();

        //System.out.println(String.valueOf(passenger.getId()) + " is not in " + this.getId());
        //return false;
    }

    //изменить кол-во мест
    void setMaxAmountOfPlaces(int maxAmountOfPlaces){
        this.maxAmountOfPlaces = maxAmountOfPlaces;
    }
    //методы доступа к полям
    public int getMaxAmountOfPlaces() {
        return maxAmountOfPlaces;
    }
    public int getFreePlaces(){
        return getMaxAmountOfPlaces() - passengersInVehicle.size();
    }
    public int getBusyPlaces(){ return passengersInVehicle.size();}
    public UUID getId(){ return id;}

    //есть ли свободное место
    public boolean isHasFreePlace(){
        return getFreePlaces() > 0;
    }

    //отображение всей информации в консоль
    public void displayAllInfo(){
        StringBuilder info = new StringBuilder();
        info.
                append("Type: ").append(this.getClass()).append("\n").
                append("Busy: ").append(getBusyPlaces()).
                append(", Free: ").append(getFreePlaces()).append("\n").
                append(getInfoAboutAllPassenger());
        System.out.println(info);
    }
    //получить инфо о пассажире, возвращает строку
    public String getInfoAboutAllPassenger(){
        StringBuilder info = new StringBuilder();
        for (T vehicle : passengersInVehicle){
            info.append(vehicle.toString()).append("\n");
        }
        return info.toString();
    }
}
