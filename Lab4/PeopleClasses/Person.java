package Lab4Generics.PeopleClasses;

import java.util.UUID;

public class Person {
    private UUID id;
    private boolean isSeat;

    {
        id = UUID.randomUUID();
    }

    public void setSeat(boolean seat) {
        isSeat = seat;
    }
    public boolean isSeat() {
        return isSeat;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return new StringBuilder().
                append("Class: ").append(this.getClass()).
                append(". ID: ").append(getId()).
                toString();
    }
}
