package Lab4Generics.TransportClasses;

import Lab4Generics.PeopleClasses.Person;

abstract public class Car <T extends Person> extends Vehicle<T> {
    {
        this.setMaxAmountOfPlaces(8);
    }
}
