package Lab4Generics;

import Lab4Generics.PeopleClasses.Person;
import Lab4Generics.TransportClasses.Vehicle;

import java.util.ArrayList;
import java.util.List;

//класс дороги
public class Road {
    //приватный список машин на дороге
    private List<Vehicle> carsOnRoad;
    {
        carsOnRoad = new ArrayList<>();
    }
    //публичный параметр, для каждой машини из списка - добавляет к сумме количество пассажиров
    public int getCountOfHumans(){
        int result = 0;
        for(Vehicle vehicle : carsOnRoad)
        {
            result += vehicle.getBusyPlaces();
        }
        return result;
    }
    //публичный метод для получения списка с машинами
    //genrics - особого подхода к описанию данных и алгоритмов,
 позволяющего работать с различными типами данных без изменения их описания.
       
 public List<Vehicle> getCarsOnRoad(){
        return carsOnRoad;
    }

    //публичный метод, принимает параметр - класс машины и возвращает количество машин такого класса в списке
    public int getCountOf(Class clas){

        int result = 0;

            for(Vehicle vehicle : carsOnRoad)
            {
                for(Object obj : vehicle.passengersInVehicle)
                    if(obj.getClass() == clas)
                        ++result;
            }


        return result;
    }
    //проверяет, есть ли этот экземпляр класса в списке, если нету - добавляет
    public boolean addVehicleToRoad(Vehicle<? extends Person> vehicle){
        if(!isVehicleOnRoad(vehicle))
            carsOnRoad.add(vehicle);
        else return false;

        return isVehicleOnRoad(vehicle);
    }
    //проверяет, есть ли этот экземпляр класса в списке, если нету - удаляет из списка
    public boolean removeVehicleFromRoad(Vehicle<? extends Person> vehicle){
        if(isVehicleOnRoad(vehicle))
            carsOnRoad.remove(vehicle);
        else return false;

        return !isVehicleOnRoad(vehicle);
    }
    //проверяет, есть ли этот экземпляр класса в списке
    //проверяет сам экземпляр, а не его параметры, так что если создать машину с такими же параметрами и пассажирами - пропустит
    public boolean isVehicleOnRoad(Vehicle<? extends Person> vehicle)
    {
        return carsOnRoad.contains(vehicle);
    }
}
