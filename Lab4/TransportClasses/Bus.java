package Lab4Generics.TransportClasses;

import Lab4Generics.PeopleClasses.Person;

public class Bus extends Vehicle<Person> {
    {
        this.setMaxAmountOfPlaces(20);
    }
}
