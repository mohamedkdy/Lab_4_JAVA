package Lab4Generics.MyExcep;

public class ExcepNoPlace extends IllegalArgumentException{
    @Override
    public void printStackTrace() {
        System.out.println("\nNo place in this vehicle\n");
        //super.printStackTrace();
    }
}
